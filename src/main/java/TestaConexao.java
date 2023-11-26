import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8"; 
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection(URL_MYSQL, "root", "Jhonatan");

		connection.close();
	}

}