package doceria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsercaoParametro {

	public static void main(String[] args) throws SQLException {
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		conexao.setAutoCommit(false); //controlar as transações
		
		//Gerencia os dados inseridos
		PreparedStatement stm = conexao.prepareStatement("INSERT INTO doce (nome, ingredientes) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		adicionarDoce("Pudim de leite", "Gelatina, água, leite condesado, creme de leite, baunilha e leite", stm);
		adicionarDoce("Danoninho", "Leite condesado, creme de leite e morango", stm);
	}

	public static void adicionarDoce(String nome, String ingredientes, PreparedStatement stm) throws SQLException {
		//Settar os atributos (? ?)
		stm.setString(1, nome);
		stm.setString(2, ingredientes);
			
		if (stm.equals("Danoninho")) {
			throw new RuntimeException("Não foi possivel adicionar o doce!!!");
		}
		
		stm.execute();
				
		ResultSet rst = stm.getGeneratedKeys();
				
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		rst.close();
	}
}
