<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
</head>
<body>
<div class="dynamic-content">
    <form method="post" action="pressoes">
        <div class="form-group">
            <label for="id_sistolica">Pressão Sistólica</label>
            <input id="id_sistolica" type="number" class="form-control" name="sistolica">
        </div>
        <div class="form-group">
            <label for="id_diastolica">Pressão Diastólica</label>
            <input id="id_diastolica" type="number" class="form-control" name="diastolica">
        </div>
        <div class="form-group">
            <label for="id_usuario">ID do usuário</label>
            <input id="id_usuario" type="number" class="form-control" name="idusuario">
        </div>
        
        <button type="submit" class="btn">Cadastrar</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>