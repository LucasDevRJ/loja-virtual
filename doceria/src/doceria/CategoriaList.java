package doceria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import doceria.dao.CategoriaDAO;

public class CategoriaList {

	public static void main(String[] args) throws SQLException {
		try (Connection conexao = new CriaConexao().conecta()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(conexao);
			List<Categoria> listaCategorias = categoriaDao.listar();
			
			System.out.println("Lista de Categorias");
			
			for (Categoria categoria : listaCategorias) {
				
				System.out.println(categoria);
				System.out.println();
			}
		}
	}
}
