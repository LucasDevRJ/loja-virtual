import java.sql.Connection;

public class PersistenciaProduto {
	
	private Connection connection;
	
	public PersistenciaProduto(Connection connection) {
		this.connection = connection;
	}

}
