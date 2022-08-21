package doceria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

	public Connection CriaConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/doceria?useTimezone=true&serverTimezone=UTC", "root", "root");
	}
}
