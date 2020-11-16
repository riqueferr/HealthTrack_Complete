<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
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
				<li class="selected"><i class="fas fa-weight "></i> <a
					href="imc?acao=listar">PESO E ALTURA</a></li>
				<li><i class="fas fa-heartbeat"></i> <a
					href="pressao?acao=listar">PRESSÃO ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade.jsp">ATIVIDADES
						FÍSICAS</a></li>
				<li><i class="fas fa-calculator"></i> <a href="imc.jsp">IMC</a>
				</li>
				<li><i class="fas fa-utensils"></i> <a
					href="alimento?acao=listar">ALIMENTOS</a></li>
				<li><i class="fas fa-utensils"></i> <a
					href="pagamento?acao=listar">PAGAMENTOS</a></li>
				<li class="sidebar_logout"><i class="fas fa-sign-out-alt"></i>
					<a href="login.jsp">LOGOUT</a></li>
			</ul>
		</div>

		</sidebar>
		<main id="mainContent">
			<header>
				<i id="iconMenu " onclick="responsiveSidebar() "
					class="fas fa-bars "> </i> <a href="login.jsp"><i
					class="fas fa-sign-out-alt "></i> &nbsp; Logout</a>
			</header>


			<div class="main-content">
				<div class="panel-row">
					<button class="panel panel-50" a-view="cadastrarPressao.jsp"
						onclick="fetchContent(this)">
						<i class="fas fa-plus"></i> Cadastrar pressão arterial
					</button>
				</div>
				<div class="content" id="ajax-content"></div>
				<div class="dynamic-content">
					<table class="table table-dark">
						<thead>

							<tr>
								<th scope="col">ID</th>
								<th scope="col">Data</th>
								<th scope="col">mmHg</th>
								<th scope="col">Ações</th>
							</tr>

						</thead>
						<tbody>
							<c:forEach items="${pressoes }" var="pressao">
								<tr>
									<td>${pressao.idPressaoArterial}</td>
									<td><fmt:formatDate value="${pressao.dtCadastro.time }"
											pattern="dd/MM/yyyy" /></td>
									<td>${pressao.nrSistolica }/${pressao.nrDiastolica }</td>
									<td><i class="fas fa-edit"></i>&nbsp;&nbsp;&nbsp; <i
										class="fas fa-trash-alt"></i></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</main>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>