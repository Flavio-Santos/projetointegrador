<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
    <head>
        <title>index</title>
        <link rel="stylesheet" href="css/materialize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/efeitos.js"></script>
    </head>
    <body class="body-main">

        <header class="menu">
            <div class="navbar-fixed">
                <nav class=" blue lighten-1 menu">
                    <div class="nav-wrapper container">
                        <a href="EventoServlet" class="brand-logo"><img src="img/logo.png" class="imgLogo" alt=""></a>
                        <ul class="right hide-on-med-and-down">
                        <li><a href="#sobre">Sobre</a></li>
			          	<li><a href="#eventos">Eventos</a></li>
			          	<li><a href="#colaboradores">Colaboradores</a></li>
                        <li><a class="waves-effect waves-light" href="#modal-login">Login</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>

        <main>
		
            <div id="modal-login" class="modal">
	            <form action="LoginServlet" method="post">
	                <div class="modal-content">
		                    <h4>Faca seu login</h4>
		                    <div class="input-field col l12">
		                        <input id="name" type="text" class="validate" name="login">
		                        <label for="name">Nome de usuario</label>
		                    </div>
		                    <div class="input-field col l12">
		                        <input type="password" id="senha" class="validate" name="senha">
		                        <label for="senha">Senha</label>
		                    </div>
		                    
		                
		                </div>
		                <div class="modal-footer">
		                    <a class="modal-close btn-flat" href="#modal-registrar">Cadastrar</a>
		                    <button type="submit" class="modal-action modal-close waves-effect waves-green btn-flat">Entrar</button>   
		                </div>
	                </form>
            </div>

            <div id="modal-registrar" class="modal">
                <div class="modal-content">
                    <h5>Cadastrar</h5>
                    <!--nome email senha--> 

                    <form action="CadastrarUsuarioServlet" method="post" class="col s12">
                        <div class="row">
                        	<div class="input-field col l12">
                                <input id="login" type="text" class="validate" name="login">
                                <label for="login">Login</label>
                            </div>
                        
                            <div class="input-field col l12">
                                <input id="nome" type="text" class="validate" name="nome">
                                <label for="nome">Nome</label>
                            </div>
                            
                            <div class="col l12">
                                <select id="sexo" name="sexo">
                                    <option value="" disabled selected>Sexo</option>
                                    <option value="M">M</option>
                                    <option value="F">F</option>
                                </select>
                                <label for="sexo">Sexo</label>
                            </div>

                            <div class="row">
                                <div class="input-field col l12">
                                    <input id="email" type="email" class="validate" name="email">
                                    <label for="email">Email</label>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="input-field col l6">
                                <input id="password" type="password" class="validate" name="senha">
                                <label for="password">Senha</label>
                            </div>
                    
                            <div class="input-field col l6">
                                <input id="confiPassword" type="password" class="validate">
                                <label for="confiPassword">Confirmar Senha</label>
                            </div>
                        </div>
                        <button type="submit" class="modal-action modal-close waves-effect waves-green btn-flat">Cadastrar</button>
                    </form>
                
                </div>
            </div>

            <div class="caixa-vazia"></div>
            <div class="row ideia ajusta-ancora">
                <div id="sobre" class="col l12 container">
                    <div class="col l6">
                        <p class="titulos" id="sobre">Sobre</p>
                        <p class="justificado">Sobre o projeto e intencoes</p>
                    </div>
                    <div class="col l6">
                        <p class="titulos" id="sobre">Equipe</p>
                        <p>Sobre a equipe</p>
                    </div>
                </div>
            </div>

            <div class="row staff ajusta-ancora" id="eventos">
            <h1 class="cor-letra-padrao">Eventos Beneficentes</h1>
                <div class="col l6 colaboradores">
                    <div class="card">
					    <div class="card-image waves-effect waves-block waves-light">
					      <img class="activator tamanho-imagem" src="img/doar-sangue.png">
					    </div>
					    <div class="card-content">
					      <span class="card-title activator grey-text text-darken-4">Doar Sangue<i class="material-icons right">more_vert</i></span>
					      <p><a href="http://www.hemominas.mg.gov.br/">Hemocentro de Minas</a></p>
					    </div>
					    <div class="card-reveal">
					      <span class="card-title grey-text text-darken-4">Doar Sangue<i class="material-icons right">close</i></span>
					      <p>desc.</p>
					    </div>
					  </div>
                </div>
                
                <div id="colaboradores" class="col l6 colaboradores">
                    <div class="card ajusta-ancora">
					    <div class="card-image waves-effect waves-block waves-light">
					      <img class="activator tamanho-imagem" src="img/cartas.png">
					    </div>
					    <div class="card-content">
					      <span class="card-title activator grey-text text-darken-4">Campeonatos<i class="material-icons right">more_vert</i></span>
					      <p><a href="http://www.google.com.br/">Campeonatos</a></p>
					    </div>
					    <div class="card-reveal">
					      <span class="card-title grey-text text-darken-4">Varios Campeonatos<i class="material-icons right">close</i></span>
					      <p>desc.</p>
					    </div>
					  </div>
                </div>
                
            </div>
            
            <!-- secao developers-->
            
            <div class="section scrollspy" id="team">
    <div class="desenvol">
        <p class="cor-letra-padrao"> Desenvolvedores </p>
        <div class="row">
            <div class="col s12 m2">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light img-colaboradores">
                        <img class="activator circle" src="img/jordi.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Jordi<br/>
                            <small><em><a class="red-text text-darken-1" href="#">DBA</a></em></small></span>
                        
                    </div>
                </div>
            </div>
            <div class="col s12 m2">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light img-colaboradores">
                        <img class="activator circle" src="img/ronney.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Ronney<br/>
                            <small><em><a class="red-text text-darken-1" href="#">Back-end</a></em></small>
                        </span>
                        
                    </div>
                </div>
            </div>
            <div class="col s12 m2">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light img-colaboradores">
                        <img class="activator circle" src="img/jordana.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Jordana<br/>
                            <small><em><a class="red-text text-darken-1" href="#">Documentacao</a></em></small></span>
                        
                    </div>
                </div>
            </div>
            <div class="col s12 m2">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light img-colaboradores">
                        <img class="activator circle" src="img/flavio.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Flavio<br/>
                            <small><em><a class="red-text text-darken-1" href="#">Front-end</a></em></small></span>
                        
                    </div>
                </div>
            </div>
            
            <div class="col s12 m2">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light img-colaboradores">
                        <img class="activator circle" src="img/ariel.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Ariel<br/>
                            <small><em><a class="red-text text-darken-1" href="#">Back-end</a></em></small></span>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
        </main>
        <footer class="page-footer blue lighten-2">
          <div class="container ">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Proins</h5>
                <p class="grey-text text-lighten-4">Voluntarios fazem a diferença.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                
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
