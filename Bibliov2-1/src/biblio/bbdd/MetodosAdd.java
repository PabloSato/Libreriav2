package biblio.bbdd;

import java.sql.Connection;
import java.util.Scanner;

import biblio.autor.Autor;

public class MetodosAdd {

	private static Scanner scan = new Scanner(System.in);

	// CONSTRUCTOR
	public MetodosAdd() {

	}

	// NO FIN!!!!!

	// METODOS ADD
	// ------------------------------------------------------------------LIBRO
	// ------------------------------------------------------------------AUTOR
	public Autor addAutor(Connection con) {
		String nombre = "", apellidos = "", alias = "", bio = "";
		String siNo, min;
		boolean escritor = false, dibujante = false, flag = false;
		;

		do {
			System.out.println("¡Vamos a Añadir un nuevo Autor!");
			do {
				try {
					System.out.println("Introduce el Nombre:");
					nombre = scan.nextLine();
					if (nombre.equals("")) {
						System.out.println("¡No te Olvides del Nombre!");
						flag = false;
					} else {
						flag = true;
					}
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
			do {
				try {
					System.out.println("Introduce los Apellidos: ");
					apellidos = scan.nextLine();
					if (apellidos.equals("")) {
						System.out.println("¡No te olvides de los Apellidos!");
						flag = false;
					} else {
						flag = true;
					}
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
			do {
				try {
					System.out.println("Introduce el Alias:");
					alias = scan.nextLine();
					if (alias.equals("")) {
						System.out.println("¡No te olvides del Alias!");
						flag = false;
					} else {
						flag = true;
					}
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
			do {
				try {
					System.out.println("Introduce la Biografía: ");
					bio = scan.nextLine();
					flag = true;
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
			do {
				try {
					System.out.println("¿Es escritor? (Si/No)");
					siNo = scan.nextLine();
					if (siNo.equals("")) {
						flag = false;
					} else {
						min = siNo.toLowerCase().trim();
						if (min.equals("si")) {
							escritor = true;
							flag = true;
						} else if (min.equals("no")) {
							escritor = false;
							flag = true;
						} else {
							System.out.println("Contesta si o no");
							flag = false;
						}
					}
					flag = true;
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
			do {
				try {
					System.out.println("¿Es dibujante? (Si/No)");
					siNo = scan.nextLine();
					if (siNo.equals("")) {
						flag = false;
					} else {
						min = siNo.toLowerCase().trim();
						if (min.equals("si")) {
							dibujante = true;
							flag = true;
						} else if (min.equals("no")) {
							dibujante = false;
							flag = true;
						} else {
							System.out.println("Contesta si o no");
							flag = false;
						}
					}
					flag = true;
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
		} while (flag != true);

		if (escritor != false) {
			
		}
		return autor;
	}
	// ------------------------------------------------------------------LIBRO

}
