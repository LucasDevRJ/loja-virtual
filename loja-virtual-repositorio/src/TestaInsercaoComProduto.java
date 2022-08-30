import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Cômoda", "Cômoda vertical");
		
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		}
	}
}
