package br.curso.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		String nome = "Mouse";
		String descricao = "Mouse sem fio";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement prepareStatement = connection.prepareStatement(" "
				+ "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?) ", 
				Statement.RETURN_GENERATED_KEYS);
		
		prepareStatement.setString(1, nome);
		prepareStatement.setString(2, descricao);
		
		prepareStatement.execute();
		
		ResultSet generatedKeys =  prepareStatement.getGeneratedKeys();
		
		while (generatedKeys.next()) {
			Integer id = generatedKeys.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		
		connection.close();
	}
}