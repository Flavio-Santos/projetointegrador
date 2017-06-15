package br.com.iftm.projetointegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.iftm.projetointegrador.entity.Voluntario;

public class VoluntarioDAO {

	public boolean getVoluntario(String l, String s) throws NumberFormatException, SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from usuario where Login=? and Senha=?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, l);
        stmt.setString(2, s);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()){
			/*
			String nome = resultado.getString("nome");
			String login = resultado.getString("Login");
			String sexo = resultado.getString("Sexo");
			String hierarquia = resultado.getString("Hierarquia");
			Integer id = Integer.parseInt(resultado.getString("ID"));
			Voluntario voluntario = new Voluntario(nome, login, sexo, hierarquia, id);
			*/
			return true;
		}
		else {
			return false;
		}
	}
	
	public void insere(Voluntario voluntario) throws SQLException{
		Connection conexao = (Connection) Conexao.getConexao();
        String sql = "insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values (?,?,?,?,?,?);";
        PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
        stmt.setString(1, voluntario.getNome());
        stmt.setInt(2, voluntario.getExperiencia());
        stmt.setString(3, voluntario.getLogin());
        stmt.setString(4, null);
        stmt.setString(5, voluntario.getSenha());
        stmt.setString(6, null);
        
        stmt.execute();
        stmt.close();
        conexao.close();
    }
	
}
