<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
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
				<li><i class="fas fa-chart-line"></i> <a href="dashboard.jsp">DASHBOARD</a></li>
				<li><i class="fas fa-user-circle"></i> <a href="perfil.jsp">PERFIL</a>
				</li>
				<li><i class="fas fa-weight "></i> <a href="imc?acao=listar">PESO
						E ALTURA</a></li>
				<li><i class="fas fa-heartbeat"></i> <a
					href="pressao?acao=listar">PRESS�O ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade.jsp">ATIVIDADES
						F�SICAS</a></li>
				<li><i class="fas fa-calculator"></i> <a href="imc.jsp">IMC</a>
				</li>
				<li><i class="fas fa-utensils"></i> <a
					href="alimento?acao=listar">ALIMENTOS</a></li>
				<li><i class="fas fa-utensils"></i> <a
					href="pagamento?acao=listar">PAGAMENTOS</a></li>
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
				<a href="login.jsp"><i class="fas fa-sign-out-alt "></i> &nbsp;
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

				<form action="alimento" method="post">
					<input type="hidden" value="cadastrar" name="acao">
					<div class="form-group">
						<label for="id-nome">Nome do Alimento</label> <input type="text"
							class="form-control" id="id-nome" name="nmAlimento">
					</div>
					<div class="form-group">
						<label for="id-qtdeAlimento">Qtde Alimento</label> <input
							type="number" class="form-control" id="id-qtdeAlimento"
							name="qtdeAlimento">
					</div>
					<div class="form-group">
						<label for="id-calorias">Qtde Calorias</label> <input
							type="number" class="form-control" id="id-calorias"
							name="qtdeCaloria">
					</div>
					<div class="form-group">
						<label for="id-periodo">Calorias</label> <select name="periodo"
							id="id-periodo" class="form-control">
							<option value="0">Selecione</option>
							<c:forEach items="${periodos }" var="periodo">
								<option value="${periodo.codigo }">${periodo.dsPeriodo }</option>
							</c:forEach>
						</select> <label for="id-usuario">Usuario</label> <input id="id-usuario"
							type=number class="form-control" name="usuario">
					</div>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>
			</div>
		</main>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>