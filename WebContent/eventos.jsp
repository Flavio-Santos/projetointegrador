<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
        <title>Eventos</title>
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
                        <li><a href="EventoServlet">Home</a></li>
                        <li><a href="perfil.jsp">Perfil</a></li>
                        <li class="active"><a href="TodosEventosServlet">Evento</a></li>
                        <li><a href="LogoutServlet">Sair</a></li>
                    </ul>
                </div>

            </nav>
        </div>

        <main class="container">

            <div class="row todosEventos">
                <div class="col l12">
                    <div class="col l6 offset-l2">
                        <h2 class="tipoLetra">Todos Eventos</h2>
                    </div>
                    <div class="col l3 novoEvento">
                    	<c:choose>
				         <c:when test = "${admin}">
				         		<a class="waves-effect waves-light btn bAmarelo" href="CadastrarEventoServlet">Novo Evento</a>      	
				         </c:when>
			      	   </c:choose>
                    
                        
                    </div>
                </div>

                <div class="col l12">
                    <div class="col s12 m12 l12">
                        <c:forEach var="item" items="${todos}">	
						<div class="card horizontal">
							<div class="card-image">
								<img src="img/${item.getNomecategoriaimg()}.jpg">
							</div>
							<div class="card-stacked">
								<div class="card-content">
									<div class="caixa-eventos">
										<p class="tituloEvento">${item.getNomeevento()}</p>

										<p>Data Fim:
											<fmt:formatDate pattern="dd-MM-yyyy" value="${item.getDatafim()}"/> </p>

										<p>Data Inicio:
											<fmt:formatDate pattern="dd-MM-yyyy" value="${item.getDatainicio()}"/> </p>

										<p>Descrição do Evento: ${item.getDescricao()}</p>

										<p>Categoria do Evento: ${item.getNomecategoria()}</p>

										<p>Experiencia: ${item.getExperiencia()}</p>

										<p>Criador: ${item.getNomeadmin()}</p>
										
									</div>
									
									  <a class="waves-effect waves-light" href="#modal${item.getCodevento()}">Veja quem está Participando</a>
								</div>
								<div class="card-action">
									<form action="ParticipaServlet" method="post">
										<input type="hidden" name="id" value="${item.getCodevento()}">
										<button type="submit" class="botao left back1">
											<a class="waves-effect waves-light btn">Participar</a>
										</button>
									</form>
										
									<!-- Modal Trigger -->
									
									  <!-- Modal Structure -->
									  <div id="modal${item.getCodevento()}" class="modal">
									    <div class="modal-content">
									     
									     	 <p>Participantes do Evento: 
												<c:forEach var="i" items="${item.getNomevoluntarios()}">
													<br><span>${i}</span>
												</c:forEach>
										
											</p>
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

        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/materialize.js"></script>
    </body>
</html>