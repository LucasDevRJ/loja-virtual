package doceria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listagem {

	public static void main(String[] args) throws SQLException {
		//Estabelecer a conexão com o banco
		CriaConexao criaConexao = new CriaConexao();
		Connection conexao = criaConexao.conecta();
		
		//Utilizar comandos do Banco de dados
		Statement stm = conexao.createStatement();
		boolean resultado = stm.execute("SELECT ID, NOME, INGREDIENTES FROM DOCE");
		
		System.out.println(resultado);
		
		//Pegar o resultado da lista
		ResultSet itensLista = stm.getResultSet();
		
		System.out.println("Cardápio");
		System.out.println();
		while (itensLista.next()) {
			Integer id = itensLista.getInt("ID");
			String nome = itensLista.getString("NOME");
			String ingredientes = itensLista.getString("INGREDIENTES");
			System.out.println("Código: " + id);
			System.out.println("Nome: " + nome);
			System.out.println("Ingredientes: " + ingredientes);
			System.out.println();
		}
		
		conexao.close();
	}
}
