package br.com.iftm.projetointegrador.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.iftm.projetointegrador.entity.Evento;

public class EventoDAO {
	
	
	public List<Evento> getEventos() throws SQLException{
		Connection conexao =  Conexao.getConexao();
		String sql = "select nome_evento, descricao, cod_categoria, data_inicio, data_fim, cod_evento, ID from evento;";
		PreparedStatement stmt =  conexao.prepareStatement(sql);
		ResultSet resultado = stmt.executeQuery();
		List<Evento> eventos = new LinkedList<>();
		
		java.util.Date dataInicio;
		java.util.Date dataFim;
		
		while (resultado.next()){
			dataInicio = new java.util.Date(resultado.getDate(4).getTime());
			dataFim = new java.util.Date(resultado.getDate(5).getTime());
			eventos.add(new Evento(resultado.getString(1), resultado.getString(2), dataInicio, dataFim));
		}
		return eventos;
	}
	
	
	
	public void insere(Evento evento) throws SQLException{
		Connection conexao = Conexao.getConexao();
        String sql = "INSERT INTO Evento (Nome_evento, descricao, data_inicio, data_fim) VALUES (?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, evento.getNomeevento());
        stmt.setString(2, evento.getDescricao());
        
        stmt.setDate(3,new Date(evento.getDatainicio().getTime()));
        stmt.setDate(4, new Date(evento.getDatafim().getTime()));
        stmt.execute();        
        stmt.close();
        conexao.close();
    }

}
