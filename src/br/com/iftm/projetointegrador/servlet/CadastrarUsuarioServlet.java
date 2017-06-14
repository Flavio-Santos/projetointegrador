package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.iftm.projetointegrador.dao.Conexao;

/**
 * Servlet implementation class CadastrarUsuarioServlet
 */
@WebServlet(description = "Servlet para efetuar o cadastro de usuarios do sistema", urlPatterns = { "/CadastrarUsuarioServlet" })
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
  
		
        try{
			Connection conexao = (Connection) Conexao.getConexao();
			String sql="SELECT * FROM EVENTO;";
			PreparedStatement stmt=(PreparedStatement) conexao.prepareStatement(sql);
			 ResultSet resultado = stmt.executeQuery();
			 String desc="";
			 while(resultado.next()){
				 desc+= "<br>"+resultado.getString("descricao");
			 }
			 response.getWriter().append(desc);
			 RequestDispatcher rs = request.getRequestDispatcher("teste.jsp");
			 rs.include(request, response);
        }catch(Exception e){
        	response.getWriter().append("n foi"); 
        }
		
			// TODO Auto-generated catch block
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
