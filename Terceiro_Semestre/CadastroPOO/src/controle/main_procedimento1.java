package controle;

import java.util.ArrayList;

import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import genciadores.Gerenciador_Pessoas;

public class main_procedimento1 {

	public static void main(String[] args) {

		// ESTANCIAÇÃO DOS GERENCIADORES PF E PJ
		Gerenciador_Pessoas<PessoaFisica> g_pf = new Gerenciador_Pessoas<>();
		Gerenciador_Pessoas<PessoaJuridica> g_pj = new Gerenciador_Pessoas<>();

		// INSERÇÃO DE DADOS NA LISTA PF
		g_pf.inserir(new PessoaFisica(23, "jota", "3455", 23));
		g_pf.inserir(new PessoaFisica(25, "paulo", "342", 12));

		// INSERÇÃO DE DADOS NA LISTA PJ
		g_pj.inserir(new PessoaJuridica(12, "jota empresas", "23567890000190"));
		g_pj.inserir(new PessoaJuridica(123, "letro empresas", "3456789000000123"));

		// PF
		// PERSISTENCIA DOS DADOS NA MEMÓRIA
		g_pf.persistir("dodos_pf.dat");
		// CRIAÇÃO DE UMA NOVA LISTA <PessoaFisica> PARA RECUPERAR OS ARQUIVOS DA
		// MEMÓRIA
		ArrayList<PessoaFisica> pf_recuperada = g_pf.("dodos_pf.dat");

		System.out.println("======================");
		System.out.println("Pessoa Fisica Registrada");
		System.out.println("======================");
		System.out.println(" ");
		for (PessoaFisica pf : pf_recuperada) {

			System.out.println(pf);
		}
		;

		// PJ
		// PERSISTENCIA DOS DADOS NA MEMÓRIA	
		g_pj.persistir("dodos_pj.dat");
		// CRIAÇÃO DE UMA NOVA LISTA <PessoaFisica> PARA RECUPERAR OS ARQUIVOS DA
		// MEMÓRIA

		ArrayList<PessoaFisica> pj_recuperada = g_pj.deserializarPessoas("dodos_pj.dat");
		System.out.println(" ");
		System.out.println("======================");
		System.out.println("Pessoa Juridica Registrada");
		System.out.println("======================");
		for (PessoaFisica pj : pj_recuperada) {

			System.out.println(pj);

		}
		;

	}

}
