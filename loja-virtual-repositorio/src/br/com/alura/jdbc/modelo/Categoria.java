package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private String nome; 
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adicionar(Produto produto) {
		this.produtos.add(produto);
	}

}
