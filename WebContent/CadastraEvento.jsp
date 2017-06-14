<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <a href="#!" class="brand-logo">Logo</a>
                    <ul class="right hide-on-med-and-down">
                    <li><a href="perfil.html">Perfil</a></li>
                    <li><a href="eventos.html">Evento</a></li>
                    <li><a href="ranking.html">Ranking</a></li>
                    <li><a href="index.html">Sair</a></li>
                    </ul>
                </div>

            </nav>
        </div>

        <main>
            <div class="row">
                <div class="col l6 offset-l3">
                    <form action="" class="form">
                        <div class="input-field">
                            <input id="nome-evento" type="text">
                            <label for="nome-evento">Nome Evento</label>
                        </div>
                        <div class="input-field">
                            <input id="dt-inicio" type="text">
                            <label for="dt-inicio">Data de Inicio</label>
                        </div>
                        <div class="input-field">
                            <input id="dt-fim" type="text">
                            <label for="dt-fim">Data de fim</label>
                        </div>
                        <div class="input-field">
                            <input id="xp" type="text">
                            <label for="xp">Experiência</label>
                        </div>
                        <div class="input-field">
                            <input id="desc-evento" type="text">
                            <label for="desc-evento">Descrição</label>
                        </div>
                        <button type="submit" class="waves-effect waves-light btn" href="">Concluir</button>
                    </form>
                </div>
            </div>

        </main>
    </body>
