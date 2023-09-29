package controle;

import entidades.PessoaJuridica;
import genciadores.Gerenciador_Pessoas;
import genciadores.Prints;
import genciadores.Testes;
import genciadores.TestesPF;
import genciadores.TestesPJ;

public class main_procedimento2 {

	public static void main(String[] args) {
		Testes t = new Testes();
		Gerenciador_Pessoas<PessoaJuridica> pessoa = new Gerenciador_Pessoas<>();
		String nome_arq = "dados.dat";
		
		Integer num = Testes.inicio(); 
		if(num == 9) {
			System.out.println( Prints.creditos() );
		}else if(num==5){
			
			pessoa.obterTodos_pf_pj(1, nome_arq);
			
			pessoa.obterTodos_pf_pj(2, nome_arq);
		}else if(num == 6){
			pessoa.excluirtodos(nome_arq);
		}else{
			String letra = t.passo2(); 
			String pf_pj = letra.equals("f") || letra.equals("F") ? TestesPF.pf(num) : TestesPJ.pj(num);
			
		};
		

	}

	

}