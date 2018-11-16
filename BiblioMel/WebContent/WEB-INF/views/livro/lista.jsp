<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros</title>
</head>
<body>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 105%;
    top: 50%;
    left: 50%;
    center;
    
     
}
#customers td, #customers th {
    border: 1px solid #FFAEB9;
    padding: 20px;
}
#customers tr:nth-child{background-color: #FFE4E1;}

#customers th {
	
    padding-top:12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #FFE4E1;
    color: #FFAEB9;
    }
    
    
    .container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 50%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 50px;
	background-color: #FFE4E1;
	padding: 50px;
}
.centralizado {
	-webkit-text-stroke-width: 20px; 
    -webkit-text-stroke-color: #000;
	text-align: center;
	color: LightCoral ;
}
</style>
<c:import url="../menu.jsp"></c:import>
<div class="container">
		<div class= "centraliza">
	<h1>Lista de Livros:</h1>

	<table id="customers">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Data de Publicação</th>
				<th>Edição</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livro}">
				<tr>
					<td>${livro.titulo }</td>
					<td>${livro.autor }</td>
					<td>${livro.editora }</td>
					<td><fmt:formatDate value="${livro.dataPublicacao.time}" pattern="dd/MM/yyyy" /></td>
					<td>${livro.edicao }</td>
					<td><a href="/BiblioMel/livro/remover?id=${livro.id}">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>