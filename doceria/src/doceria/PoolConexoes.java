package doceria;

import java.sql.SQLException;

public class PoolConexoes {

	public static void main(String[] args) throws SQLException {
		CriaConexao conexao = new CriaConexao();
		
		for (int i = 0; i <= 10; i++) {
			conexao.conecta();
			System.out.println("Conexão de número: " + i);
		}
	}
}
