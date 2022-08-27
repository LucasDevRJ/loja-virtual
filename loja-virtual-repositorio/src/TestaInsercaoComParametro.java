import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false); //para controlar a transação
		
		//Ter o controle melhor das transações
		try {
			//Para permitir os parametros e transformar tudo em String, dando mais segurança para o sistema
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			//Setar os atributos do banco, pegando como referência o ? do Statement
			adicionarVariavel("SmartTV", "45 polegadas", stm);
			adicionarVariavel("Radio", "Radio de bateria", stm);
			
			//Evitar conflitos de erro de transação, caso havendo problema, a transação não será feita
			connection.commit();
			
			stm.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
	} 

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		if (nome.equals("Radio")) {
			throw new RuntimeException("Não foi possivel adicionar o produto!!!");
		}
		
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
