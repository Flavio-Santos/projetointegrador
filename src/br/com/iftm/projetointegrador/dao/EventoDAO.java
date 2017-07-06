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
		String sql = "select nome_evento, descricao, cod_categoria, data_inicio, data_fim, cod_evento, cod_voluntario from evento order by cod_evento desc;";
		PreparedStatement stmt =  conexao.prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		List<Evento> eventos = new LinkedList<>();
		
		while (resultado.next()){
			Evento evento = this.getEvento(resultado);
			eventos.add(evento);
		}
		conexao.close();
		return eventos;
	}
	
	public Evento getEvento(Integer id) throws NumberFormatException, SQLException {
		Connection conexao =  Conexao.getConexao();
		String sql = "select nome_evento, descricao, cod_evento, cod_categoria, data_inicio, data_fim, cod_voluntario from evento where cod_evento = ?;";
		PreparedStatement stmt =  conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet resultado = stmt.executeQuery();
		
		Evento evento = new Evento();
		if (resultado.next()){
			evento = this.getEvento(resultado);
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

	public Evento getEvento(ResultSet resultado) throws SQLException{
		Evento evento = new Evento();
		
		java.util.Date dataInicio;
		java.util.Date dataFim;
		
		String descricao = resultado.getString("descricao");
		String nomeevento = resultado.getString("nome_evento");
		Integer codevento  = resultado.getInt("cod_evento");
		dataInicio = new java.util.Date(resultado.getDate("data_inicio").getTime());
		dataFim = new java.util.Date(resultado.getDate("data_fim").getTime());
			
		CategoriaDAO categoriaDao = new CategoriaDAO();
		Categoria categoria = categoriaDao.getCategoria(resultado.getInt("cod_categoria"));
			
		VoluntarioDAO voluntarioDao = new VoluntarioDAO();
		Voluntario administrador = voluntarioDao.getVoluntario(resultado.getInt("cod_voluntario"));
	
		evento = new Evento(descricao, nomeevento, codevento, dataInicio, dataFim, categoria, administrador);
		
		return evento;
	}

	public Boolean insereParticipacao(Evento evento, Voluntario voluntario) throws SQLException{
		Connection conexao = Conexao.getConexao();
		
		String valida = "select cod_voluntario from participacao where cod_voluntario = ? and cod_evento = ?;";
		PreparedStatement stmt1 = conexao.prepareStatement(valida);
        stmt1.setInt(1, voluntario.getCodvoluntario());
		stmt1.setInt(2, evento.getCodevento());
        ResultSet resultado = stmt1.executeQuery();
        Boolean verificacao = true;
        if (resultado.next()){
        	verificacao = false;
        }
        if (verificacao){
        	String sql = "INSERT INTO Participacao (cod_voluntario, cod_evento, data_participacao) VALUES (?,?,?)";
            PreparedStatement stmt2 = conexao.prepareStatement(sql);
            stmt2.setInt(1, voluntario.getCodvoluntario());
            stmt2.setInt(2, evento.getCodevento());
            stmt2.setDate(3, new Date(new java.util.Date().getTime()));
            stmt2.execute();        
            stmt2.close();
        }
		
        conexao.close();
        return verificacao;
	}
	
	public void recuperaParticipacao(Evento evento) throws SQLException{
		Connection conexao = Conexao.getConexao();
        String sql = "select * from voluntario where cod_voluntario in(select  distinct cod_voluntario from participacao where cod_evento = ? and participou = 0);";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, evento.getCodevento());
        
        ResultSet resultado = stmt.executeQuery();
        VoluntarioDAO voluntarioDao = new VoluntarioDAO();
        
        while (resultado.next()){
        	Voluntario voluntario = voluntarioDao.getVoluntario(resultado); 
        	evento.addVoluntario(voluntario);
        }
        
        stmt.close();
        conexao.close();
	}

	public void confirmaParticipacao(Evento evento, Voluntario voluntario) throws SQLException {
		Connection conexao = Conexao.getConexao();
		String sql = "update participacao set participou = 1 where cod_evento = ? and cod_voluntario = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, evento.getCodevento());
        stmt.setInt(2, voluntario.getCodvoluntario());
        stmt.execute();
        
        stmt.close();
        conexao.close();
	}
	
}
