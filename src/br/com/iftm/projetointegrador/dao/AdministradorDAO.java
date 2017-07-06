package br.com.iftm.projetointegrador.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.iftm.projetointegrador.entity.Evento;
import br.com.iftm.projetointegrador.entity.Voluntario;

public class AdministradorDAO {
	EventoDAO eventodao = new EventoDAO();
	
	
	public List<Evento> eventosPorAdministrador(Voluntario adm) throws SQLException {
		List<Evento> eventos = new LinkedList<Evento>();
		List<Evento> eventosAdm = new LinkedList<Evento>();
		eventos = eventodao.getEventos();
		if(!eventos.isEmpty()){
			for (Evento evento : eventos) {
				if (evento.getCodadmin().equals(adm.getCodvoluntario())) {
					eventosAdm.add(evento);
				}
			}
		}
		return eventosAdm;
	}
	
}
