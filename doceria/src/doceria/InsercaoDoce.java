package doceria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsercaoDoce {

	public static void main(String[] args) throws SQLException {
		Doce doce = new Doce("Mousse de chocolate", "Chocolate ao leite, creme de leite e claras de ovo");
		
		try (Connection conexao = new CriaConexao().conecta()) {
			String sql = "INSERT INTO DOCE (NOME, INGREDIENTES) VALUES (?, ?)";
			
			try (PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				ps.setString(1, doce.getNome());
				ps.setString(2, doce.getIngredientes());
				
				ps.execute();
				
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						doce.setId(rs.getInt(1));
					}
				}
			}
		}
	}
}
