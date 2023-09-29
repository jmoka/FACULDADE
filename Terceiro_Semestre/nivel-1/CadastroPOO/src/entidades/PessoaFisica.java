package entidades;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private int idade;
	
	// construtor padrão com super
	public PessoaFisica() {
		super();
	};
	 
	
	// construtor com argumento
	public PessoaFisica( int cod, int id, String nome, String cpf, int idade) {
		super(cod, id, nome); // extende de classe Pessoa
		this.cpf = cpf;
		this.idade = idade;
	}



	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	// Get's e Set's
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	// SOBCREVEBDO O MÉTODO TOSTRING DA CLASSSE OBJECT
	@Override
	public String toString() {
		
		
	    String formatada = String.format("%nId=%d, %nNome=%s, %nCPF=%s, %nIdade=%d%n=========== ", id, nome, cpf, idade);
	    
	    return formatada;
	    		
	    		
	    		
	}

}
