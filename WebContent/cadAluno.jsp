<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Escola</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="scripts/jquery-1.7.1.js"></script>
<script src="scripts/js-webshim/minified/extras/modernizr-custom.js"></script>
<script src="scripts/js-webshim/minified/polyfiller.js"></script>
<script>
	$.webshims.setOptions('forms-ext', { replaceUI: false });
	$.webshims.polyfill('forms-ext');
</script>
</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo">Escola 1/2 Boca</div>
			<nav role="navigation">
				<ul id="mainNav">
		<li><a href="gestCurso.html">Gestão de Cursos</a></li>
			     	<li><a href="gestAluno.html">Gestão de Aluno</a></li>
						</ul>
			</nav>
		</header>

		<div id="content" role="main">
		
		<fieldset>
				<h2>Novo Aluno</h2>
				<form id="form1" action="incluiAluno" method="post">
					<div>
						<label for="nome">Nome</label>
						<input type="text" name="nome" id="nome" required>
					</div><div>
						<label for="email">Email</label>
						<input type="text" name="email" id="email" required>
					</div>
					<div>
					<label data-tipo="1" for="curso">Curso</label>
					<select name="curso">
						<c:forEach var="cur" items="${cursos}">
							<option value="${cur.id}"><c:out value="${cur.nome}" /></option>
						</c:forEach>
					</select>					
				</div>
					<div>
						<input type="button" id="submitL" value="Voltar" 
							onclick="window.location.replace('index.html');">
						<input type="submit" id="submit" value="Salvar"> 
					</div>
				</form>
			</fieldset>
		</div>

	</div>
</body>
</html>