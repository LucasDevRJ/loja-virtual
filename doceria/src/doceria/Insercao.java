package doceria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insercao {

	public static void main(String[] args) throws SQLException {
		CriaConexao criaConexao = new CriaConexao();
		try (Connection conexao = criaConexao.conecta()) {

			Statement stm = conexao.createStatement();
			stm.execute(
					"INSERT INTO doce (nome, ingredientes) VALUES ('Sequilho', 'Leite condesado, amido de milho, manteiga, leite ninho')",
					Statement.RETURN_GENERATED_KEYS);

			ResultSet rst = stm.getGeneratedKeys();

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O ID criado foi: " + id);
			}
		}
	}
}
