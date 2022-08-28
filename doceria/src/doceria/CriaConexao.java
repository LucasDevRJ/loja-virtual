package doceria;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CriaConexao {
	
	public DataSource conexao;
	
	public CriaConexao() {
		ComboPooledDataSource conexaoBanco = new ComboPooledDataSource();
		conexaoBanco.setJdbcUrl("jdbc:mysql://localhost/doceria?useTimezone=true&serverTimezone=UTC");
		conexaoBanco.setUser("root");
		conexaoBanco.setPassword("root");
		
		this.conexao = conexaoBanco;
	}

	public Connection conecta() throws SQLException {
		return this.conexao.getConnection();
	}
}
