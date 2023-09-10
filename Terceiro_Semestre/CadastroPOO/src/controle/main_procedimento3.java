package controle;

import java.util.InputMismatchException;
import java.util.Scanner;

import genciadores.Prints;

public class main_procedimento3 {

	public static void main(String[] args) {

		chamaMenu();
		interacao1();
		interacao2();
	};

	public static void chamaMenu() {
		System.out.println(Prints.menu());
		System.out.println("Digite Abaixo o Numero Desejado!!");

	};

	public static Integer interacao1() {
		Scanner sc = new Scanner(System.in);
		Integer sc1 = sc.nextInt();
		try {
			if (sc1 > 9 || sc1 < 0) {
				System.out.println(Prints.erroNumeroInformado());
				chamaMenu();
			}			
			
		}catch (InputMismatchException e) {
			
			System.out.println("informe valor correto" + e);
			chamaMenu();
			
		}{
			return sc1;
		}

		

	};

	public static String interacao2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite Abaixo a Letra Desejada");
		System.out.println(Prints.menu2());
		String sc2 = sc.next();
		if (!sc2.equals("f") && !sc2.equals("F") && !sc2.equals("J") && !sc2.equals("j")) {
			System.out.println("Opss.. voce digitou Valor errado!!");
			interacao2();
		}
		return sc2;

	};
};
