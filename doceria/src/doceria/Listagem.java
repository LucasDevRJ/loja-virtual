package doceria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Listagem {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/doceria?useTimezone=true&serverTimezone=UTC", "root", "root");
	}
}
