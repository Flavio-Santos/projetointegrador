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
import br.com.iftm.projetointegrador.dao.VoluntarioDAO;
import br.com.iftm.projetointegrador.entity.Evento;
import br.com.iftm.projetointegrador.entity.Voluntario;

/**
 * Servlet implementation class ConfirmaParticipacao
 */
@WebServlet("/ConfirmaParticipacao")
public class ConfirmaParticipacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmaParticipacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sessao = request.getSession();
		VoluntarioDAO voluntarioDao = new VoluntarioDAO();
		
		String codvoluntarios[] = request.getParameterValues("codvoluntario");
		//response.getWriter().append("a" + codvoluntarios[0]);
		
		//Pega o usuario que esta logado na sessao
		Voluntario administrador = new Voluntario();
		if(sessao.getAttribute("voluntario") instanceof Voluntario){
			administrador = (Voluntario) sessao.getAttribute("voluntario");	
		}else{
			administrador = null;
		}
		
		String idstring = request.getParameter("codevento");
		Integer id = Integer.parseInt(idstring);
		
		//Pega e cria o evento que o usuario clicou
		EventoDAO eventoDao = new EventoDAO();
		Evento evento = new Evento();
		try {
			evento = eventoDao.getEvento(id);
		} catch (NumberFormatException | SQLException e) {
			// TODO Tratar EXCEÇÂO
			e.printStackTrace();
		}
		
		if(administrador != null && evento != null){
			administrador.associaEvento(evento);
			for (int i = 0; i < codvoluntarios.length; i++) {
				try {
					Voluntario voluntario = voluntarioDao.getVoluntario(Integer.parseInt(codvoluntarios[i]));
					eventoDao.confirmaParticipacao(evento, voluntario);
					voluntario.addExperiencia(evento.getExperiencia());
					voluntario.associaEvento(evento);
					voluntarioDao.addExperiencia(voluntario);
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			response.sendRedirect("PerfilServlet");
			
		}else {
			response.getWriter().append("Tem que estar logado para participar");
		}
		
	}

}
