package main;

import java.util.Scanner;

public class Menu {
	private static Scanner scan = new Scanner(System.in);

	Menu() {

	}

	// ---------------------------------------------------------MENUS
	public static char mostrarMenu() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU BIBLIOTECA----");
		System.out.println("1.Menu Libros"); // menuLibros() V
		System.out.println("2.Menu Autores");// menuAutores() V
		System.out.println("3.Menu Colecciones");// menuColecciones() V
		System.out.println("4.Menu Ubicaciones");// menuUbicaciones() V
		System.out.println("-----------------");
		System.out.println("0.Salir");// mostrarMenu(); V

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

//----------------------------------------------------menuLibro
	public static char menuLibros() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU LIBROS----");
		System.out.println("1.Ver Libros"); // verLibros(); V
		System.out.println("2.Añadir Libro");// adLibro() V
		System.out.println("3.Buscar Libro");// checkLibro(String titulo); V
		System.out.println("4.Eliminar Libro");// delLibro(Libro) V
		System.out.println("-----------------");
		System.out.println("0.Volver");// mostrarMenu(); V

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

	// ---------------------------------------------------------------------AUTORES
	public static char menuAutores() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU Autores----");
		System.out.println("1.Ver Autores");// verAutores(); V
		System.out.println("2.Añadir Autor");// addAutor() V
		System.out.println("3.Buscar Autor");// checkAutor(String nombre) V
		System.out.println("4.Eliminar Autor");// delAutor(Autor);
		System.out.println("-----------------");
		System.out.println("0.Volver");// mostrarMenu();

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

	// ---------------------------------------------------------------------COLECC
	public static char menuColeccion() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU COLECCIÓN----");
		System.out.println("1.Ver Colecciones");// verColecciones();
		System.out.println("2.Añadir Colección");// addCol();
		System.out.println("3.Buscar Colección");// checkCol(Coleccion);
		System.out.println("4.Eliminar Colección");// delCol(Coleccion)
		System.out.println("5.Menu Sagas");// menuSagas();
		System.out.println("-----------------");
		System.out.println("0.Volver");// mostrarMenu();

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

	// ---------------------------------------------------------------------SAGA
	public static char menuSagas() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU SAGAS----");
		System.out.println("1.Ver Sagas");// verSagas()---------??
		System.out.println("2.Añadir Saga");// addSaga();
		System.out.println("3.Buscar Saga");// checkSaga(Saga);
		System.out.println("4.Eliminar Saga");// delSaga(Saga);
		System.out.println("-----------------");
		System.out.println("0.Volver");// menuColecciones();

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

	// ---------------------------------------------------------------------UBIC
	public static char menuUbicacion() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU UBICACIÓN----");
		System.out.println("1.Ver Ubicaciones");// verUbicaciones();
		System.out.println("2.Añadir Ubicación");// addUbic();
		System.out.println("3.Buscar Ubicación");// checkUbicacion(Ubicacion);
		System.out.println("4.Eliminar Ubicación");// delUbic(Ubicacion)
		System.out.println("5.Menu Estanterias");// menuStanterias();
		System.out.println("-----------------");
		System.out.println("0.Volver");// mostrarMenu();

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

	// ---------------------------------------------------------------------STANTE
	public static char menuStanterias() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU ESTANTERIAS----");
		System.out.println("1.Ver Estanterias");// verStante();-----NO EXISTE
		System.out.println("2.Añadir Estanteria");// addStante();
		System.out.println("3.Buscar Estanteria");// checkStanter---------???
		System.out.println("4.Eliminar Estanteria");// delStante()--------???
		System.out.println("5.Menu Valdas");// menuValdas();
		System.out.println("-----------------");
		System.out.println("0.Volver");// menuUbicacion();

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

	// ---------------------------------------------------------------------BALDAS
	public static char menuBaldas() {
		String opcion = "", max;
		boolean flag = false;

		System.out.println("----MENU VALDAS----");
		System.out.println("1.Ver Baldas");// verValdas();-----NO EXISTE
		System.out.println("2.Añadir Balda");// addValda();
		System.out.println("3.Buscar Balda");// checkValda---------???
		System.out.println("4.Eliminar Balda");// delV()--------???
		System.out.println("-----------------");
		System.out.println("0.Volver");// menuEstanteria();

		do {
			try {
				opcion = scan.nextLine();
				if (opcion.equals("")) {
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

		max = opcion.toUpperCase();

		return max.charAt(0);
	}

}