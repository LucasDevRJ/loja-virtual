package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Result;

import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria();
				}
			}
		}
	}

}
