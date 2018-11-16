<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Livro</title>
</head>
<style>
body {
	background-image: url("http://weekon.com.ar/wp-content/uploads/2016/12/biblio-web.jpg");
    background-repeat: no-repeat;
	background-size: 1366px 655px;
}

 {
	box-sizing: border-box;
}
input[type=text], select, textarea {
	width: 50%;
	padding: 10px;
	border: 2px solid #FFAEB9;
	border-radius: 5px;
	resize: vertical;
}
label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}
input[type=submit] {
	background-color: #FFAEB9;
	color: white;
	padding: 12px 50px;
	border: none;
	border-radius: 10px;
	cursor: pointer;
	float: right;
}
input[type=submit]:hover {
	background-color: LightCoral;
}
.container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 45%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 20px;
	background-color: #FFE4E1;
	padding: 10px;
}
.centralizado {
	text-align: center;
	margin: 0 auto;
}
.col-25 {
	float: left;
	width: 45%;
	margin-top: 8px;
}
.col-75 {
	float: left;
	width: 70%;
	margin-top: 5px;
}
.row:after {
	content: "";
	display: table;
	clear: both;
}
@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
	
}
</style>
<body>
<c:import url="../menu.jsp"></c:import>
<div class="container">
	<div class="centralizado">
		<h1>Adicionar Livro</h1>
		</div>
		<form action="/BiblioMel/livro" method="post">

			<div class="row">
				<div class="col-25">
					<label for="fname">T�tulo</label>
				</div>
				<div class="col-75">
				<input type="text" id="fname" name="titulo">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="lname">Autor</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="autor" >
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="country">Editora</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="editora">
				</div>
			</div>


			<div class="row">
				<div class="col-25">
					<label for="country">Ano de publica��o</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="dataPublicacao" maxlength="14"placeholder=>
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="country">Edi��o</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="edicao">
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Cadastrar">
			</div>
		</form>
	</div>
</body>
</html>