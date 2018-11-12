<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Aluno</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>
<form action="/BiblioMel/aluno" method="post">

<h1>Adicionar Aluno</h1>
<h1>Matricula: <input type="text" name="matricula"></h1>
<h1>Nome: <input type="text" name="nome"> </h1>
<h1>CPF: <input type="text" name="cpf"></h1>
<h1>Data de Nascimento: <input type="text" name="DataNascimento"></h1>
<h1>Endereço: <input type="text" name="endereco"> </h1>
<button type="submit">Adicionar</button>
</body>
</html>