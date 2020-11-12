<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp" />
<title>Insert title here</title>
</head>
<body>

	<div class="login">
		<div class="login-form">
			<div class="register2">
				<div class="register-title">
					<h3>Entrar</h3>
				</div>
				<c:if test="${empty user }">
					<span class="navbar-text text-danger" style="margin-right: 10px">
						${erro } </span>
					<form action="login" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="email"
								placeholder="Email">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="senha"
								placeholder="Senha">
						</div>
						<!-- add container fluid -->
						<div class="container-fluid">
							<!-- add justify -->
							<div class="row justify-content-center">
								<button type="submit">Entrar</button>
							</div>
						</div>
					</form>
				</c:if>
				<c:if test="${not empty user }">
					<span class="navbar-text"> ${user } <a href="login"
						class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
					</span>
				</c:if>
			</div>
		</div>


		<div class="banner-login">
			<img src="resources/images/logo laranja.png" alt="Logo Health Track">
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>