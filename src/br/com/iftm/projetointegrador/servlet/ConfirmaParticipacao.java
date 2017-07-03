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
		HttpSession sessao = request.getSession();
		
		Voluntario admin = new Voluntario();
		if(sessao.getAttribute("voluntario")instanceof Voluntario){
			admin = (Voluntario) sessao.getAttribute("voluntario");	
		}
		
		if (admin.getAdmin()){
			
			String idstring = request.getParameter("codevento");
			Integer idevento = Integer.parseInt(idstring);
			
			EventoDAO eventoDao = new EventoDAO();
			Evento evento = null;
			try {
				evento = eventoDao.getEvento(idevento);
			} catch (NumberFormatException | SQLException e) {
				
			}
			
			String id = request.getParameter("codvoluntario");
			Integer codvoluntario = Integer.parseInt(id);
			
			VoluntarioDAO voluntarioDao = new VoluntarioDAO();
			Voluntario voluntario = null;
			try {
				voluntario = voluntarioDao.getVoluntario(codvoluntario);
			} catch (NumberFormatException | SQLException e) {
				
			}
			
			if(voluntario != null && evento != null){
				try {
					eventoDao.confirmaParticipacao(evento, voluntario);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
