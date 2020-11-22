<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li class="selected"><i class="fas fa-chart-line"></i> <a
					href="dashboard.jsp">DASHBOARD</a></li>
				<li><i class="fas fa-user-circle"></i> <a href="perfil.jsp">PERFIL</a>
				</li>
				<li><i class="fas fa-weight "></i> <a href="imc?acao=listar">PESO
						E ALTURA</a></li>
				<li><i class="fas fa-heartbeat"></i> <a
					href="pressao?acao=listar">PRESS�O ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade?acao=listar">ATIVIDADES
						F�SICAS</a></li>
				<li><i class="fas fa-calculator"></i> <a href="imc.jsp">IMC</a>
				</li>
				<li><i class="fas fa-utensils"></i> <a
					href="alimento?acao=listar">ALIMENTOS</a></li>
				<li><i class="fas fa-credit-card"></i> <a
					href="pagamento?acao=listar">PAGAMENTOS</a></li>
				<li><i class="fas fa-home"></i> <a
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
				<div class="main-content ">
					<div class="Castle">
						<i class="fas fa-chevron-left"></i> &nbsp; &nbsp;
						<p>HOJE</p>
						&nbsp; &nbsp;<i class="fas fa-chevron-right"></i>
					</div>
					<div class="row justify-content-center">
						<div class='col-sm-10 col-md-10 col-lg-10'>
							<div class="dashboard-kcal">
								<h3>
									369 &nbsp;<span>Kcal</span> <br>
								</h3>
								CALORIAS INGERIDAS
								<div class="p-calorias">
									<p>
										<span>Manh�:</span> 123 Kcal&nbsp;&nbsp;&nbsp;&nbsp; <span>Tarde:</span>
										123 Kcal&nbsp;&nbsp;&nbsp;&nbsp; <span>Noite:</span> 123
										Kcal&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</p>
								</div>
							</div>
						</div>
					</div>
					<!-- <div class="dashboard-flex-parent"> -->
					<div class="row justify-content-center">
						<div class="dashboard-box ">
							<a href="peso.jsp">
								<div class="dashboard-box-wrapper ">
									<div class="box-icon box-pressure ">
										<i class="fas fa-weight " style="color: #353535;"></i>
									</div>
									<div class="value ">72.0 Kg</div>
									<div class="type ">PESO</div>
									<div class="box-value-percentual box-value-pressure "></div>
								</div>
							</a>
						</div>
						<div class="dashboard-box ">
							<a href="imc.jsp">
								<div class="dashboard-box-wrapper ">
									<div class="box-icon box-pressure ">
										<i class="fas fa-calculator " style="color: #353535;"></i>
									</div>
									<div class="value ">22.5 - Normal</div>
									<div class="type ">IMC</div>
									<div class="box-value-percentual box-value-pressure "></div>
								</div>
							</a>
						</div>
						<div class="dashboard-box ">
							<a href="pressao.jsp">
								<div class="dashboard-box-wrapper ">
									<div class="box-icon box-imc ">
										<i class="fas fa-heartbeat " style="color: #353535;"></i>
									</div>
									<div class="value ">120/80 mmHg</div>
									<div class="type ">PRESS�O</div>
									<div class="box-value-percentual box-value-imc "></div>
								</div>
							</a>
						</div>
						<div class="dashboard-box ">
							<a href="atividade.jsp">
								<div class="dashboard-box-wrapper ">
									<div class="box-icon box-workout ">
										<i class="fas fa-dumbbell" style="color: #353535;"></i>
									</div>
									<div class="value ">Corrida</div>
									<div class="type ">ATIVIDADE F�SICA</div>
									<div class="box-value-percentual box-value-workout"></div>
								</div>
							</a>
						</div>
						<div class="dashboard-box ">
							<a href="alimento.jsp">
								<div class="dashboard-box-wrapper ">
									<div class="box-icon box-weight ">
										<i class="fas fa-utensils" style="color: #353535;"></i>
									</div>
									<div class="value ">Banana</div>
									<div class="type ">ALIMENTO</div>
									<div class="box-value-percentual box-value-weight "></div>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>


	<jsp:include page="footer.jsp" />
</body>
</html>