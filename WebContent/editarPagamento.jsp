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
				<li class="selected"><i class="fas fa-utensils"></i> <a
					href="pagamento?acao=listar">PAGAMENTOS</a></li>
				<li><i class="fas fa-utensils"></i> <a
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

				<form action="pagamento" method="post">

					<input type="hidden" value="editar" name="acao"><input
						type="hidden" value="${pagamento.codigo }" name="codigo">

					<div class="form-group">

						<label for="id-pagamento">Tipo do Pagamento</label> <select
							name="tipoPagamento" id="id-pagamento" class="form-control">

							<option value="0">Selecione</option>
							<c:forEach items="${tipos }" var="tppag">
								<c:if test="${tppag.codigotp == pagamento.tipoPagamento.codigotp }">
									<option value="${tppag.codigotp }" selected>${tppag.dsTipoPagamento }</option>
								</c:if>
								<c:if test="${tppag.codigotp != pagamento.tipoPagamento.codigotp }">
									<option value="${tppag.codigotp }">${tppag.dsTipoPagamento }</option>
								</c:if>

							</c:forEach>
						</select>

					</div>

					<div class="form-group">

						<label for="id_qtdparcela">Quantidade de Parcelas</label> <input
							type="text" class="form-control" id="id_qtdparcela"
							name="qtdeParcela" value="${pagamento.qtdeParcela }">
					</div>
					<div class="form-group">
						<label for="id-valor">Valor Total</label> <input type="text"
							class="form-control" id="id-valor" name="vlTotal"
							value="${pagamento.vlTotal }">
					</div>
					<div class="form-group">
						<label for="id-usuario">Usuário</label> <input id="id-usuario"
							type=text class="form-control" name="idUsuario"
							value="${pagamento.idUsuario }">
					</div>
					<!--			<div class="form-group">
							<label for="weight">Data</label> <input type="date"
								class="form-control" id="weight">
						</div> -->
					<input type="submit" class="btn btn-primary" value="Salvar">
					<a href="pagamento?acao=listar" class="btn btn-danger">Cancelar</a>
				</form>
			</div>
		</main>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>