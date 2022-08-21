import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "wUjaspeF9u*");
		
		//usar comandos do banco de dados
	}
}
