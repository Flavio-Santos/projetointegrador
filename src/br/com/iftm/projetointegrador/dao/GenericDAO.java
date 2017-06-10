package br.com.iftm.projetointegrador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GenericDAO {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "");
	}

	public static void main(String[] args) {
		try {
			GenericDAO.getConnection();
			System.out.println("CONEXÃO OK!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
