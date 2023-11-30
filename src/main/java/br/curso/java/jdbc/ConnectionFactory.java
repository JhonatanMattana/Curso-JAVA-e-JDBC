package br.curso.java.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;

	private static final String USER = "root";
	private static final String PASSWORD = "Jhonatan";
	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8"; 
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource(); 
		comboPooledDataSource.setJdbcUrl(URL_MYSQL);
		comboPooledDataSource.setUser(USER);
		comboPooledDataSource.setPassword(PASSWORD);
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
	
}