<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Relat�rio de Emprestimo:</h1>

	
		<table border="2">
		<thead>
			<tr>
				
				<th>Id</th>
				<th>Matricula</th>
				<th>Titulo do livro</th>
				<th>Data de Emprestimo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livros }">
				<tr>
					<td>${livro.id }</td>
					<td>${livro.matricula }</td>		
					<td>${livro.dataEmprestimo.time }</td>
					<td>${livro.dataDevolucao.time }</td>
				
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>