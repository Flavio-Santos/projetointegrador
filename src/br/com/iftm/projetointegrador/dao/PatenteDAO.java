package br.com.iftm.projetointegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.iftm.projetointegrador.entity.Patente;

public class PatenteDAO {

	public Patente getPatente(Integer codpatente) throws SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from Patente where cod_patente=?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codpatente);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()){
			String nomepatente = resultado.getString("nome_patente");
			Integer expnecessaria = resultado.getInt("exp_necessaria");
			Patente patente = new Patente(nomepatente, expnecessaria, codpatente);
			return patente;
		}
		else {
			return new Patente();
		}
	}
}
