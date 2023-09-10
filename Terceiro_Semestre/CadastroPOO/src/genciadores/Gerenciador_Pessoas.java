package genciadores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Gerenciador_Pessoas<G extends Pessoa> {
	public ArrayList<G> ListaPessoas = new ArrayList<>();

	public void persistir(String nomeArquivo) {
		try (FileOutputStream Arquivo_fora = new FileOutputStream(nomeArquivo);
				ObjectOutputStream Objeto_fora = new ObjectOutputStream(Arquivo_fora)) {

			Objeto_fora.writeObject(ListaPessoas);

		} catch (IOException e) {
			System.out.println("Erro ao persistir os dados: linha 23 Classe Gerenciador_Pessoas " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void carregar(String nomeArquivo) {
		try (FileInputStream arquivoEntrada = new FileInputStream(nomeArquivo);
				ObjectInputStream objetoEntrada = new ObjectInputStream(arquivoEntrada)) {

			ListaPessoas = (ArrayList<G>) objetoEntrada.readObject();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erro ao recuperar os dados: " + e.getMessage());
		}

	}

	// Adicionar

	public void inserir(G pessoa) {
		
		carregar("dados_pf.dat");
		ListaPessoas.add(pessoa);
		persistir("dados_pf.dat");

	}

	// Alterar
	public void alterar(G pessoa) {
		carregar("dados_pf.dat");
		int index = encontrarIndexPorId(pessoa.getId());
		if (index != -1) {
			ListaPessoas.set(index, pessoa);

		}
		persistir("dados_pf.dat");
	}

	// Excluir
	public void excluir(int id) {
		carregar("dados_pf.dat");
		int index = encontrarIndexPorId(id);
		if (index != -1) {
			ListaPessoas.remove(index);

		}
		persistir("dados_pf.dat");
	}
	// Excluir Todos

	public void excluirtodos() {
		for (G Lpessoas : ListaPessoas) {
			if (Lpessoas == null) {
				System.out.println("Lista Vazia");
			} else {
				ListaPessoas.clear();
			}
			;
		}
		System.out.println("Lista Deletada");
		persistir("dados_pf.dat");
	};

	// Obter
	public G obter(Integer id) {
		carregar("dados_pf.dat");
		for (G pessoa : ListaPessoas) {
			if (Integer.valueOf(pessoa.getId()).equals(id)) {
				return pessoa;
			}
		}
		return null;
	}

	
	// Obter TodosPF_PJ
		public G obterTodos_pf_pj(int cod) {
			carregar("dados_pf.dat");
			
			
		   Prints.pf_pj(cod);

		    for (G pessoa : ListaPessoas) {
		        if (pessoa.getCod() == cod) {
		            System.out.println(pessoa);
		        }
		    }

		    persistir("dados_pf.dat");
			return null;

		};
	

	// Função Encontrar por ID
	public int encontrarIndexPorId(int id) {
		for (int i = 0; i < ListaPessoas.size(); i++) {
			if (ListaPessoas.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	};

	public int tamanho() {
		carregar("dados_pf.dat");
		return ListaPessoas.size();
	};
	
	
	public void excluirPF_PJ(int num) {
	    carregar("dados_pf.dat");

	    Iterator<G> iterator = ListaPessoas.iterator();
	    while (iterator.hasNext()) {
	        G pessoa = iterator.next();
	        if (pessoa instanceof PessoaFisica && pessoa.getCod() == num) {
	            iterator.remove();
	            Prints.pf_pj_excluida(num);
	        }else if (pessoa instanceof PessoaJuridica && pessoa.getCod() == num) {
	        	  iterator.remove();
	        	  Prints.pf_pj_excluida(num);
	        }
	    }

	   
	    persistir("dados_pf.dat");
	}

	
	
	
	
	
};
