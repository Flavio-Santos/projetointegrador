<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ranking</title>
<link rel="stylesheet" href="css/materialize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/efeitos.js"></script>
</head>
<body>
	<nav class=" blue lighten-2">
      <div class="nav-wrapper">
        <a href="EventoServlet" class="brand-logo">Logo</a>
        <ul class="right hide-on-med-and-down">
          <li><a href="perfil.jsp">Perfil</a></li>
          <li><a href="eventos.jsp">Evento</a></li>
          <li><a href="ranking.jsp">Ranking</a></li>
          <li><a href="CadastrarEventoServlet">Cadastrar evento</a></li>
          <li><a href="LogoutServlet">Sair</a></li>
        </ul>
      </div>

    </nav>
    <main class="container">
    	<div>
    	<h1>Ranking</h1>
			<table>
				<tr>
					<th>Posi��o</th>
					<th>Nome</th>
					<th>Experi�ncia</th>
				</tr>
				<tr>
					<td>1</td>
					<td>Santos</td>
					<td>1200</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Jordi</td>
					<td>900</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Rafa</td>
					<td>850</td>
				</tr>
				<tr>
					<td>4</td>
					<td>Jhon</td>
					<td>800</td>
				</tr>
				<tr>
					<td>5</td>
					<td>Tom</td>
					<td>300</td>
				</tr>
			</table>
    	</div>
    </main>
</body>
