package doceria;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Remocao {

	public static void main(String[] args) throws SQLException {
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		Statement stm = conexao.createStatement();
		stm.execute("DELETE FROM DOCE WHERE ID > 2");
	}
}
