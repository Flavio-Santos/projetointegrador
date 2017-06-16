package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iftm.projetointegrador.dao.VoluntarioDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VoluntarioDAO voluntarioDao = new VoluntarioDAO();

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		//HttpSession sessao=request.getSession();
		
		try {
			if (voluntarioDao.verificaLogin(login, senha)){
				//Voluntario voluntario = voluntarioDao.getVoluntario(login);
				//sessao.setAttribute("voluntario", voluntarioDao.getVoluntario(login));
				RequestDispatcher dispatcher = request.getRequestDispatcher("EventoServlet");
				dispatcher.forward(request, response);
			}
			else {
				response.sendRedirect("index.jsp");
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			
			response.sendRedirect("index.jsp");
		}
	
	}

}
