package controle;

import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import genciadores.Gerenciador_Pessoas;
import genciadores.Testes;

public class main_procedimento1 {

	public static void main(String[] args) {

		Testes t = new Testes();
		Gerenciador_Pessoas<PessoaJuridica> pessoaPJ = new Gerenciador_Pessoas<>();
		Gerenciador_Pessoas<PessoaFisica> pessoaPF = new Gerenciador_Pessoas<>();
		String nome_arqPF = "dados1.dat";
		int pf = 1;
		int pj = 2;
		String nome_arqPJ = nome_arqPF; // pode ate achar redundante , mas a ideia e ja deixar pronto para se o caso
										// quizer criar um rquivo pj separado
										// eu optei em ter somente 1

		Object jota = new PessoaFisica(pf, 1, "jota", "7678", 23);
		Object maria = new PessoaFisica(pf, 2, "maria", "987", 23);
		pessoaPF.carregar(nome_arqPF);

		pessoaPF.ListaPessoas.add((PessoaFisica) jota);
		pessoaPF.ListaPessoas.add((PessoaFisica) maria);
		pessoaPF.persistir(nome_arqPF);

		Object magazine_jota = new PessoaJuridica(pj, 3, "magazine_jota", "2345670000198");
		Object magazine_maria = new PessoaJuridica(pj, 4, "magazine_maria", "67856710000190");
		pessoaPJ.carregar(nome_arqPJ);
		pessoaPJ.ListaPessoas.add((PessoaJuridica) magazine_jota);
		pessoaPJ.ListaPessoas.add((PessoaJuridica) magazine_maria);
		pessoaPJ.persistir(nome_arqPJ);
		
		
		pessoaPF.obterTodos_pf_pj(1, nome_arqPF);
		pessoaPF.obterTodos_pf_pj(2, nome_arqPF);

		/*
		pessoaPF.excluirtodos(nome_arqPF);
		pessoaPF.excluirtodos(nome_arqPJ);
		pessoaPJ.persistir(nome_arqPJ);
		pessoaPJ.persistir(nome_arqPF);
		
		pessoaPF.obterTodos_pf_pj(1, nome_arqPF);
		pessoaPF.obterTodos_pf_pj(2, nome_arqPJ);
*/
	};
}
