package borrar;

import java.util.ArrayList;
import java.util.Scanner;

public class Borrar {

	public static void main(String[] args) {

		ArrayList<String> autores = new ArrayList<String>();
		String at = "Pepe";
		String at1 = "Jose";
		autores.add(at);
		int total = 0;
		for (int i = 0; i < autores.size(); i++) {
			total += 1;
		}

		if (total > 1) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < autores.size(); i++) {
				sb.append(autores.get(i));
				sb.append(" / ");
			}
			System.out.println("Los autores son " + sb.toString());
		} else {
			System.out.println("El autor es " + autores.get(0));
		}

		autores.add(at1);
		for (int i = 0; i < autores.size(); i++) {
			total += 1;
		}

		if (total > 1) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < autores.size(); i++) {
				sb.append(autores.get(i));
				sb.append(" / ");
			}
			System.out.println("Los autores son " + sb.toString());
		} else {
			System.out.println("El autor es " + autores.get(total));
		}

	}

}
