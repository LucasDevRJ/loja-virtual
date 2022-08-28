package doceria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CriaConexao {
	
	public CriaConexao() {
		ComboPooledDataSource conexaoBanco = new ComboPooledDataSource();
		conexaoBanco.setJdbcUrl("jdbc:mysql://localhost/doceria?useTimezone=true&serverTimezone=UTC");
		conexaoBanco.setUser("root");
		conexaoBanco.setPassword("root");
	}

	public Connection conecta() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/doceria?useTimezone=true&serverTimezone=UTC", "root", "root");
	}
}
