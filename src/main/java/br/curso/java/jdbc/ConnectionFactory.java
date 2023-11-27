package br.curso.java.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8"; 
	
	public Connection recuperarConexao() throws SQLException {
		return DriverManager.getConnection(URL_MYSQL, "root", "Jhonatan");
	}
	
}