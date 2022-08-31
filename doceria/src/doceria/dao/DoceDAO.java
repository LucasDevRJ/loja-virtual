package doceria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import doceria.Doce;

public class DoceDAO {

	private Connection conexao;
	
	public DoceDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void salvar(Doce doce) throws SQLException {
		String sql = "INSERT INTO DOCE (NOME, INGREDIENTES) VALUES (?, ?)";
		
		try (PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, doce.getNome());
			ps.setString(2, doce.getIngredientes());
			
			ps.execute();
			
			try (ResultSet rs = ps.getGeneratedKeys()){
				while (rs.next()) {
					doce.setId(rs.getInt(1));
				}
			}
		}
	}
	 
	public List<Doce> listar() throws SQLException {
		List<Doce> doces = new ArrayList<Doce>();
		
		String sql = "SELECT * FROM DOCE";
		
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.execute();
			
			try (ResultSet rs = ps.getResultSet()) {
				while (rs.next()) {
					Doce doce = new Doce(rs.getInt(1), rs.getString(2), rs.getString(3));
					
					doces.add(doce);
				}
			}
		}
		return doces;
	}
}
