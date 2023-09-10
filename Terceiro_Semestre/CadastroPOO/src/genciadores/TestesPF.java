package genciadores;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class TestesPF {

	public static String pf(Integer num) {
	try {

		Scanner sc = new Scanner(System.in);
		int cod  = 1;
		Integer id = null;
		String nome = null;
		String cpf = null;
		Integer idade = null;
		Gerenciador_Pessoas<PessoaFisica> pessoa = new Gerenciador_Pessoas<>();

		

		switch (num) {

		case 0:
			System.out.println("Finalizando Programa");
			System.out.println("Aluno:");
			System.out.println("João Luiz Silva Tavares");
			break;
		case 1:
			
			Integer idParaAlterar;
			System.out.println("Vamos Incluir uma Pessoa Fisica");			
			
			if(pessoa.obter(1)==null) {
				idParaAlterar = 1;				
			}else{				
				idParaAlterar = pessoa.tamanho()+1;				
			};					
			
			PessoaFisica existente = pessoa.obter(idParaAlterar);
			
			if(existente == null) {
			
			System.out.println("Qual Nome ?");
			nome = sc.nextLine();
			System.out.println("Qual CPF ?");
			cpf = sc.nextLine();
			System.out.println("Qual Idade ?");
			idade = sc.nextInt();
			pessoa.inserir(new PessoaFisica(cod,idParaAlterar, nome, cpf, idade));
			pessoa.ListaPessoas.add(new PessoaFisica(cod, idParaAlterar, nome, cpf, idade));
			pessoa.persistir("dodos_pf.dat");
			System.out.println("Pessoa Cadastrarda com Sucesso..");
			}else {
				System.out.println("ID  ja Cadastrado");
			}
			break;
		case 2:
		    System.out.println("Vamos Alterar uma Pessoa Fisica");
		    System.out.println("Qual e o ID da pessoa que deseja alterar?");
		    idParaAlterar = sc.nextInt();		    
		    PessoaFisica pessoaExistente = pessoa.obter(idParaAlterar);		    
		    if (pessoaExistente != null) {
		        sc.nextLine(); 		        
		        System.out.println("Qual e o novo Nome?");
		        nome = sc.nextLine();
		        System.out.println("Qual e o novo CPF?");
		        cpf = sc.next();
		        System.out.println("Qual e a nova Idade?");
		        idade = sc.nextInt();
		        
		        PessoaFisica pessoaAtualizada = new PessoaFisica(cod, idParaAlterar,nome,cpf, idade);
		        pessoa.alterar(pessoaAtualizada);
		       
		        pessoa.persistir("dados_pf.dat");
		        
		        System.out.println("Pessoa Alterada com Sucesso.");
		    } else {
		        System.out.println("Pessoa com ID especificado nao encontrada.");
		    }
		    break;

		case 3:
			System.out.println("Vamos Excruir uma Pessoa Fisica");
			System.out.println("Qual a ID?");
			idParaAlterar = sc.nextInt();		    
		    PessoaFisica p_Existente = pessoa.obter(idParaAlterar);		    
		    if (p_Existente != null) {
		      
		        pessoa.excluir(idParaAlterar);
		       
		        pessoa.persistir("dados_pf.dat");
		        
		        System.out.println("Pessoa Excluida com Sucesso.");
		    } else {
		        System.out.println("Pessoa com ID especificado nao encontrada.");
		    }
		    break;
	
		case 4:
		
		    System.out.println("Vamos Obter uma Pessoa Fisica");
		    System.out.println("Qual a ID?");
		    id = sc.nextInt();
		    PessoaFisica pessoaEncontrada = pessoa.obter(id);

		    if (pessoaEncontrada != null) {
		        System.out.println("Pessoa Obtida com Sucesso:");
		        System.out.println("ID: " + pessoaEncontrada.getId());
		        System.out.println("Nome: " + pessoaEncontrada.getNome());
		        System.out.println("CPF: " + pessoaEncontrada.getCpf());
		        System.out.println("Idade: " + pessoaEncontrada.getIdade());
		    } else {
		        System.out.println("Pessoa nao encontrada.");
		    }
		    break;

		case 5:
			 break;
		case 6:
			
			break;
			
		case 7:
			pessoa.obterTodos_pf_pj(1);
			break;
		case 8:
			pessoa.excluirPF_PJ(1);
			break;
	};

	return null;
	} catch (Exception e) {
	       
        System.out.println("erro verificar linha 51 a 178 Classe TestePJ " + e.getMessage());
        return null;
    }

	};

	
}
