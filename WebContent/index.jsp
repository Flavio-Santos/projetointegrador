<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <title>index</title>
        <link rel="stylesheet" href="css/materialize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/efeitos.js"></script>
    </head>
    <body class="body-main">

        <header class="menu">
            <div class="navbar-fixed">
                <nav class=" blue lighten-1 menu">
                    <div class="nav-wrapper container">
                        <a href="#!" class="brand-logo">Logo</a>
                        <ul class="right hide-on-med-and-down">
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
		                    <h4>Faça seu login</h4>
		                    <div class="input-field col l12">
		                        <input id="name" type="text" class="validate" name="login">
		                        <label for="name">Nick name</label>
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
                            
                            <div class="input-field col l12">
                                <input id="sexo" type="text" class="validate" name="sexo">
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
            <div class="row ideia">
                <div class="col l12 container">
                    <div class="col l6">
                        <h3></h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                            Officiis earum nisi sunt beatae odio, libero aut et, distinctio 
                            voluptatem totam quam unde est consectetur at possimus dolores, 
                            esse tempora ipsam.
                        </p>
                    </div>
                    <div class="col l6">
                        <h3></h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                            Officiis earum nisi sunt beatae odio, libero aut et, distinctio 
                            voluptatem totam quam unde est consectetur at possimus dolores, 
                            esse tempora ipsam.
                        </p>
                    </div>
                </div>
            </div>

            <div class="row staff">
                <div class="col l6 colaboradores">
                    <img src="" alt="">
                    <p>descrição</p>
                </div>
                <div class="col l6 colaboradores">
                    <img src="" alt="">
                    <p>descrição</p>
                </div>
                <div class="col l6 colaboradores">
                    <img src="" alt="">
                    <p>descrição</p>
                </div>
                <div class="col l6 colaboradores">
                    <img src="" alt="">
                    <p>descrição</p>
                </div>
                <div class="col l6 colaboradores">
                    <img src="" alt="">
                    <p>descrição</p>
                </div>
            </div>
        </main>
        <footer>

        </footer>
    </body>
