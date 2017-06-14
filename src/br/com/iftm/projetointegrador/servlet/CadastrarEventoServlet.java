package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.iftm.projetointegrador.dao.Conexao;
import br.com.iftm.projetointegrador.dao.EventoDAO;
import br.com.iftm.projetointegrador.entity.Evento;

/**
 * Servlet implementation class CadastrarEventoServlet
 */
@WebServlet("/CadastrarEventoServlet")
public class CadastrarEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventoDAO eventoDao = new EventoDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarEventoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nomeEvento = request.getParameter("nome");//pega os parametros 
		String dtInicio = request.getParameter("dataInicio");
		String dtFim = request.getParameter("dataFim");
		String xp = request.getParameter("xp");
		String descEvento = request.getParameter("desc");
		
		response.getWriter().append("<br>" + nomeEvento + "<br>"+dtInicio + "<br>"+dtFim + "<br>"+descEvento + "<br>" + xp); 
		
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateI = null;
		try {
			dateI = sdf.parse(dtInicio);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		DateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date dateF = null;
		try {
			dateF = sdf2.parse(dtFim);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		response.getWriter().append("<br>"+nomeEvento + "<br>"+dateI + "<br>"+ dateF + "<br>"+ descEvento + "<br>"+xp); 
		Evento evento = new Evento(nomeEvento, descEvento, dateI, dateF);
		try {
			eventoDao.insere(evento);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//response.getWriter().append("=" + dateI);
		//response.sendRedirect("EventoServlet");
		
		/*public Evento(String nomeevento, String descricao, Date datainicio, Date datafim, CategoriaEvento categoria, Administrador admin) {
			super();
			this.nomeevento = nomeevento;
			this.descricao = descricao;
			this.idadmin = admin.getId();;
			this.datainicio = datainicio;
			this.datafim = datafim;
			this.categoria = categoria;
			categoria.assosiaEvento(this);
			this.admin = admin;
		}
		
		try{
			Connection conexao = (Connection) Conexao.getConexao();
			String sql="SELECT * FROM EVENTO;";
			String sqlInsert = "Insert evento ";
			PreparedStatement stmt=(PreparedStatement) conexao.prepareStatement(sql);
			 ResultSet resultado = stmt.executeQuery();
			 String desc="";
			 while(resultado.next()){
				 desc+= "<br>"+resultado.getString("descricao");
			 }
			 response.getWriter().append(desc);
			 
			 
        }catch(Exception e){
        	response.getWriter().append("<br>n foi"); 
        }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
