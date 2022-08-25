package doceria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsercaoParametro {

	public static void main(String[] args) throws SQLException {
		String nome = "";
		String descricao = "";
		
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		Statement stm = conexao.createStatement();
		stm.execute("INSERT INTO doce (nome, ingredientes) VALUES ('" + nome + "', '" + descricao + "')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
	}
}
