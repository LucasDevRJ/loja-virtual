package doceria;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insercao {

	public static void main(String[] args) throws SQLException {
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		Statement stm = conexao.createStatement();
		stm.execute("INSERT INTO doce (nome, ingredientes) VALUES ('Sequilho', 'Leite condesado, amido de milho, manteiga, leite ninho'", Statement.RETURN_GENERATED_KEYS);
	}
}
