<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #FFE4E1;
}
body {
	background-image: url("https://img.elo7.com.br/product/zoom/1B18C78/painel-biblioteca-frete-gratis-festa-infantil.jpg");
    background-repeat: no-repeat;
	background-size: 1600px 800px;
}
li {
    float: left;
}
li a, .dropbtn {
    display: inline-block;
    color: black;
    text-align: center;
    padding: 14px 150px;
    text-decoration: none;
}
li a:hover, .dropdown:hover .dropbtn {
    background-color: #FFAEB9;
}
li.dropdown {
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 340px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a {
    color: black;
    padding: 16px 16px;
    text-decoration: none;
    display: block;
    text-align: center;
}
.dropdown-content a:hover {background-color: #f1f1f1}
.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<ul>
  <li><a href="/BiblioMel/">Home</a></li>
  
  <li class= "dropdown">
  <a href="javascript:void(0)" class= "dropbtn">Aluno</a>
  <div class="dropdown-content">
      <a href="/BiblioMel/aluno/form">Cadastrar aluno</a>
      <a href="/BiblioMel/aluno/">Listar alunos</a>
    </div></li>
 
 
 <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Livro</a>
    <div class="dropdown-content">
      <a href="/BiblioMel/livro/form">Cadastrar livro</a>
      <a href="/BiblioMel/livro/">Listar livros</a>
    </div>
  </li>
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Emprestimo</a>
    <div class="dropdown-content">
    	<a href="/BiblioMel/emprestimo/form">Fazer Emprestimo</a>
    	<a href="/BiblioMel/emprestimo/listarEmprestimo">Lista de Emprestimos</a>
    	</div>
    </li>
</ul>

</body>
</html>