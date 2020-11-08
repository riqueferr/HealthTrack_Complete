<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="register-parent">
		<div class="register">

			<a href="/views/login.html" class="arrow-back"> <i
				class="fas fa-arrow-left" style="color: white;"></i>
			</a>
			<div class="register-title">
				<h3>Criar conta</h3>
			</div>
			<form action="usuario" method="post">
				<input type="hidden" value="cadastrar" name="acao">
				<div class="form-group">
					<label for="nome"></label> <input type="text" class="form-control"
						id="nome" placeholder="Nome" name="nome">
				</div>
				<div class="form-group">
					<label for="sobrenome"></label> <input type="text"
						class="form-control" id="sobrenome" placeholder="Sobrenome"
						name="sobrenome">
				</div>
				<div class="form-group">
					<label for="dataNasc"></label> <input type="date"
						class="form-control" id="dataNasc"
						placeholder="Data de Nascimento">
				</div>

				<div class="form-group">
					<label for="email"></label> <input type="email"
						class="form-control" id="email" aria-describedby="emailHelp"
						placeholder="Digite seu email" name="email">
				</div>
				<div class="form-group">
					<label for="senha"></label> <input type="password"
						class="form-control" id="senha" placeholder="Digite sua senha"
						name="senha">
				</div>
				<button type="button" type="submit">Cadastrar</button>
			</form>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>