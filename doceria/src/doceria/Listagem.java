package doceria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Listagem {

	public static void main(String[] args) throws SQLException {
		//Estabelecer a conexão com o banco
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/doceria?useTimezone=true&serverTimezone=UTC", "root", "root");
		
		//Utilizar comandos do Banco de dados
		Statement stm = conexao.createStatement();
		boolean resultado = stm.execute("SELECT ID, NOME, INGREDIENTES FROM DOCE");
		
		System.out.println(resultado);
		
		conexao.close();
	}
}
