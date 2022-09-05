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
			List<Categoria> listaCategorias = categoriaDao.listarComDoces();
			listaCategorias.stream().forEach(lc -> {
				System.out.println(lc.getNome());
//				try {
//					for (Doce doce : new DoceDAO(conexao).buscar(lc)) {
//						System.out.println("Nome: " + doce.getNome() + "\nIngredientes: " + doce.getIngredientes() + "\nTipo: " + lc.getNome());
//						System.out.println();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			});
		}
	}
}
