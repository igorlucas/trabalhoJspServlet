<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Livro</title>
</head>
<body>
<h1>Cadastrar um novo livro</h1>
<form action="livros" method="post">
    Titulo: <input type="text" name="titulo" size="20"><br>
    Autor: <input type="text" name="autor" size="20"><br>
    Resumo: <textarea rows="4" cols="50" name="resumo"></textarea><br>
    Ano de Lancamento: <input type="date" name="anoLancamento"><br>
    <input type="submit" value="Salvar" />
</form>
</body>
</html>