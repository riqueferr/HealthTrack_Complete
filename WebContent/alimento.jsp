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
				<li><i class="fas fa-weight "></i> <a href="peso.jsp">PESO
						E ALTURA</a></li>
				<li><i class="fas fa-heartbeat"></i> <a href="pressao.jsp">PRESSÃO
						ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade.jsp">ATIVIDADES
						FÍSICAS</a></li>
				<li><i class="fas fa-calculator"></i> <a href="imc.jsp">IMC</a>
				</li>
				<li class="selected"><i class="fas fa-utensils"></i> <a
					href="alimento.jsp">ALIMENTOS</a></li>
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
			<div class="main-content">
				<div class="panel-row">
					<button class="panel panel-50" a-view="cadastrarAlimento.jsp"
						onclick="fetchContent(this)">
						<i class="fas fa-plus"></i> Cadastrar alimento
					</button>
				</div>
				<c:if test="${not empty msg }">
					<div class="alert alert-success">${msg }</div>
				</c:if>
				<c:if test="${not empty erro }">
					<div class="alert alert-danger">${erro }</div>
				</c:if>
				<div class="content" id="ajax-content"></div>
				<div class="dynamic-content">
					<table class="table table-dark">
						<thead>
							<tr>
								<th scope="col">Data</th>
								<th scope="col">Alimento</th>
								<th scope="col">Quantidade</th>
								<th scope="col">Período</th>
								<th scope="col">Editar</th>
								<th scope="col">Deletar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${alimentos}" var="alimento">
								<tr>
									<td><fmt:formatDate value="${alimento.dtCadastro.time }"
											pattern="dd/MM/yyyy" /></td>
									<td>${alimento.nmAlimento }</td>
									<td>${alimento.qtdeAlimento }</td>
									<td>${alimento.periodoAlimento.dsPeriodo }</td>
									<td><i class="fas fa-edit"></i></td>
									<td><button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#excluirModal"
											onclick="codigoExcluir.value = ${alimento.codigo}">
											Excluir</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</main>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Modal -->
	<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
		aria-labelledby="TituloModalCentralizado" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">DESEJA REALMENTE EXCLUIR?</div>
				<div class="modal-footer">
					<form action="alimento" method="post">
							<input type="hidden" name="acao" value="excluir">
							<input type="hidden" name="codigo" id="codigoExcluir">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Não</button>
						<button type="submit" class="btn btn-primary">Sim</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>