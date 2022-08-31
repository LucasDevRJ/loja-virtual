package doceria;

public class Doce {

	private Integer id;
	private String nome;
	private String ingredientes;
	
	public Doce(String nome, String ingredientes) {
		this.nome = nome;
		this.ingredientes = ingredientes;
	}
	 
	public Doce(Integer id, String nome, String ingredientes) {
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getIngredientes() {
		return ingredientes;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
