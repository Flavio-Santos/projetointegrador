<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
	<c:when test="${logado}">
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	
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
						<div class="nav-wrapper container">
							<a href="EventoServlet" class="brand-logo"><img src="img/logo.png" class="imgLogo" alt=""></a>
							<ul class="right hide-on-med-and-down">
								<li class="active"><a href="EventoServlet">Home</a></li>
								<li><a href="PerfilServlet">Perfil</a></li>
								<li><a href="TodosEventosServlet">Evento</a></li>
								<li><a href="LogoutServlet">Sair</a></li>
							</ul>
						</div>

					</nav>
				</div>

				<main class="container">

					<div class="row">
						<div class="col l12">
							<div class="col l6 offset-l5">
								<h2 class="tipoLetra">Ultimos Eventos</h2>
							</div>
						</div>
						
							<div class="col s12 m12 l4 menu-lateral">
								<div class="col l12 avatar">
									<c:choose>
							         <c:when test = "${admin}">
							         		<img src="img/${voluntario.getLogin()}.jpg" alt="usuario" class="circle">        	
							         </c:when>
							         
							         <c:otherwise>
							            <img src="img/user.png" alt="usuario" class="circle">
							         </c:otherwise>
						      	   </c:choose>
								</div>
								<div id="user" class="col l12">
									<h3 class="center tipoLetra">${voluntario.getNome()}</h3>
									<table>
										<tr>
											<td class="tdFixo">XP</td>
											<td class="tdPadding">${voluntario.getExperiencia()}</td>
										</tr>
										<tr>
											<td class="tdFixo">Patente</td>
											<td class="tdPadding">${voluntario.getNomepatente()}</td>
										</tr>

									</table>
								</div>
								<div id="ranking" class="col s12 m12 l12">
									<h5 class="center tipoLetra">Ranking</h5>
									
												<table>
											<c:forEach var="i" items="${ranking}">
														<tr>
															<td><img src="img/crown.png" alt="Coroa de ouro">${i.getNome()}</td>
															<td>${i.getExperiencia()}</td>
														</tr>
												
											</c:forEach>
												</table>
											

								</div>
							</div>



				<div class="col l8">
					<div class="col s12 m12 l12">
					  <c:forEach var="item" items="${eventos}">	
						<div class="card horizontal">
							<div class="card-image">
								<img src="img/${item.getNomecategoriaimg()}.jpg">
							</div>
							<div class="card-stacked">
								<div class="card-content">
									<div class="caixa-eventos">
										<p class="tituloEvento">${item.getNomeevento()}</p>

										<p>Data Fim:
											<fmt:formatDate pattern="dd-MM-yyyy" value="${item.getDatafim()}" /> </p>

										<p>Data Inicio:
											<fmt:formatDate pattern="dd-MM-yyyy" value="${item.getDatainicio()}" /> </p>

										<p>Descrição do Evento: ${item.getDescricao()}</p>

										<p>Categoria do Evento: ${item.getNomecategoria()}</p>

										<p>Experiencia: ${item.getExperiencia()}</p>

										<p>Criador: ${item.getNomeadmin()}</p>
										
									</div>
									
									  <a class="waves-effect waves-light " href="#modal${item.getCodevento()}">Veja quem está Participando</a>
								</div>
								<div class="card-action">
									<form action="ParticipaServlet" method="post">
										<input type="hidden" name="id" value="${item.getCodevento()}">
										<button type="submit" class="botao left back1" style="margin-right:-50px">
											<a class="waves-effect waves-light btn">Participar</a>
										</button>
									</form>
										
									<!-- Modal Trigger -->
									
									  <!-- Modal Structure -->
									  <div id="modal${item.getCodevento()}" class="modal">
									    <div class="modal-content">
									     
									     	 <p style="font-weight: bold; font-size: 1.5em">Participantes do Evento:</p>
												<c:forEach var="i" items="${item.getNomevoluntarios()}">
													<br><span>${i}</span>
												</c:forEach>
										
											
									    </div>
									    <div class="modal-footer">
									      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">FECHAR</a>
									    </div>
									  </div>
										
											
										
									<div id="#modal${item.getCodevento()}" class="modal">
										<div class="modal-content lista">
											<h5>Paticipantes desse evento!</h5>
											<ul>
												<c:forEach var="i" items="${item.getNomevoluntarios()}">
													<li>${i}</li>
												</c:forEach>
											</ul>
										</div>
										
										<div class="modal-footer">
											<a href="#!" class="modal-action modal-close waves-effect waves-green btn bAmarelo">Fechar</a>
										</div>
									</div>
							

								</div>
							</div>
						</div>
						  </c:forEach>

					</div>

					
				
				</div>
					</div>

				</main>
				<footer class="page-footer blue lighten-2">
          <div class="container ">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Proins</h5>
                <p class="grey-text text-lighten-4">Voluntários fazem a diferença!</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Site</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Home</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Perfil</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Evento</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Sair</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
                2017 Todos os direitos Reservados
            </div>
          </div>
        </footer>
				<script src="js/jquery-3.2.1.js"></script>
				<script src="js/materialize.js"></script>
			</body>
	    
	</c:when>
	<c:otherwise>
		<c:redirect url="index.jsp" />
	</c:otherwise>
</c:choose>








