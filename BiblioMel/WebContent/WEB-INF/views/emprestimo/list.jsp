<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Emprestimos</title>
</head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    top: 50%;
    left: 50%;
    center;
    
     
}
#customers td, #customers th {
    border: 1px solid #FFAEB9;
    padding: 5px;
}
#customers tr:nth-child{background-color: #FFE4E1;}
#customers th {
	
    padding-top: 12px;
    padding-bottom: 5px;
    text-align: center;
    background-color: #FFE4E1;
    color: #FFAEB9;
    }
    
    
    .container {
 	position: absolute;
    top: 20%;
    left: 50%;
    width: 40%;
    transform: translateY(-1%) translateX(-50%);
	center;
	border-radius: 5px;
	background-color: #FFE4E1;
	padding: 30px;
}
.centralizado {
	-webkit-text-stroke-width: 1px; 
    -webkit-text-stroke-color: #000;
	text-align: center;
	color: with ;
}
</style>
<body>
<c:import url= "../menu.jsp"></c:import>

<div class="container">

<div class= "centraliza">
	<h1>Lista de emprestimo</h1>
</div>

<table id="customers">
		<thead>
			<tr>
				
				<th>Nome</th>
				<th>Livro</th>
				<th>Data de Emprestimo</th>
				<th>Data de Devolução</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimos}">
				<tr>
					<td>${emprestimo.aluno.nome}</td>
					<td>${emprestimo.livro.titulo}</td>
					<td><fmt:formatDate value="${emprestimo.dataEmp.time}" pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${emprestimo.dataDev.time}" pattern="dd/MM/yyyy" /></td>
					<td><a href="/BiblioMel/emprestimo/devolver?id=${emprestimo.id}">Devolver</a></td>
				</tr>
			</c:forEach>

		</tbody>
		
		

	</table>
	</div>
</body>
</html>