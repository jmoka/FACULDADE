package entidades;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String cnpj;

	
	// contrutor padrao
	public PessoaJuridica() {
		super();
	};
	
	// contrutor com argumentos
	public PessoaJuridica(int cod, int id, String nome, String cnpj) {
		super(cod, id, nome); // extende de pessoa
		this.cnpj = cnpj;
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

	//Get's e Set's
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	// SOBCREVEBDO O MÉTODO TOSTRING DA CLASSSE OBJECT
	@Override
	public String toString() {
		System.out.println("");
		return String.format("Id = %d %nNome = %s %nCnpj = %s%n======================", id,nome, cnpj);
	}

}
