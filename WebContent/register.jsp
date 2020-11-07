<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<form>
				<div class="form-group">
					<input type="text" class="form-control" id="name"
						placeholder="Nome">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="lastName"
						placeholder="Sobrenome">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="age"
						placeholder="Idade">
				</div>
				<div class="form-group">
					<select class="form-control" id="genre">
						<option value="" disabled selected>Gênero</option>
						<option>Masculino</option>
						<option>Feminino</option>
						<option>Outro</option>
					</select>
				</div>
				<div class="form-group">
					<input type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Digite seu email">
				</div>
				<div class="form-group">
					<input type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Digite sua senha">
				</div>
			</form>
		</div>
		<a href="dashboard.html">
			<button type="button">Cadastrar</button>
		</a>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>