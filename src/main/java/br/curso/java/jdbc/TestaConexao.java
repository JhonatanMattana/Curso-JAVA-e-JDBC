package br.curso.java.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection connection = connectionFactory.recuperarConexao();

		System.out.println("Fechando a conexão.");
		
		connection.close();
	}

}