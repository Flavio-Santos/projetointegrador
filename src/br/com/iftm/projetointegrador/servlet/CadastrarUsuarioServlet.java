package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.iftm.projetointegrador.dao.Conexao;
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
		doGet(request, response);
		
		String nome = request.getParameter("nome");//pega os parametros 
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Voluntario voluntario = new Voluntario(nome, email, null, null, null);
		try {
			voluntarioDao.insere(voluntario);
		} catch (SQLException e) {
			//TODO tratar amigavelmente
			e.printStackTrace();
		}
		response.sendRedirect("EventoServlet");
	}


}
