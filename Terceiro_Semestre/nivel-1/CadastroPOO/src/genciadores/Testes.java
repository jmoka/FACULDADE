package genciadores;

import java.util.Scanner;

public class Testes {

	@SuppressWarnings("resource")
	public static Integer inicio() {
	try {
		System.out.println(Prints.menu());
		Scanner sc = new Scanner(System.in);
		Integer num2 = sc.hasNextInt() ? sc.nextInt() : 9999999;
		if (num2 == 9999999 || num2 < 0 || num2 > 9) {
			System.out.println("Opss... DIGITE SOMENTE NUMEROS INTEIROS DE 0 A 9 ");
			num2 = inicio();
		}

		return num2;
	} catch (Exception e) {
       
        System.out.println("erro verificar linha 14 a 26 " + e.getMessage());
        return null;
    }
	};

	public static String passo2() {
		try {
		System.out.println(Prints.menu2());
		Scanner sc = new Scanner(System.in);
		String letra = sc.next();
		if (!letra.equals("f") && !letra.equals("F") && !letra.equals("J") && !letra.equals("j")) {
			System.out.println("Opss... ALGO DEU ERRADO");
			letra = passo2();
		}

		return letra;
		} catch (Exception e) {
		       
	        System.out.println("erro verificar linha 31 a 44 Classe TestePF" + e.getMessage());
	        return null;
	    }

	};
	

	
}
