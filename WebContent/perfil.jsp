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
				<li class="selected"><i class="fas fa-user-circle"></i> <a href="perfil.jsp">PERFIL</a>
				</li>
				<li><i class="fas fa-weight "></i> <a href="imc?acao=listar">PESO
						E ALTURA</a></li>
				<li><i class="fas fa-heartbeat"></i> <a
					href="pressao?acao=listar">PRESSÃO ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade?acao=listar">ATIVIDADES
						FÍSICAS</a></li>
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
					<div style="color: white"> Olá, 
					<c:if test="${not empty user }"> ${user }
				</c:if>
				</div>
				<a href="login?acao=sair"><i class="fas fa-sign-out-alt "></i>
					&nbsp; Logout</a>
					
			</header>

			<!-- FIM MENU -->
			<div class="main-content">
				<div class="perfil-parent">
					<div class="perfil">
						<div class="perfil-img">
							<div class="img">
								<p>img</p>
							</div>
						</div>
						<div class="perfil-form">
							<form>
								<div class="form-group">
									<label for="exampleInputEmail1">Definições de saúde</label> <input
										type="text" class="form-control" id="name"
										placeholder="Nome:         Gurizão do Chimarrão">
								</div>
								<div class="form-group">
									<input type="number" class="form-control" id="idade"
										placeholder="Peso:            110 kg">
								</div>
								<div class="form-group">
									<input type="number" class="form-control" id="idade"
										placeholder="Altura:          135 kg">
								</div>
								<div class="form-group">
									<input type="number" class="form-control" id="idade"
										placeholder="Nível de atividade:         Sedentário">
								</div>
								<div class="form-group">
									<label for="email">Dados da conta</label> <input type="email"
										class="form-control" id="email" placeholder="Email">
								</div>
								<div class="form-group">
									<input type="date" class="form-control" id="idade"
										placeholder="Data de Nascimento:        10/12/1976">
								</div>
								<div class="form-group">
									<select class="form-control" id="genre">
										<option value="" disabled selected>Gênero: Masculino</option>
										<option>Masculino</option>
										<option>Feminino</option>
										<option>Outro</option>
									</select> <br>
									<div class="form-group">
										<input type="password" class="form-control" id="password"
											placeholder="Senha">
									</div>
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="customFile">
										<label class="custom-file-label" for="customFile">Choose
											file</label>
									</div>
									<button type="submit" class="btn">Salvar</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>