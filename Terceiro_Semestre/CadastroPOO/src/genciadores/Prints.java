package genciadores;

public class Prints {

	public static String menu() {

		return String.format(
				"Escolha uma das Opcoes Abaixo%n1- Incluir Pessoa%n2- Alterar Pessoa por ID%n3- Excluir Pessoa por ID%n4- Buscar Pessoa por ID%n5- Exibir Todos%n6- Deletar Todos%n7- Exibir Todos PF ou PJ%n8- Deletar Todos - PF ou PJ%n9- Creditos%n0- Finalizar Programa");

	};

	public static String menu2() {

		return String.format("Escolha entre PF ou PJ %n=====================%nF - Pessoa Fisica %nJ - Pessoa Juridica");

	};

	public static String erroNumeroInformado() {

		return String.format("Informe um numero correspondente na lista Acima");	

	};
	
	public static String creditos() {

		return String.format("Faculdade Estcacio de Sa%nAluno: Joao Luiz Silva Tavares");	

	}

	public static void pf_pj(int num) {
		
		if(num == 1) {
			System.out.println("====Lista de todas as Pessoas Fisicas====");
		}else {

		System.out.println("====Lista de todas as Pessoas Juridica====");
		}
	

	}
	
public static void pf_pj_excluida(int num) {
		
		if(num == 1) {
			System.out.println("====Lista de todas as Pessoas Fisicas Excluida====");
		}else {

		System.out.println("====Lista de todas as Pessoas Juridica Excluida====");
		}

};
}