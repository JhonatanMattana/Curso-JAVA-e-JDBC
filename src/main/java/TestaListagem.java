import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8"; 
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection(URL_MYSQL, "root", "Jhonatan");

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet resultSet = statement.getResultSet();
		
		while (resultSet.next()) {
			Integer id = resultSet.getInt("ID");
			String nome = resultSet.getString("NOME");
			String descricao = resultSet.getString("DESCRICAO");
			System.out.println(id + "\t"+ nome + "\t"+ descricao + "\t");
		}
		
		connection.close();
	}

}