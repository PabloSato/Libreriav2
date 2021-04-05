package biblio.bbdd;

import java.sql.Connection;
import java.util.Scanner;

import biblio.autor.Autor;
import biblio.autor.Dibujante;
import biblio.colec.Coleccion;
import biblio.colec.Saga;
import biblio.ubi.Balda;
import biblio.ubi.Estanteria;
import biblio.ubi.Ubicacion;

public class MetodosAdd {

	private static Scanner scan = new Scanner(System.in);

	// CONSTRUCTOR
	public MetodosAdd() {

	}

	// NO FIN!!!!!

	
	
	
	
	
	// METODOS ADD
	// ------------------------------------------------------------------LIBRO
	// ------------------------------------------------------------------DIBUJANTE
	// ------------------------------------------------------------------AUTOR
	public Autor addAutor(Connection con) {
		Autor autor = null;
		String nombre = "", apellidos = "", alias = "", bio = "";
		boolean flag = false;
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

		} while (flag != true);

		return autor;
	}
	// ------------------------------------------------------------------DIBUJANTE

	// ------------------------------------------------------------------DIBUJANTE
	public Dibujante addDibujante(Connection con) {
		Dibujante dibuja = null;
		String nombre = "", apellidos = "", alias = "", bio = "";
		boolean flag = false;
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

		} while (flag != true);

		return dibuja;
	}

	// ------------------------------------------------------------------DIBUJANTE
	// ------------------------------------------------------------------COLECCION
	public Coleccion addCol(Connection con) {
		Coleccion colec = null;
		String nombre = "", siNo = "", min = "", si = "";
		boolean flag = false;

		do {
			System.out.println("¡Vamos a Añadir una nueva Coleccion!");
			do {
				try {

					System.out.println("Introduce el nombre:");
					nombre = scan.nextLine();
					if (nombre.equals("")) {
						System.out.println("¡No te olvides del nombre!");
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

			colec = new Coleccion(nombre);

		} while (flag != true);

		return colec;
	}

	// ------------------------------------------------------------------COLECCION
	// ------------------------------------------------------------------SAGA
	public Saga addSaga(Connection con, Coleccion col) {
		Saga saga = null;
		String nombre = "";
		boolean flag = false;

		do {
			System.out.println("¡Vamos a añadir una nueva saga!");
			do {
				try {
					System.out.println("Introduce el nombre de la saga");
					nombre = scan.nextLine();
					if (nombre.equals("")) {
						System.out.println("¡No te olvides del nombre!");
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

		} while (flag != true);

		saga = new Saga(nombre);

		return saga;
	}

	// ------------------------------------------------------------------SAGA
	// ------------------------------------------------------------------UBI
	public Ubicacion addUbic(Connection con) {
		Ubicacion ub = null;
		Estanteria st = null;
		String donde = "", siNo = "", min = "";
		int valdas = 0;
		boolean flag = false;

		do {
			System.out.println("¡Vamos a Añadir una nueva Ubicación!");
			do {
				try {
					System.out.println("Introduce cual es la ubicación:");
					donde = scan.nextLine();
					if (donde.equals("")) {
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

			ub = new Ubicacion(donde);

		} while (flag != true);

		return ub;
	}

	// ------------------------------------------------------------------UBI
	// ------------------------------------------------------------------STANTE
	public Estanteria addStant(Connection con, Ubicacion ubic) {
		Estanteria st = null;
		String stante, max = "";
		boolean flag = false;

		do {
			try {
				System.out.println("¿Cómo se llama la estanteria?");
				stante = scan.nextLine();
				max = stante.toUpperCase();
				if (max.equals("")) {
					System.out.println("¡No te olvides del nombre!");
					flag = false;
				} else {
					flag = true;
				}
			} catch (Exception e) {
				System.out.println("Valores no permitidos");
				System.out.println(e.toString());
				flag = false;
			}
		} while (flag != true);

		st = new Estanteria(max);

		return st;
	}

	// ------------------------------------------------------------------BALDA
	public Balda addBalda(Connection con, Estanteria st) {
		Balda balda = null;
		int num = 0;
		boolean flag = false;

		do {
			try {
				System.out.println("Introduce el numero de valda");
				num = Integer.parseInt(scan.nextLine());
				if (num < 0) {
					System.out.println("Introuce numeros por encima de 0");
					flag = false;
				} else {
					flag = true;
				}
			} catch (Exception e) {
				System.out.println("Valores no permitidos");
				System.out.println(e.toString());
				flag = false;
			}
		} while (flag != true);

		balda = new Balda(num);

		return balda;
	}

	// ------------------------------------------------------------------BALDA

}
