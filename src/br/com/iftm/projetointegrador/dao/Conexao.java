package br.com.iftm.projetointegrador.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConexao(){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
