import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.produto.ConnectionFactory;

public class TestaListagemDeCategorias {

	public static void main(String[] args) {
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeProdutos = categoriaDao.listar(); 
		}
	}
}
