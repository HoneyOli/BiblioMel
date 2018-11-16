<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Emprestimos</title>
</head>
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
			<c:forEach var="emprestimo" items="${emprestimo }">
				<tr>
					<td>${emprestimo.aluno.nome}</td>
					<td>${emprestimo.livro.titulo }</td>
					<td><fmt:formatDate value="${emprestimo.dataEmp.time}" pattern="dd/MM/yyyy" /></td>
					<c:if test="${empty emprestimo.dataDev}">
							<td class="is-one-third">
								<form method="POST" action="/BiblioMel/emprestimo/devolucao"> 
									<input type="hidden" name="aluno" value="${emprestimo.aluno.id}"/>
									<input type="hidden" name="livro" value="${emprestimo.livro.id}"/>
									<button type="submit" class="button is-info">Fazer Devolução</button>  
								</form>
							</td>
						</c:if>
						<c:if test="${not empty emprestimo.dataDev}">
							<td><fmt:formatDate value="${emprestimo.dataDev.time}" pattern="dd/MM/yyyy" /></td>
						</c:if>
				</tr>
			</c:forEach>

		</tbody>
		
		

	</table>
	</div>
</body>
</html>