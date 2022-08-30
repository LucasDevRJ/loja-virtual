package doceria;

import java.sql.Connection;
import java.sql.SQLException;

import doceria.dao.DoceDAO;

public class TestaInsercaoDoce {

	public static void main(String[] args) throws SQLException {
		Doce doce = new Doce("Muffin de chocolate", "Chocolate amargo, leite quente, manteiga, ovo.");
		
		try (Connection conexao = new CriaConexao().conecta()) {
			String sql = "INSERT INTO DOCE (NOME, INGREDIENTES) VALUES (?, ?)";
			
			DoceDAO doceDao = new DoceDAO(conexao);
			doceDao.salvar(doce);
		}
	}
}
