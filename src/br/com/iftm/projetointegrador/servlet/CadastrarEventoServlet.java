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
    }

    public String tratarData(String s){
    	if (s.charAt(4) == '-'){
    		String data = "";
    		data += "" + s.charAt(8) + s.charAt(9);
    		data += "/" + s.charAt(5) + s.charAt(6);
    		data += "/" + s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3);
    		return data;
    	}
    	else {
    		return s;
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nomeEvento = request.getParameter("nome");//pega os parametros 
		String dtInicio = tratarData(request.getParameter("dataInicio"));
		String dtFim = tratarData(request.getParameter("dataFim"));
		String xp = request.getParameter("xp");
		String descEvento = request.getParameter("desc");
		
		//response.getWriter().append("<br>" + nomeEvento + "<br>"+dtInicio + "<br>"+dtFim + "<br>"+descEvento + "<br>" + xp); 
		
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		Date dataInicio = null;
		Date dataFim = null;
		
		try {
			dataInicio = formatador.parse(dtInicio);
			dataFim = formatador.parse(dtFim);
		} catch (ParseException e) {
			//TODO Efetuar tratament amigavel
			e.printStackTrace();
		}
		
		//response.getWriter().append("<br>______<br>"+nomeEvento + "<br>"+dataInicio + "<br>"+ dataFim + "<br>"+ descEvento + "<br>"+xp); 
		Evento evento = new Evento(nomeEvento, descEvento, dataInicio, dataFim);
		
		try {
			eventoDao.insere(evento);
		} catch (SQLException e) {
			//TODO tratar amigavelmente
			e.printStackTrace();
		}
	
		response.sendRedirect("EventoServlet");
		
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
