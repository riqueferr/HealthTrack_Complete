<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="register-parent">
		<div class="register">

			<a href="login.jsp" class="arrow-back"> <i
				class="fas fa-arrow-left" style="color: white;"></i>
			</a>
			<div class="register-title">
				<h3>Criar conta</h3>
			</div>
			<c:if test="${not empty mensagemUsuario }">
				<div class="alert alert-success">${mensagemUsuario }</div>
			</c:if>
			<c:if test="${not empty mensagemUsuario }">
				<div class="alert alert-danger">${erroUsuario }</div>
			</c:if>
			<form action="usuario" method="post">
				<input type="hidden" value="cadastrar">
				<div class="form-group">
					<label for="id-nome"></label> <input type="text"
						class="form-control" id="id-nome" placeholder="Nome" name="nome">
				</div>
				<div class="form-group">
					<label for="id-sobrenome"></label> <input type="text"
						class="form-control" id="id-sobrenome" placeholder="Sobrenome"
						name="sobrenome">
				</div>
				<div class="form-group">
					<label for="id-dataNasc"></label> <input type="text"
						class="form-control" id="id-dataNasc"
						placeholder="Data de Nascimento" name="dtNasc">
				</div>
				<div class="form-group">
					<label for="id-email"></label> <input type="text"
						class="form-control" id="id-email" aria-describedby="emailHelp"
						placeholder="Digite seu email" name="email">
				</div>
				<div class="form-group">
					<label for="id-senha"></label> <input type="password"
						class="form-control" id="id-senha" placeholder="Digite sua senha"
						name="senha">
				</div>
				<input type="button" type="submit" value="Cadastrar">
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>