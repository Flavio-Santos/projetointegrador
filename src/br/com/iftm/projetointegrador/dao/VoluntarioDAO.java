package br.com.iftm.projetointegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import br.com.iftm.projetointegrador.entity.Evento;
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
			conexao.close();
			return true;
		}
		else {
			conexao.close();
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
			
			Voluntario voluntario = this.getVoluntario(resultado);
			stmt.close();
			conexao.close();
			return voluntario;
		}
		else {
			stmt.close();
			conexao.close();
			return new Voluntario();
		}
	}
	
	public Voluntario getVoluntario(Integer codvoluntario) throws NumberFormatException, SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from Voluntario where cod_voluntario=?;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codvoluntario);
		ResultSet resultado = stmt.executeQuery();
		if (resultado.next()){
			
			Voluntario voluntario = this.getVoluntario(resultado);
			conexao.close();
			return voluntario;
		}
		else {
			conexao.close();
			return new Voluntario();
		}
	}
	
	public Voluntario getVoluntario(ResultSet resultado) throws SQLException{
		Voluntario voluntario = new Voluntario();
		
		Integer codvoluntario = resultado.getInt("cod_voluntario");
		String nome = resultado.getString("Nome");
		String login  = resultado.getString("Login");
		String senha = resultado.getString("Senha");
		Boolean admin = resultado.getBoolean("Admin");
		Boolean ativo = resultado.getBoolean("Ativo");
		String email = resultado.getString("Email");
		Integer experiencia = resultado.getInt("Experiencia");
		String sexo = resultado.getString("Sexo");
		PatenteDAO patenteDAO = new PatenteDAO();
		Integer codpatente = resultado.getInt("cod_patente");
		Patente patente = patenteDAO.getPatente(codpatente);
		voluntario = new Voluntario(login, nome, senha, codvoluntario, admin, ativo, email, experiencia, sexo, patente);
		
		return voluntario;
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
	
	public void recuperaParticipacao(Voluntario voluntario) throws SQLException{
		Connection conexao = Conexao.getConexao();
        String sql = "select * from evento where cod_evento in(select cod_evento from participacao where cod_voluntario = ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, voluntario.getCodvoluntario());
        
        ResultSet resultado = stmt.executeQuery();
        EventoDAO eventoDao = new EventoDAO();
        
        while (resultado.next()){
        	Evento evento = eventoDao.getEvento(resultado);
        	voluntario.associaEvento(evento);
        }
        
        stmt.close();
        conexao.close();
	}
	
	public LinkedList<Voluntario> getRankinvoluntarios() throws SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "select * from Voluntario order by experiencia desc limit 4;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		
		LinkedList<Voluntario> voluntarios = new LinkedList<Voluntario>();
		
		while (resultado.next()){
			Voluntario voluntario = this.getVoluntario(resultado);
			voluntarios.add(voluntario);
		}
		stmt.close();
		conexao.close();
		return voluntarios;
	}
	
	public void atualizaVoluntario(Voluntario voluntario) throws SQLException{
		Connection conexao =  Conexao.getConexao();
        String sql = "update Voluntario set nome=?, senha=? where cod_voluntario = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, voluntario.getNome());
        stmt.setString(2, voluntario.getSenha());
        stmt.setInt(3, voluntario.getCodvoluntario());
        stmt.execute();
        stmt.close();
        conexao.close();
	}
}
