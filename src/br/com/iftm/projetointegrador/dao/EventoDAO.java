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
		while (resultado.next()){
			eventos.add(new Evento(resultado.getString(1), resultado.getString(2)));
		}
		return eventos;
	}
	
	public void insere(Evento evento) throws SQLException{
		Connection conexao = (Connection) Conexao.getConexao();
        String sql = "INSERT INTO Evento (Nome_evento, descricao, dataI, dataF) VALUES (?,?,?,?)";
        PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
        stmt.setString(1, evento.getNomeEvento());
        stmt.setString(2, evento.getDescricao());
        
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getDate());
        
        stmt.setDate(3, dataSql);
        stmt.setDate(4, dataSql);
        stmt.execute();        
        stmt.close();
        conexao.close();
    }

}
