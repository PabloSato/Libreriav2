package borrar;

import java.util.Scanner;

public class Borrar {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String lee = toMayus(scan.nextLine());
		System.out.println(lee);
		
		
		
		

	}

	public static String toMayus(String cadena) {
		String corta = cadena.trim();
		
		return corta.toUpperCase().charAt(0) + corta.substring(1, corta.length()).toLowerCase();
		
	}

}
