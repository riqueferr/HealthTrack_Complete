<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp" />
<title>Insert title here</title>
</head>
<body>

  <div class="login">
        <div class="login-form">
            <div class="register2">
                <div class="register-title">
                    <h3>Entrar</h3>
                </div>
                <form>
                    <div class="form-group">
                        <input type="email" class="form-control" id="name" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="lastName" placeholder="Senha">
                    </div>
                    <!-- add container fluid -->
                    <div class="container-fluid">
                        <!-- add justify -->
                        <div class="row justify-content-center">
                            <a href="dashboard.jsp">
                                <button type="button">Entrar</button>
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>


        <div class="banner-login">
            <img src="resources/images/logo laranja.png" alt="Logo Health Track">
        </div>
    </div>

<jsp:include page="footer.jsp" />
</body>
</html>