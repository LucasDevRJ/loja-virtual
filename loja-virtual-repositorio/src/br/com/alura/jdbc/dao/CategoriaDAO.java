package br.com.alura.jdbc.dao;

import java.sql.Connection;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

}
