<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="dynamic-content">
			<form method="post" action="imc">
				<div class="row">
					<div class="col-md-2">
						<div class="form-group">
							<label for="id_peso">Novo peso</label> <input type="text"
								class="form-control" id="id_peso" name="peso">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label for="id_altura">Nova altura</label> <input type="text"
								class="form-control" id="id_altura" name="altura">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="id_usuario">ID Usuario</label> <input type="text"
								class="form-control" id="id_usuario" name="idUsuario">
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="id_valor">IMC</label> <input type="text"
									class="form-control" id="id_valor" name="valor">
							</div>
						</div>
					</div>
				</div>
				<button type="submit" class="btn">Cadastrar</button>
			</form>
		</div>
	</div>
</body>
</html>