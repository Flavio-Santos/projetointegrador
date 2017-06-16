<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <head>
        <title>Home</title>
        <link rel="stylesheet" href="css/materialize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/efeitos.js"></script>
    </head>

    <body>
    <div class="navbar-fixed">
    <nav class=" blue lighten-2">
      <div class="nav-wrapper">
        <a href="EventoServlet" class="brand-logo">Logo</a>
        <ul class="right hide-on-med-and-down">
          <li><a href="perfil.html">Perfil</a></li>
          <li><a href="eventos.html">Evento</a></li>
          <li><a href="ranking.html">Ranking</a></li>
          <li><a href="CadastraEvento.jsp">Cadastrar evento</a></li>
          <li><a href="LogoutServlet">Sair</a></li>
        </ul>
      </div>

    </nav>
  </div>

    <main class="container">
      <div class="row">
        <div class="col l3 menu-lateral">
          <img src="img/user.png" alt="usuario" class="circle">
          <div class="col l12">
            <table>
              <tr>
                <td>Nome: </td>
                <td>${voluntario.getNome()}</td>
              </tr>
              <tr>
                <td>XP:</td>
                <td>${voluntario.getExperiencia()}</td>
              </tr>
              <tr>
                <td>Patente</td>
                <td>${voluntario.getNomepatente()}</td>
              </tr>
            </table>
          </div>
        </div>
        <div class="col l8">
          <p>Ultimos eventos</p>
          
			<c:forEach var="item" items="${eventos}">
				<div class="caixa-eventos" >
					<p>${item.getNomeevento()} ${mensagem}</p>
					
					<p><fmt:formatDate pattern = "dd-MM-yyyy" value = "${item.getDatafim()}"/> ||</p>
					
					<p><fmt:formatDate pattern = "dd-MM-yyyy" value = "${item.getDatainicio()}"/> ||</p>
					
					<p>${item.getDescricao()}</p>
					<a class="waves-effect waves-light btn" href="">Participar</a>
				</div>		
			</c:forEach>
			
        </div>
      </div>

    </main>

    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/materialize.js"></script>   
    </body>


