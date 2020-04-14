
package com.main.Models;

public class Livro {

	 private int Id;
	 private String Titulo;
	 private String Autor;
	 private String Resumo;
	 private String AnoLancamento;
	 
	public Livro(String titulo, String autor, String resumo, String anoLancamento) {
		super();
		Titulo = titulo;
		Autor = autor;
		Resumo = resumo;
		AnoLancamento = anoLancamento;
	}
	
	public Livro(int id, String titulo, String autor, String resumo, String anoLancamento2) {
		super();
		Id = id;
		Titulo = titulo;
		Autor = autor;
		Resumo = resumo;
		AnoLancamento = anoLancamento2;
	}	
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getResumo() {
		return Resumo;
	}

	public void setResumo(String resumo) {
		Resumo = resumo;
	}

	public String getAnoLancamento() {
		return AnoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		AnoLancamento = anoLancamento;
	}
	 
}
