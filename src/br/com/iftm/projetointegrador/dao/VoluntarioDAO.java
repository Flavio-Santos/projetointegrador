package br.com.iftm.projetointegrador.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.iftm.projetointegrador.entity.Voluntario;

public class VoluntarioDAO {

	
	public void insere(Voluntario voluntario) throws SQLException{
		Connection conexao = (Connection) Conexao.getConexao();
        String sql = "insert into usuario (nome, Experiencia, email, hierarquia, senha, sexo) values ();";
        PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
        stmt.setString(1, voluntario.getNome());
        stmt.setInt(2, voluntario.getExperiencia());
        stmt.setString(3, voluntario.getEmail());
        stmt.setString(4, null);
        stmt.setString(5, voluntario.getSenha());
        stmt.setString(6, null);
        
        stmt.execute();        
        stmt.close();
        conexao.close();
    }
	
}
