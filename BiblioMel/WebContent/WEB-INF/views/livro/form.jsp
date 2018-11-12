<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Livro</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>
<form action="/BiblioMel/livro" method="post">

<h1>Adicionar Livro</h1>
<h1>Titulo: <input type="text" name="titulo"></h1>
<h1>Autor: <input type="text" name="autor"> </h1>
<h1>Editora: <input type="text" name="editora"></h1>
<h1>Data de Publicação: <input type="text" name="dataPublicacao"></h1>
<h1>Edição: <input type="text" name="edicao"> </h1>
<button type="submit">Adicionar</button>
</body>
</html>