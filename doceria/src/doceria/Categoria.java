package doceria;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Doce> doces = new ArrayList<Doce>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "ID da Categoria: " + this.id + "\nNome da Categoria: " + this.nome;
	}

	public void adicionar(Doce doce) {
		this.doces.add(doce);
	}

	public List<Doce> getDoces() {
		return doces;
	}
}
