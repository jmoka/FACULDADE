package entidades;

import java.io.Serializable;

public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int cod;
	protected int id;
	protected String nome;
	
	public Pessoa() { // CONSTRUTOR PADRÃO
		
	}

	public Pessoa(int cod, int id, String nome) { // CONSTRUTOR COM ARGUMENTOS
		this.cod = cod;
		this.id = id;
		this.nome = nome;
	}
	
	// GEST'S , SET'S
	public int getId() {
		return id;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	// SOBCREVEBDO O MÉTODO TOSTRING DA CLASSSE OBJECT
	 @Override
	 public String toString() {
		 System.out.println("");
		 	System.out.println("Pessoa Registrada");
	        return String.format("Id=%d, %nNome=%s", id, nome);
	    }

	
	

}
