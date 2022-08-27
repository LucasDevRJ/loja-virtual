package doceria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remocao {

	public static void main(String[] args) throws SQLException {
		CriaConexao criaConexao = new CriaConexao();
		try (Connection conexao = criaConexao.conecta()) {

			// Gerencia os dados recebidos pela conexão
			try (PreparedStatement stm = conexao.prepareStatement("DELETE FROM DOCE WHERE ID > ?")) {

				// Setta o atributo ? no statement
				stm.setInt(1, 2);

				stm.execute();

				Integer linhasModificadas = stm.getUpdateCount();
				System.out.println("Quantidades de linhas que foram modificadas: " + linhasModificadas);
			}
		}
	}
}
