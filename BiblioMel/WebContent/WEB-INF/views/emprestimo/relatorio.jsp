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
<h1>Relatório de Emprestimo:</h1>

	<table border="2">
		<thead>
			<tr>
				
				<th>Data de Emprestimo</th>
				<th>Data de Devolução</th>
				<th>Livro</th>
				<th>Aluno</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livros }">
				<tr>
					
					<td>${emprestimo.dataEmprestimo.time }</td>
					<td>${emprestimo.dataDevolucao.time }</td>
					<td>${emprestimo.livro }</td>
					<td>${emprestimo.aluno }</td>		

				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>