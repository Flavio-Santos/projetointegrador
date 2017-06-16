package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iftm.projetointegrador.dao.VoluntarioDAO;
import br.com.iftm.projetointegrador.entity.Voluntario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    VoluntarioDAO voluntarioDao = new VoluntarioDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    

 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		HttpSession sessao=request.getSession();
		
		try {
			if (voluntarioDao.verificaLogin(login, senha)){
				Voluntario voluntario = voluntarioDao.getVoluntario(login);
				sessao.setAttribute("voluntario", voluntario);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EventoServlet");
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
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
