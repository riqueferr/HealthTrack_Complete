<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<li><i class="fas fa-weight "></i> <a href="peso.jsp">PESO
						E ALTURA</a></li>
				<li><i class="fas fa-heartbeat"></i> <a href="pressao.jsp">PRESSÃO
						ARTERIAL</a></li>
				<li><i class="fas fa-running"></i> <a href="atividade.jsp">ATIVIDADES
						FÍSICAS</a></li>
				<li class="selected"><i class="fas fa-calculator"></i> <a href="imc.jsp">IMC</a>
				</li>
				<li><i class="fas fa-utensils"></i> <a href="alimento.jsp">ALIMENTOS</a></li>
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

			<!-- FIM MENU -->

			<div class="main-content">
				<div class="imc-parent">
					<div class="imc">
						<h2>
							Seu IMC é<span> 19,5 &nbsp;&nbsp;<i
								class="fas fa-arrow-right"></i></span> <span class="status-imc-desktop">NORMAL</span>
						</h2>
						<span class="status-imc-mobile">OBESIDADE CL.3</span>

						<div class="img-imc">
							<img src="resources/images/calculadora-tabela-resultados.png"
								alt="">
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>