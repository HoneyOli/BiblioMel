<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alunos</title>
</head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 50%;
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
	
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #FFE4E1;
    color: #FFAEB9;
    }
    
    
    .container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 40%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 5px;
	background-color: #FFE4E1;
	padding: 50px;
}
.centralizado {
	-webkit-text-stroke-width: 1px; 
    -webkit-text-stroke-color: #000;
	text-align: center;
	color: LightCoral ;
}
</style>
<body>
<c:import url="../menu.jsp"></c:import>
<div class="container">
		<div class= "centraliza">

	<h1>Lista de Alunos:</h1>

	<table id="customers">
		<thead>
			<tr>
				<th>Matricula</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Data de Nascimento</th>
				<th>Endereço</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${aluno}">
				<tr>
					<td>${aluno.matricula }</td>
					<td>${aluno.nome }</td>
					<td>${aluno.cpf }</td>
					<td><fmt:formatDate value="${aluno.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
					<td>${aluno.endereco }</td>
					<td><a href="/BiblioMel/aluno/remover?id=${aluno.id}">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>