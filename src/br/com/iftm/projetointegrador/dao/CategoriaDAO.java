package br.com.iftm.projetointegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.iftm.projetointegrador.entity.Categoria;

public class CategoriaDAO {
	
	public List<Categoria> getCategorias() throws SQLException{
		Connection conexao =  Conexao.getConexao();
		String sql = "select * from categoria;";
		PreparedStatement stmt =  conexao.prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		List<Categoria> categorias = new LinkedList<>();
		while (resultado.next()){
			String nomecategoria = resultado.getString("nome_categoria");
			String descricao = resultado.getString("desc_categoria");
			Integer experiencia = resultado.getInt("experiencia");
			Integer codcategoria = resultado.getInt("cod_categoria");
			categorias.add(new Categoria(nomecategoria, descricao, experiencia, codcategoria));
		}
		conexao.close();
		return categorias;
	}
	
	public Categoria getCategoria(Integer codcategoria) throws SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from Categoria where cod_categoria=?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codcategoria);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()){
			String nomecategoria = resultado.getString("nome_categoria");
			String descricao = resultado.getString("desc_categoria");
			Integer experiencia = resultado.getInt("experiencia");
			Categoria categoria = new Categoria(nomecategoria, descricao, experiencia, codcategoria);
			conexao.close();
			return categoria;
		}
		else {
			conexao.close();
			return new Categoria();
		}
	}
}
