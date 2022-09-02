package doceria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import doceria.Categoria;

public class CategoriaDAO {
	
	private Connection conexao;
	
	public CategoriaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT * FROM CATEGORIA";
		
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.execute();
			
			try (ResultSet rs = ps.getResultSet()) {
				while (rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}
}
