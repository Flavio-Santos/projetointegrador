package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iftm.projetointegrador.dao.VoluntarioDAO;
import br.com.iftm.projetointegrador.entity.Voluntario;

/**
 * Servlet implementation class AtualizaUsuario
 */
@WebServlet("/AtualizaUsuario")
public class AtualizaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaUsuario() {
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
		
		
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		
		HttpSession sessao = request.getSession();
		//Pega o usuario que esta logado na sessao
		Voluntario voluntario = new Voluntario();
		if(sessao.getAttribute("voluntario")instanceof Voluntario){
			voluntario = (Voluntario) sessao.getAttribute("voluntario");	
		}else{
			voluntario = null;
		}
		voluntario.setNome(nome);
		voluntario.setSenha(senha);
		VoluntarioDAO voluntarioDao = new VoluntarioDAO();
		try {
			voluntarioDao.atualizaVoluntario(voluntario);
			response.sendRedirect("perfil.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
