package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iftm.projetointegrador.dao.VoluntarioDAO;
import br.com.iftm.projetointegrador.entity.Voluntario;

/**
 * Servlet implementation class CadastrarUsuarioServlet
 */
@WebServlet("/CadastrarUsuarioServlet")
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoluntarioDAO voluntarioDao = new VoluntarioDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("1");
		response.setContentType("text/html;charset=UTF-8");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String nome = request.getParameter("nome");//pega os parametros 
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		//String login, String nome, String senha, String email, String sexo
		Voluntario voluntario = new Voluntario(nome, login, senha, email, sexo);
		try {
			voluntarioDao.insere(voluntario);
		} catch (SQLException e) {
			//TODO tratar amigavelmente
			e.printStackTrace();
		}
		response.sendRedirect("LoginServlet");
	}


}
