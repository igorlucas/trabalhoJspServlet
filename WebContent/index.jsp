<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Demo App Servlet</title>
</head>
<body>
<h1>Biblioteca</h1>
<hr>
<form action="novo"><button>Novo</button></form>
<h2>Lista de Livros</h2>
<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Resumo</th>
                <th>Ano Lançamento</th>
            </tr>
        </thead>
         <tbody>
            <c:forEach items="${livros}" var="livro">
                <tr>
                    <td>${livro.id}</td>
                    <td>${livro.titulo}</td>
                    <td>${livro.autor}</td>
                    <td>${livro.resumo}</td>
                    <td>${livro.anoLancamento}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>