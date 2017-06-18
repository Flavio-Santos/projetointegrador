package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iftm.projetointegrador.dao.CategoriaDAO;
import br.com.iftm.projetointegrador.dao.EventoDAO;
import br.com.iftm.projetointegrador.entity.Categoria;
import br.com.iftm.projetointegrador.entity.Evento;
import br.com.iftm.projetointegrador.entity.Voluntario;

/**
 * Servlet implementation class CadastrarEventoServlet
 */
@WebServlet("/CadastrarEventoServlet")
public class CadastrarEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDao = new CategoriaDAO();
	private EventoDAO eventoDao = new EventoDAO();

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
		try {
			request.setAttribute("categorias", categoriaDao.getCategorias());
		} catch(SQLException e){
			request.setAttribute("mensagem", "erro no banco");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CadastraEvento.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nomeevento = request.getParameter("nome");//pega os parametros 
		String codcategoria = request.getParameter("categoria");
		Integer codcat = Integer.parseInt(codcategoria);
		String dtInicio = tratarData(request.getParameter("dataInicio"));
		String dtFim = tratarData(request.getParameter("dataFim"));
		String descricao = request.getParameter("desc");
		
		HttpSession sessao = request.getSession();
		Voluntario administrador = (Voluntario) sessao.getAttribute("voluntario");
		
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
		
		Categoria categoria = null;
		try {
			categoria = categoriaDao.getCategoria(codcat);
		} catch (SQLException e1) {
			// Efetuar tratament amigavel
			e1.printStackTrace();
		}

		//Evento evento = new Evento(nomeevento, descricao, dataInicio, dataFim, categoria);
		Evento evento = new Evento(nomeevento, descricao, dataInicio, dataFim, categoria, administrador);
		try {
			eventoDao.insere(evento);
		} catch (SQLException e) {
			//TODO tratar amigavelmente
			e.printStackTrace();
		}
		
		response.sendRedirect("EventoServlet");
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("EventoServlet");
		//dispatcher.forward(request, response);
	}

}
