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
				<li><i class="fas fa-heartbeat"></i> <a
					href="pressao?acao=listar">PRESSÃO ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade?acao=listar">ATIVIDADES
						FÍSICAS</a></li>
				<li><i class="fas fa-utensils"></i> <a
					href="alimento?acao=listar">ALIMENTOS</a></li>
				<li><i class="fas fa-utensils"></i> <a
					href="pagamento?acao=listar">PAGAMENTOS</a></li>
				<li class="selected"><i class="fas fa-utensils"></i> <a
					href="endereco?acao=listar">ENDEREÇOS</a></li>
				<li class="sidebar_logout"><i class="fas fa-sign-out-alt"></i>
					<a href="login?acao=sair">LOGOUT</a></li>
			</ul>
		</div>

		</sidebar>
		<main id="mainContent">
			<header>

				<i id="iconMenu " onclick="responsiveSidebar() "
					class="fas fa-bars "> </i>
				<div style="color: white"> Olá, 
					<c:if test="${not empty user }"> ${user }
				</c:if>
				</div>
				<a href="login?acao=sair"><i class="fas fa-sign-out-alt "></i>
					&nbsp; Logout</a>
			</header>

			<!-- FIM MENU -->

			<div class="main-content">
				<div class="panel-row">
					<a href="endereco?acao=abrir-form-cadastro">
						<button class="panel panel-50">
							<i class="fas fa-plus"></i> Cadastrar endereço
						</button>
					</a>
				</div>
				<div class="content" id="ajax-content"></div>

				<div class="dynamic-content">
					<table class="table table-dark">
						<thead>
							<tr>
								<th scope="col">ID Endereço</th>
								<th scope="col">Endereço</th>
								<th scope="col">Editar</th>
								<th scope="col">Deletar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${enderecos }" var="endereco">
								<tr>
									<td>${endereco.idEndereco }</td>
									<td>${endereco.nrCep }</td>
									<td><i class="fas fa-edit"></i></td>
									<td><i class="fas fa-trash-alt"></i></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>