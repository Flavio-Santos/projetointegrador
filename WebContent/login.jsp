<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<jsp:include page="header.jsp" />
		<title>Login</title>
	</head>
	
	

	<body>
		<form id="fom-login">
		  <div class="form-group">
		    <label for="usuario">Usuario:</label>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">
					<span class="glyphicon glyphicon-user"></span>
				</span>
				<input type="text" class="form-control" placeholder="Usuario" id="usuario" aria-describedby="basic-addon1">
			</div>
		  </div>
		
		  <div class="form-group">
		    <label for="email">Email:</label>
			<div class="input-group">
				<input type="email" class="form-control" placeholder="E-mail Cadastrado" id="email">
				<span class="input-group-addon" id="basic-addon2">@gmail.com</span>
			</div>
		  </div>
		  
		  <div class="checkbox">
		    <label><input type="checkbox">Lembrar</label>
		  </div>
		  
		  <button type="submit" class="btn btn-success">Logar</button>
		  <button type="button" class="btn btn-default">Esqueci a senha</button>
		</form>
	</body>
</html>
