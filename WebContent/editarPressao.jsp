<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="flex-dashboard">
		<sidebar id="sidebar">
		<div class="sidebar-title">
			<img src="resources/images/logo_health_track_espandido_cinza.png"
				alt="Logo Health Track">
		</div>
		<div class="menu">
			<ul>
				<li><i class="fas fa-chart-line"></i> <a
					href="dashboard.jsp">DASHBOARD</a></li>
				<li><i class="fas fa-user-circle"></i> <a href="perfil.jsp">PERFIL</a>
				</li>
				<li><i class="fas fa-weight "></i> <a href="imc?acao=listar">PESO
						E ALTURA</a></li>
				<li class="selected"><i class="fas fa-heartbeat"></i> <a
					href="pressao?acao=listar">PRESS�O ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade?acao=listar">ATIVIDADES
						F�SICAS</a></li>
				<li><i class="fas fa-utensils"></i> <a
					href="alimento?acao=listar">ALIMENTOS</a></li>
				<li><i class="fas fa-utensils"></i> <a
					href="pagamento?acao=listar">PAGAMENTOS</a></li>
				<li><i class="fas fa-utensils"></i> <a
					href="endereco?acao=listar">ENDERE�OS</a></li>
				<li class="sidebar_logout"><i class="fas fa-sign-out-alt"></i>
					<a href="login?acao=sair">LOGOUT</a></li>
			</ul>
		</div>

		</sidebar>
		<main id="mainContent">
			<header>

				<i id="iconMenu " onclick="responsiveSidebar() "
					class="fas fa-bars "> </i>
				<c:if test="${not empty user }"> ${user }
				</c:if>
				<a href="login.jsp""><i class="fas fa-sign-out-alt "></i> &nbsp;
					Logout</a>
			</header>

			<!-- FIM MENU -->

			<div class="container-fluid">
				<c:if test="${not empty msg }">
					<div class="alert alert-success">${msg }</div>
				</c:if>
				<c:if test="${not empty erro }">
					<div class="alert alert-danger">${erro }</div>
				</c:if>

				<div class="dynamic-content">
					<form method="post" action="pressao">
						<input type="hidden" value="editar" name="acao"> <input
						type="hidden" value="${pressao.codigo }" name="codigo">
						<div class="form-group">
							<label for="id_sistolica" style="color: white">Press�o
								Sist�lica</label> <input id="id_sistolica" type="number"
								class="form-control" name="sistolica" value="${pressao.nrSistolica }">
						</div>
						<div class="form-group">
							<label for="id_diastolica" style="color: white">Press�o
								Diast�lica</label> <input id="id_diastolica" type="number"
								class="form-control" name="diastolica" value="${pressao.nrDiastolica }">
						</div>
						<div class="form-group">
							<label for="id_usuario" style="color: white">ID do
								usu�rio</label> <input id="id_usuario" type="number"
								class="form-control" name="idusuario" value="${pressao.idUsuario }">
						</div>
						<input type="submit" class="btn btn-primary" value="Salvar">
					<a href="pressao?acao=listar" class="btn btn-danger">Cancelar</a>
					</form>
				</div>
			</div>
		</main>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>