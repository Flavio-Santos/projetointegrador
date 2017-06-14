package br.com.iftm.projetointegrador.dao;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.iftm.projetointegrador.entity.Evento;

public class EventoDAO {
	
	
	public List<Evento> getEventos() throws SQLException{
		Connection conexao = (Connection) Conexao.getConexao();
		String sql = "select nome_evento, descricao, COD_TIPOEVENTO, dataI, dataF, cod_evento, cod_admin from evento;";
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
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
		Connection conexao = (Connection) Conexao.getConexao();
        String sql = "INSERT INTO Evento (Nome_evento, descricao, dataI, dataF) VALUES (?,?,?,?)";
        PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
        stmt.setString(1, evento.getNomeEvento());
        stmt.setString(2, evento.getDescricao());
        
        stmt.setDate(3,new Date(evento.getDataInicio().getTime()));
        stmt.setDate(4, new Date(evento.getDataFim().getTime()));
        stmt.execute();        
        stmt.close();
        conexao.close();
    }

}
