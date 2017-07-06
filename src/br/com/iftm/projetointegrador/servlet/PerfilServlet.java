package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iftm.projetointegrador.dao.AdministradorDAO;
import br.com.iftm.projetointegrador.dao.VoluntarioDAO;
import br.com.iftm.projetointegrador.entity.Evento;
import br.com.iftm.projetointegrador.entity.Voluntario;

/**
 * Servlet implementation class Perfil
 */
@WebServlet("/PerfilServlet")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		Voluntario voluntario = new Voluntario();
		if (sessao.getAttribute("voluntario") instanceof Voluntario){
			voluntario = (Voluntario) sessao.getAttribute("voluntario");
		}
		Boolean logado = false;
		if (sessao.getAttribute("logado") instanceof Boolean){
			logado = (Boolean) sessao.getAttribute("logado");
		}
		
		if (logado){
			if (voluntario.getAdmin()){
				AdministradorDAO admdao = new AdministradorDAO();
				
				try {
					List<Evento> eventosPorAdministrador = admdao.eventosPorAdministrador(voluntario);
					sessao.setAttribute("eventosDoAdm", eventosPorAdministrador );
					
				} catch (SQLException e) {
					
				}
				//RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
				//dispatcher.forward(request, response);
			}
				sessao.setAttribute("eventosDoVoluntario", voluntario.getEventos());
				if (voluntario.getEventos().isEmpty()){
					sessao.setAttribute("mensagemEventos", "Você ainda não participou de nenhum evento ainda");
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
				dispatcher.forward(request, response);
			
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
