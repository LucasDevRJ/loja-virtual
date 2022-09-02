package doceria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import doceria.dao.CategoriaDAO;
import doceria.dao.DoceDAO;

public class CategoriaList {

	public static void main(String[] args) throws SQLException {
		try (Connection conexao = new CriaConexao().conecta()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(conexao);
			List<Categoria> listaCategorias = categoriaDao.listar();
			listaCategorias.stream().forEach(lc -> {
				for (Doce doce : new DoceDAO(conexao).buscar(ct)) {
					
				}
			});
		}
	}
}
