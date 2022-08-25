import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		//Para permitir os parametros e transformar tudo em String, dando mais segurança para o sistema
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		//Setar os atributos do banco, pegando como referência o ? do Statement
		adicionarVariavel("", "", stm);
		adicionarVariavel("", "", stm);
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		
		ResultSet rst = stm.getGeneratedKeys();
		
		//retorna as chaves geradas
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		rst.close();
	}
}
