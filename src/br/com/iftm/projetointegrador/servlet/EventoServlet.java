package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iftm.projetointegrador.dao.EventoDAO;

/**
 * Servlet implementation class EventoServlet
 */
@WebServlet("/EventoServlet")
public class EventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EventoDAO eventoDao = new EventoDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			request.setAttribute("eventos", eventoDao.getEventos());
		} catch(SQLException e){
			request.setAttribute("mensagem", "erro");
		}
		
		//response.sendRedirect("/home.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}