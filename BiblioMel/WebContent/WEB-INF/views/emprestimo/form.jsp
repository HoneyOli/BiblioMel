<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emprestimo</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>
<div class="container">
	<div class="centralizado">
		<h1>Emprestimo</h1>
	</div>
<form action="/BiblioMel/emprestimo" method="post">
<div class="row">
			
				<div class="col-25">
					<label for="fname">Aluno</label>
				</div>
				
				<div class="col-75">
				<select name="aluno.id">
				<c:forEach var="aluno" items="${aluno }">
					<option value="${aluno.id }">${aluno.nome }</option>
				</c:forEach>
				</select>
				</div>
		</div>
		
		
		<div class="row">
		
				<div class="col-25">
					<label for="fname">Livro</label>
				</div>
				
				<div class="col-75">
				<select name="livro.id">
				<c:forEach var="livro" items="${livro }">
					<option value="${livro.id }">${livro.titulo }</option>
				</c:forEach>
				</select>
				</div>
		</div>
		
		<div class="row">
				<input type="submit" value="Emprestar">
			</div>
	</form>
	</div>

</body>
</html>