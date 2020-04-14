package com.main.servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.DAO.LivroDAO;
import com.main.Models.Livro;

//@WebServlet("/livros")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static LivroDAO livroDao;
	
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        livroDao = new LivroDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String resumo = request.getParameter("resumo");
		String anoLancamento = request.getParameter("anoLancamento");
 
		try {
			Livro livro = new Livro(titulo, autor, resumo, anoLancamento);
	        livroDao.AdicionarLivro(livro);
	        response.sendRedirect("index");
		} catch (Exception e) {
			// TODO: handle exception
		}
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/novo":
                exibeForm(request, response);
                break;
                
            default:
                listaLivros(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void exibeForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("novo_livro.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listaLivros(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        
        request.setAttribute("livros", livroDao.ListaLivros());
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
}
