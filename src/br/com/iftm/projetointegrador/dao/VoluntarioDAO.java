package br.com.iftm.projetointegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.iftm.projetointegrador.entity.Patente;
import br.com.iftm.projetointegrador.entity.Voluntario;

public class VoluntarioDAO {
	
	public boolean verificaLogin(String login, String senha) throws SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from Voluntario where Login=? and Senha=?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, login);
        stmt.setString(2, senha);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public Voluntario getVoluntario(String login) throws NumberFormatException, SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from Voluntario where Login=?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, login);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()){
			//Pega os campos do voluntario no banco
			String nome = resultado.getString("nome");
			String senha = resultado.getString("senha");
			Integer id = resultado.getInt("ID");
			Boolean admin = resultado.getBoolean("Admin");
			Boolean ativo = resultado.getBoolean("Ativo");
			String email = resultado.getString("email");
			Integer experiencia = resultado.getInt("experiencia");
			String sexo = resultado.getString("sexo");
			PatenteDAO patenteDAO = new PatenteDAO();
			Integer codpatente = resultado.getInt("cod_patente");
			Patente patente = patenteDAO.getPatente(codpatente);
			//Cria um voluntario com os dados que foram retornados do banco
			Voluntario voluntario = new Voluntario(login, nome, senha, id, admin, ativo, email, experiencia, sexo, patente);
			return voluntario;
		}
		else {
			return new Voluntario();
		}
	}
	
	public Voluntario getVoluntario(Integer ID) throws NumberFormatException, SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from Voluntario where ID=?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, ID);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()){
			//Pega os campos do voluntario no banco
			String nome = resultado.getString("nome");
			String login  = resultado.getString("login");
			String senha = resultado.getString("senha");
			Integer id = resultado.getInt("ID");
			Boolean admin = resultado.getBoolean("Admin");
			Boolean ativo = resultado.getBoolean("Ativo");
			String email = resultado.getString("email");
			Integer experiencia = resultado.getInt("experiencia");
			String sexo = resultado.getString("sexo");
			PatenteDAO patenteDAO = new PatenteDAO();
			Integer codpatente = resultado.getInt("cod_patente");
			Patente patente = patenteDAO.getPatente(codpatente);
			//Cria um voluntario com os dados que foram retornados do banco
			Voluntario voluntario = new Voluntario(login, nome, senha, id, admin, ativo, email, experiencia, sexo, patente);
			return voluntario;
		}
		else {
			return new Voluntario();
		}
	}
	
	public void insere(Voluntario voluntario) throws SQLException{
		Connection conexao =  Conexao.getConexao();
        String sql = "insert into Voluntario (nome, login, email, cod_patente,senha, sexo, Experiencia) values"
        		+ "(?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, voluntario.getNome());
        stmt.setString(2, voluntario.getLogin());
        stmt.setString(3, voluntario.getEmail());
        stmt.setInt(4, voluntario.getCodpatente());
        stmt.setString(5, voluntario.getSenha());
        stmt.setString(6, voluntario.getSexo());
        stmt.setInt(7, voluntario.getExperiencia());
        
        stmt.execute();
        stmt.close();
        conexao.close();
    }
	
}
