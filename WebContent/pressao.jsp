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
				<li><i class="fas fa-credit-card"></i> <a
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
					<div style="color: white"> Ol�, 
					<c:if test="${not empty user }"> ${user }
				</c:if>
				</div>
				<a href="login?acao=sair"><i class="fas fa-sign-out-alt "></i>
					&nbsp; Logout</a>
					
			</header>

			<!-- FIM MENU -->


			<div class="main-content">
				<div class="panel-row">
					<a href="pressao?acao=abrir-form-cadastro">
						<button class="panel panel-50">
							<i class="fas fa-plus"></i> Cadastrar press�o arterial
						</button>
					</a>
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
								<th scope="col">ID</th>
								<th scope="col">Data</th>
								<th scope="col">mmHg</th>
								<th scope="col">Editar</th>
								<th scope="col">Excluir</th>
							</tr>

						</thead>
						<tbody>
							<c:forEach items="${pressoes }" var="pressao">
								<tr>
									<td>${pressao.codigo}</td>
									<td><fmt:formatDate value="${pressao.dtCadastro.time }"
											pattern="dd/MM/yyyy" /></td>
									<td>${pressao.nrSistolica }/${pressao.nrDiastolica }</td>
									<td><c:url value="pressao" var="link">
											<c:param name="acao" value="abrir-form-edicao" />
											<c:param name="codigo" value="${pressao.codigo }" />
										</c:url> <a href="${link }">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Editar</button>
									</a></td>
									<td><button type="button" class="btn btn-danger"
											data-toggle="modal" data-target="#excluirModal"
											onclick="codigoExcluir.value = ${pressao.codigo}">
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
					<form action="pressao" method="post">
						<input type="hidden" name="acao" value="excluir"> <input
							type="hidden" name="codigo" id="codigoExcluir">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">N�o</button>
						<button type="submit" class="btn btn-danger">Sim</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>