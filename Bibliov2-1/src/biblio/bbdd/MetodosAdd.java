package biblio.bbdd;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import biblio.autor.Autor;
import biblio.autor.Dibujante;
import biblio.colec.Coleccion;
import biblio.colec.Saga;
import biblio.colec.Tomo;
import biblio.obra.Libro;
import biblio.ubi.Balda;
import biblio.ubi.Estanteria;
import biblio.ubi.Ubicacion;

public class MetodosAdd {

	private static Scanner scan = new Scanner(System.in);
	private static MetodosCheck check = new MetodosCheck();

	// CONSTRUCTOR
	public MetodosAdd() {

	}

	// NO FIN!!!!!

	// METODOS ADD
	// ------------------------------------------------------------------LIBRO
	public Libro addLibro(Connection con) {
		Libro libro = null;
		Autor autor = null;
		Dibujante dibuja = null;
		Coleccion col = null;
		Saga saga = null;
		Tomo tomo = null;
		Ubicacion ub = null;
		Estanteria st = null;
		Balda balda = null;
		ArrayList<Autor> autores = new ArrayList<Autor>();

		int id = 0, paginas = 0;
		String titulo = "", genero = "", idioma = "", alias = "", aliasD = "", siNo = "", min = "";
		boolean flag = false, leido = false, masAut = false, comic = false;

		// -....................................EMPEZAMOS

		// -....................................TITULO-IN
		do {
			try {
				System.out.println("Introduce el titulo");
				titulo = scan.nextLine();
				if (titulo.equals("")) {
					System.out.println("¡No te olvides del Titulo!");
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
		// -....................................TITULO-OUT
		// -....................................COMIC-IN
		do {
			try {
				System.out.println("¿Es un Comic?(Si/No)");
				siNo = scan.nextLine();
				min = siNo.toLowerCase().trim();
				if (min.equals("")) {
					System.out.println("Conteste si o no");
					flag = false;
				} else {
					if (min.equals("si")) {
						comic = true;
						flag = true;
					} else if (min.equals("no")) {
						comic = false;
						flag = true;
					} else {
						System.out.println("Conteste si o no");
						flag = false;
					}
				}
			} catch (Exception e) {
				System.out.println("Valores no aceptados");
				System.out.println(e.toString());
				flag = false;
			}
		} while (flag != true);
		// -....................................COMIC-OUT
		// -....................................AUTOR-IN
		do {
			do {
				try {
					System.out.println("Introduce el alias del Autor:");
					alias = scan.nextLine();
					if (alias.equals("")) {
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

			Autor aut = check.checkAut(con, alias);// comprobamos con la bbdd

			if (aut != null) {
				System.out.println("Ya tenemos el autor: " + aut.getAlias());
				autor = aut;
			} else {

				System.out.println("No tenemos ese autor");
				autor = addAutor(con);// añadimos a la bbdd
				autores.add(autor);
			}
			do {
				try {
					System.out.println("¿Tiene más autores?(Si/No)");
					siNo = scan.nextLine();
					min = siNo.toLowerCase().trim();
					if (min.equals("")) {
						System.out.println("¡Conteste si o no!");
						flag = false;
					} else {
						if (min.equals("si")) {
							masAut = false;
							flag = true;
						} else if (min.equals("no")) {
							masAut = true;
							flag = true;
						} else {
							System.out.println("¡Conteste si o no!");
							flag = false;
						}
					}
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
		} while (masAut != true);
		// -....................................AUTOR-OUT
		// -....................................DIBUJA-IN
		if (comic != false) {
			do {
				try {
					System.out.println("Introduce el alias del Dibujante:");
					aliasD = scan.nextLine();
					if (aliasD.equals("")) {
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

			Dibujante dibu = check.checkDibuj(con, aliasD);// comprobamos con la bbdd

			if (dibu != null) {
				System.out.println("Ya tenemos el autor: " + dibu.getAlias());
				dibuja = dibu;
			} else {

				System.out.println("No tenemos ese autor");
				autor = addDibujante(con);// añadimos a la bbdd
			}
			do {
				try {
					System.out.println("¿Tiene más autores?(Si/No)");
					siNo = scan.nextLine();
					min = siNo.toLowerCase().trim();
					if (min.equals("")) {
						System.out.println("¡Conteste si o no!");
						flag = false;
					} else {
						if (min.equals("si")) {
							masAut = false;
							flag = true;
						} else if (min.equals("no")) {
							masAut = true;
							flag = true;
						} else {
							System.out.println("¡Conteste si o no!");
							flag = false;
						}
					}
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
		}
		// -....................................DIBUJA-OUT

		return libro;
	}

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

		autor = new Autor(nombre, apellidos, alias, bio);

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

		dibuja = new Dibujante(nombre, apellidos, alias, bio);

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

		} while (flag != true);

		colec = new Coleccion(nombre);

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
	// ------------------------------------------------------------------TOMO
	public Tomo addTomo(Connection con, Libro libro) {
		Tomo tomo = null;
		int numero = -1;
		boolean flag = false;

		do {
			System.out.println("¡Vamos a añadir un nuevo número Tomo!");
			do {
				try {
					System.out.println("Introduce el número del Tomo");
					numero = Integer.parseInt(scan.nextLine());
					if (numero < 0) {
						System.out.println("¡Introduce un valor positivo!");
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

		tomo = new Tomo(numero, libro);

		return tomo;
	}

	// ------------------------------------------------------------------TOMO
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

		} while (flag != true);

		ub = new Ubicacion(donde);

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
