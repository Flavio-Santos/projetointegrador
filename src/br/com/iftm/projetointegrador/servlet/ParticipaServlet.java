package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iftm.projetointegrador.dao.EventoDAO;
import br.com.iftm.projetointegrador.entity.Evento;
import br.com.iftm.projetointegrador.entity.Voluntario;

/**
 * Servlet implementation class ParticipaServlet
 */
//@WebServlet(description = "Insere o Voluntario na lista de participantes do evento", urlPatterns = { "/ParticipaServlet" })
@WebServlet("/ParticipaServlet")
public class ParticipaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		String idstring = request.getParameter("id");
		Integer id = Integer.parseInt(idstring);
		
		//Pega o usuario que esta logado na sessao
		Voluntario voluntario = new Voluntario();
		if(sessao.getAttribute("voluntario")instanceof Voluntario){
			voluntario = (Voluntario) sessao.getAttribute("voluntario");	
		}else{
			voluntario = null;
		}
		
		//Pega e cria o evento que o usuario clicou
		EventoDAO eventoDao = new EventoDAO();
		Evento evento = new Evento();
		try {
			evento = eventoDao.getEvento(id);
		} catch (NumberFormatException | SQLException e) {
			// TODO Tratar EXCEÇÂO
			e.printStackTrace();
		}
		
		if(voluntario != null && evento != null){
			response.getWriter().append("é nóis 2");
		}else {
			response.getWriter().append("não foi dessa vez<br> nome: " + evento.getNomeevento());
		}
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

}
