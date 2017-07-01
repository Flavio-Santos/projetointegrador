package br.com.iftm.projetointegrador.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.iftm.projetointegrador.entity.Categoria;
import br.com.iftm.projetointegrador.entity.Evento;
import br.com.iftm.projetointegrador.entity.Voluntario;

public class EventoDAO {
	
	
	public List<Evento> getEventos() throws SQLException{
		Connection conexao =  Conexao.getConexao();
		String sql = "select nome_evento, descricao, cod_categoria, data_inicio, data_fim, cod_evento, cod_voluntario from evento;";
		PreparedStatement stmt =  conexao.prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		List<Evento> eventos = new LinkedList<>();
		
		java.util.Date dataInicio;
		java.util.Date dataFim;
		
		while (resultado.next()){
			dataInicio = new java.util.Date(resultado.getDate(4).getTime());
			dataFim = new java.util.Date(resultado.getDate(5).getTime());
			
			CategoriaDAO categoriaDao = new CategoriaDAO();
			Categoria categoria = categoriaDao.getCategoria(resultado.getInt("cod_categoria"));
			VoluntarioDAO voluntarioDao = new VoluntarioDAO();
			Voluntario administrador = voluntarioDao.getVoluntario(resultado.getInt("cod_voluntario"));
			
			Evento evento = new Evento(resultado.getString(1), resultado.getString(2), resultado.getInt("cod_evento"),dataInicio, dataFim, categoria, administrador);
			eventos.add(evento);
		}
		conexao.close();
		return eventos;
	}
	
	public Evento getEvento(Integer id) throws NumberFormatException, SQLException {
		Connection conexao =  Conexao.getConexao();
		String sql = "select nome_evento, descricao, cod_categoria, data_inicio, data_fim, cod_voluntario from evento where cod_evento = ?;";
		PreparedStatement stmt =  conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet resultado = stmt.executeQuery();
		
		java.util.Date dataInicio;
		java.util.Date dataFim;
		Evento evento = new Evento();
		if (resultado.next()){
			dataInicio = new java.util.Date(resultado.getDate("data_inicio").getTime());
			dataFim = new java.util.Date(resultado.getDate("data_fim").getTime());
			
			CategoriaDAO categoriaDao = new CategoriaDAO();
			Categoria categoria = categoriaDao.getCategoria(resultado.getInt("cod_categoria"));
			VoluntarioDAO voluntarioDao = new VoluntarioDAO();
			Voluntario administrador = voluntarioDao.getVoluntario(resultado.getInt("cod_voluntario"));
			
			evento = new Evento(resultado.getString("nome_evento"), resultado.getString("descricao"), id,dataInicio, dataFim, categoria, administrador);
		}
		conexao.close();
		return evento;
	}
	
	public void insere(Evento evento) throws SQLException{
		Connection conexao = Conexao.getConexao();
        String sql = "INSERT INTO Evento (Nome_evento, descricao, data_inicio, data_fim, cod_categoria, cod_voluntario) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, evento.getNomeevento());
        stmt.setString(2, evento.getDescricao());
        stmt.setDate(3,new Date(evento.getDatainicio().getTime()));
        stmt.setDate(4, new Date(evento.getDatafim().getTime()));
        stmt.setInt(5, evento.getCodcategoria());
        stmt.setInt(6, evento.getCodadmin());
        stmt.execute();        
        stmt.close();
        conexao.close();
    }


	public void insereParticipacao(Evento evento, Voluntario voluntario) throws SQLException{
		Connection conexao = Conexao.getConexao();
        String sql = "INSERT INTO Participacao (cod_voluntario, cod_evento, data_participacao) VALUES (?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, voluntario.getCodvoluntario());
        stmt.setInt(2, evento.getCodevento());
        stmt.setDate(3, new Date(new java.util.Date().getTime()));
        stmt.execute();        
        stmt.close();
        conexao.close();
	}
	
	public void recuperaParticipacao(Evento evento) throws SQLException{
		Connection conexao = Conexao.getConexao();
        String sql = "select cod_voluntario from participacao where cod_evento = ?;";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, evento.getCodevento());
        
        ResultSet resultado = stmt.executeQuery();
        VoluntarioDAO voluntarioDao = new VoluntarioDAO();
        while (resultado.next()){
        	Voluntario voluntario = voluntarioDao.getVoluntario(resultado); 
        	evento.associaVoluntario(voluntario);
        }
        
        stmt.close();
        conexao.close();
	}
	
}
