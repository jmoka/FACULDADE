package genciadores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class TestesPJ {

	public static String pj(Integer num) {
	try {

		Scanner sc = new Scanner(System.in);
		String nome_arq = "dados.dat";
		int cod  = 2;
		Integer id = null;
		String nome = null;
		String cnpj = null;
		Gerenciador_Pessoas<PessoaJuridica> pessoa = new Gerenciador_Pessoas<>();

		

		switch (num) {

		case 0:
			System.out.println("Finalizando Programa");
			System.out.println("Aluno:");
			System.out.println("João Luiz Silva Tavares");
			break;
		case 1:
			
			Integer idParaAlterar;
			System.out.println("Vamos Incluir uma Pessoa Juridica");			
			
			if(pessoa.obter(1, nome_arq)==null) {
				idParaAlterar = 1;				
			}else{				
				idParaAlterar = pessoa.tamanho(nome_arq)+1;				
			};					
			
			PessoaJuridica existente = pessoa.obter(idParaAlterar, nome_arq);
			
			if(existente == null) {
			//sc.nextLine();
			System.out.println("Qual Razao ?");
			nome = sc.nextLine();
			System.out.println("Qual CNPJ ?");
			cnpj = sc.nextLine();			
			pessoa.inserir(new PessoaJuridica(cod, idParaAlterar,nome, cnpj ), nome_arq);
			//pessoa.ListaPessoas.add(new PessoaJuridica(cod, idParaAlterar, nome, cnpj));
			pessoa.persistir(nome_arq);
			System.out.println("Pessoa Juridica Cadastrarda com Sucesso..");
			}else {
				System.out.println("ID  ja Cadastrado");
			}
			break;
		case 2:
		    System.out.println("Vamos Alterar uma Pessoa Juridica");
		    System.out.println("Qual e o ID da Pessoa Juridica que deseja alterar?");
		    idParaAlterar = sc.nextInt();		    
		    PessoaJuridica pessoaExistente = pessoa.obter(idParaAlterar, nome_arq);		    
		    if (pessoaExistente != null) {
		        sc.nextLine(); 		        
		        System.out.println("Qual e o nava Razao?");
		        nome = sc.nextLine();
		        System.out.println("Qual e o novo CNPJ?");
		        cnpj = sc.next();		      
		        PessoaJuridica pessoaAtualizada = new PessoaJuridica(cod, idParaAlterar,nome,cnpj);
		        pessoa.alterar(pessoaAtualizada, nome_arq);
		       
		        pessoa.persistir(nome_arq);
		        
		        System.out.println("Pessoa Juridica Alterada com Sucesso.");
		    } else {
		        System.out.println("Pessoa Juridica com ID especificado nao encontrada.");
		    }
		    break;

		case 3:
			System.out.println("Vamos Excruir uma Pessoa Juridica Fisica");
			System.out.println("Qual a ID?");
			idParaAlterar = sc.nextInt();		    
		    PessoaJuridica p_Existente = pessoa.obter(idParaAlterar, nome_arq);		    
		    if (p_Existente != null) {
		      
		        pessoa.excluir(idParaAlterar, nome_arq);
		       
		        pessoa.persistir(nome_arq);
		        
		        System.out.println("Pessoa Juridica Excluida com Sucesso.");
		    } else {
		        System.out.println("Pessoa Juridica com ID especificado nao encontrada.");
		    }
		    break;
	
		case 4:
		
		    System.out.println("Vamos Obter uma Pessoa Juridica");
		    System.out.println("Qual a ID?");
		    id = sc.nextInt();
		    PessoaJuridica pessoaEncontrada = pessoa.obter(id, nome_arq);

		    if (pessoaEncontrada != null) {
		        System.out.println("Pessoa Juridica Obtida com Sucesso:");
		        System.out.println("ID: " + pessoaEncontrada.getId());
		        System.out.println("Nome: " + pessoaEncontrada.getNome());
		        System.out.println("CNPJ: " + pessoaEncontrada.getCnpj());
		        
		    } else {
		        System.out.println("Pessoa Juridica nao encontrada.");
		    }
		    break;

		case 5:
			 break;
		case 6:
			
			break;
			
		case 7:
			pessoa.obterTodos_pf_pj(2, nome_arq);
			break;
		case 8:
			pessoa.excluirPF_PJ(2, nome_arq);
			break;
	};

	return null;
	} catch (Exception e) {
	       
        System.out.println("erro verificar linha 51 a 178 Classe TestePJ " + e.getMessage());
        return null;
    }

	};

	
}