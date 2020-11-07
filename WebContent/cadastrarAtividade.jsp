<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="dynamic-content">
    <form>
        <div class="form-group">
            <label for="weight">Tipo da Atividade</label>
            <input type="text" class="form-control" id="weight">
        </div>
        <div class="form-group">
            <label for="weight">Tempo da Atividade</label>
            <input type="number" class="form-control" id="weight">
        </div>
        <div class="form-group">
            <label for="weight">Distância</label>
            <input type="number" class="form-control" id="weight">
        </div>
        <div class="form-group">
            <label for="weight">Calorias</label>
            <input type="number" class="form-control" id="weight">
        </div>
        <div class="form-group">
            <label for="weight">Data</label>
            <input type="date" class="form-control" id="weight">
        </div>
        <button type="submit" class="btn">Cadastrar</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>