package br.curso.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		connection.setAutoCommit(false);
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(" "
					+ "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?) ", 
					Statement.RETURN_GENERATED_KEYS);
			
			adicionarVariavel("SmartTV", "45 Polegadas", prepareStatement);
			adicionarVariavel("Radio", "Radio de bateria", prepareStatement);
			
			connection.commit();
			
			prepareStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement prepareStatement) throws SQLException {
		prepareStatement.setString(1, nome);
		prepareStatement.setString(2, descricao);
		
		prepareStatement.execute();
		
		ResultSet generatedKeys =  prepareStatement.getGeneratedKeys();
		
		while (generatedKeys.next()) {
			Integer id = generatedKeys.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
	}
}