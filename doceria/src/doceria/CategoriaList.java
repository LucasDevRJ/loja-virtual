package doceria;

import java.sql.Connection;
import java.sql.SQLException;

public class CategoriaList {

	public static void main(String[] args) throws SQLException {
		try (Connection conexao = new CriaConexao().conecta()) {
			CategoriaDAO categoriaDao = new CategoriaDao(conexao);
			List<Categoria> listaCategorias = categoriaDao.listar();
		}
	}
}
