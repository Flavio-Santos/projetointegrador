<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${logado}">
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
		        <title>Perfil</title>
		        <link rel="stylesheet" href="css/materialize.css">
		        <link rel="stylesheet" href="css/estilos.css">
		        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		        <script src="js/jquery-3.2.1.js"></script>
		        <script src="js/materialize.js"></script>
		        <script src="js/efeitos.js"></script>
		    </head>
		    <body>
		
		        <header class="menu">
		            <div class="navbar-fixed">
		                <nav class=" blue lighten-2 menu">
		                    <div class="nav-wrapper container">
		                        <a href="EventoServlet" class="brand-logo"><img src="img/logo.png" class="imgLogo" alt=""></a>
		                    <ul class="right hide-on-med-and-down">
		                        <li><a href="EventoServlet">Home</a></li>
		                        <li class="active"><a href="PerfilServlet">Perfil</a></li>
		                        <li><a href="TodosEventosServlet">Evento</a></li>
		                        <li><a href="LogoutServlet">Sair</a></li>
		                    </ul>
		                    </div>
		                </nav>
		            </div>
		        </header>
		
		        <main class="container">
		            <div class="row caixasUsuario">
		                <div class="col s3 m3 l3 caixa1">
		                    <c:choose>
					         <c:when test = "${admin}">
					         		<img src="img/${voluntario.getLogin()}.jpg" alt="usuario" class="circle">        	
					         </c:when>
					         
					         <c:otherwise>
					            <img src="img/user.png" alt="usuario" class="circle">
					         </c:otherwise>
				      	   </c:choose>
		                </div>
		                <div class="col s9 m9 l9 caixa2">
		                    <p>Login: ${voluntario.getLogin()}</p>
		                    <p>Patente: ${voluntario.getNomepatente()}</p>
		                    <p>Experiência: ${voluntario.getExperiencia()}</p>
		                    <p>Sexo: ${voluntario.getSexo()}</p>
		                </div>
		                <div class="col s12 m12 l12 caixa3">
		                    <form action="AtualizaUsuario" method="post" class="col s12">
		                        <div class="row">
		                        
		                            <div class="input-field col l12">
		                                <input id="nome" type="text" class="validate" name="nome" value="${voluntario.getNome()}">
		                                <label for="nome">Nome</label>
		                            </div>
		
		                            <div class="col l12 input-field">
		                                    <input id="email" type="email" class="validate" name="email" value="${voluntario.getEmail()}">
		                                    <label for="email">Email</label>
		                            </div>
		                            
		                        </div>
		                        <div class="row">
		                            <div class="input-field col l12">
		                                <input id="password" type="password" class="validate" value="">
		                                <label for="password">Senha Antiga</label>
		                            </div>
		                    
		                            <div class="input-field col l6">
		                                <input id="confiPassword" type="password" class="validate" name="senha" value="">
		                                <label for="confiPassword">Nova Senha</label>
		                            </div>
		                            <div class="input-field col l6">
		                                <input id="confiPassword" type="password" class="validate" value="">
		                                <label for="confiPassword">Confirmar Senha</label>
		                            </div>
		                        </div>
		                        <button type="submit" class="modal-action modal-close waves-effect waves-green btn bAmarelo">Atualizar</button>
		                    </form>
		                </div>
		            </div>
		           			
		           			
		           			<c:choose>
		           				<c:when test="${admin}">
		           					<h2>Eventos Criados</h2>
					         		<c:forEach var="evento" items="${eventosDoAdm}">
						         		<ul class="collapsible" data-collapsible="accordion">
										    <li>
										      <div class="collapsible-header">${evento.getNomeevento()}</div>
										      <div class="collapsible-body">
												<form action="ConfirmaParticipacao" method="post">						      
											      	<table>
											      		<c:forEach var="voluntario" items="${evento.getParticipantes()}" >
												      		<tr>
												      			<td>
												      			<input type="hidden" name="codevento" value="${evento.getCodevento()}">
												      			<input  type="checkbox" name="codvoluntario" value="${voluntario.codvoluntario}" id="${voluntario.codvoluntario}"/>
							      								<label for="${voluntario.codvoluntario}">${voluntario.getLogin()}</label>
												      			</td>
												      		</tr>
											      		</c:forEach>
											      	</table>
											      	<button type="submit" class="modal-action modal-close waves-effect waves-green btn bAmarelo">Atualizar</button>
											     </form>
										      </div>
										    </li>
										</ul>
					         		</c:forEach>
		           				</c:when>	
		           			</c:choose>
		           			<h2>Eventos participados</h2>
			         		<span>${mensagemEventos}</span>
			         		<c:forEach var="evento" items="${eventosDoVoluntario}">
			         			<ul >
								    <li>
								      <div class="collapsible-header">${evento.getNomeevento()}</div>
								      <div class="collapsible-body"> </div>
								    </li>
								</ul>
			         		</c:forEach>
			         		
			         		
			         
		      	   
		      	   
		           
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
		    </body>
		</html>
	</c:when>
	
	<c:otherwise>
		<c:redirect url="index.jsp"/>
	</c:otherwise>
</c:choose>
