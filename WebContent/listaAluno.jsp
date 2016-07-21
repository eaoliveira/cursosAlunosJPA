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
		          <li><a href="gestCurso.xhtml">Gestão de Cursos</a></li>
			     	<li><a href="gestAluno.xhtml">Gestão de Aluno</a></li>
						</ul>
			</nav>
		</header>

		<div id="content" role="main">
		
		<fieldset>
			<h2>Cadastro de Aluno</h2>
		<h3>Total de Alunos Cadastrados: <c:out value="${aluno.size()}" /></h3>
			<c:choose>
				<c:when test="${aluno.size() > 0}">
					<form id="form1" action="removeAluno" method="post">
						<div id="flex">
							<b data-col='1'>Del</b>
							<b data-col='4'>Nome</b>
							<b data-col='4'>Email</b>
							<b data-col='4'>Curso</b>
							<c:forEach var="obj" items="${aluno}">
								<input type="checkbox" name="del" value="${obj.id}" data-col='1'>
								<span data-col='4'><c:out value="${obj.nome}" /></span>
								<span data-col='4'><c:out value="${obj.email}" /></span>
								<span data-col='4'><c:out value="${obj.nomeCurso.nome}" /></span>
							</c:forEach>
						</div>
						<div>
							<input type="submit" id="submit" value="Incluir Alunos" formaction="cadAluno.xhtml"
								formmethod="get">
							<input type="submit" id="submitL" value="Deleta os Alunos">
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<form id="form1">
						<div>
							<input type="submit" id="submit" value="Incluir Alunos" formaction="cadAluno.xhtml">
						</div>
					</form>
				</c:otherwise>
			</c:choose>
		</fieldset>
		</div>

	</div>
</body>
</html>