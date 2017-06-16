package br.com.iftm.projetointegrador.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iftm.projetointegrador.dao.CategoriaDAO;
import br.com.iftm.projetointegrador.entity.Categoria;

/**
 * Servlet implementation class testeCategoria
 */
@WebServlet("/testeCategoria")
public class testeCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testeCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Teste do getCategoria(), mostrando os getters dos atributos");
		CategoriaDAO categoriaDao = new CategoriaDAO();
		try {
			Categoria categoria = categoriaDao.getCategoria(1);
			response.getWriter().append("<br>Categoria:" + categoria.getNomecategoria());
			response.getWriter().append("<br>Descrição: " + categoria.getDescricao());
			response.getWriter().append("<br>Experiencia: " + categoria.getExperiencia());
			response.getWriter().append("<br>Codigo: " + categoria.getCodcategoria());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		response.getWriter().append("<br>-------------------<br>");
		response.getWriter().append("Teste do getCategorias() mostrando o nome de todas categorias");
		List<Categoria> categorias =  new LinkedList<Categoria>();
		try {
			categorias = categoriaDao.getCategorias();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < categorias.size(); i++) {
			response.getWriter().append("<br>" + categorias.get(i).getNomecategoria());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
