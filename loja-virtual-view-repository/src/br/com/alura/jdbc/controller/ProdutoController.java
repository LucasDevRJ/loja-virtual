package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoController {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void deletar(Integer id) {
		this.produtoDAO.deletar(id);
		System.out.println("Deletando produto: " + id);
	}

	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
		System.out.println("Salvando produto: " + produto.getId());
	}

	public List<Produto> listar() {
		System.out.println("Adicionando produto na lista");
		return this.produtoDAO.listar();
	}

	public void alterar(String nome, String descricao, Integer id) {
		this.produtoDAO.alterar(nome, descricao, id);
		System.out.println("Alterando produto: " + id);
	}
}
