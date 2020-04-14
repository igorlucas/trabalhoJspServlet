package com.main.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.main.Models.Livro;

 
public class LivroDAO {
      private String jdbcURL;
      private String jdbcUsername;
      private String jdbcPassword;
      private Connection jdbcConnection;
      
    public LivroDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
        
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean AdicionarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO public.Livros (Titulo, Autor, Resumo, AnoLancamento) VALUES (?, ?, ?, ?);";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, livro.getTitulo());
        statement.setString(2, livro.getAutor());
        statement.setString(3, livro.getResumo());
        statement.setString(4, livro.getAnoLancamento());;
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    	
    }
     
    public List<Livro> ListaLivros() throws SQLException {
    	
    	List<Livro> listaLivro = new ArrayList<Livro>();         
        String sql = "SELECT * FROM public.Livros;";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int Id = resultSet.getInt("Id");
            String Titulo = resultSet.getString("Titulo");
            String Autor = resultSet.getString("Autor");
            String Resumo = resultSet.getString("Resumo");
            String AnoLancamento = resultSet.getString("AnoLancamento");
            Livro livro = new Livro(Id, Titulo, Autor, Resumo, AnoLancamento);
            listaLivro.add(livro);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
        return listaLivro;
    }
     

}