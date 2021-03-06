package biblio.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import biblio.autor.Autor;
import biblio.autor.Dibujante;
import biblio.colec.Coleccion;
import biblio.colec.Saga;
import biblio.colec.Tomo;
import biblio.misc.Genero;
import biblio.misc.Idioma;
import biblio.obra.Libro;
import biblio.ubi.Balda;
import biblio.ubi.Estanteria;
import biblio.ubi.Ubicacion;

public class MetodosAdd {

	private static Scanner scan = new Scanner(System.in);
	private static MetodosCheck check = new MetodosCheck();
	private static OpBbdd op = new OpBbdd();

	// CONSTRUCTOR
	public MetodosAdd() {

	}

	// METODOS ADD
	// ------------------------------------------------------------------LIBRO
	public Libro addLibro(Connection con) {
		Libro libro = null;
		Autor autor = null;
		Dibujante dibuja = null;
		Coleccion col = null;
		Saga saga = null;
		Tomo tomoCol = null;
		Tomo tomoSag = null;
		Ubicacion ub = null;
		Estanteria st = null;
		Balda balda = null;
		ArrayList<Autor> autores = new ArrayList<Autor>();
		Genero gen = null;
		Idioma idio = null;

		int id = 0, paginas = 0, tom = -1, bald = 0;
		String titulo = "", genero = "", idioma = "", alias = "";
		String aliasD = "", siNo = "", min = "", clc = "", sg = "";
		String donde = "", stant = "";
		boolean flag = false, leido = false, masAut = false;
		boolean comic = false, colec = false, sag = false, tc = false;

		// -....................................EMPEZAMOS
		do {
			// -....................................TITULO-IN
			do {
				try {
					System.out.println("Introduce el titulo");
					titulo = scan.nextLine().trim();
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
						alias = op.toMayus(scan.nextLine().trim());
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
					autores.add(aut);
				} else {

					System.out.println("No tenemos ese autor");
					autor = addAutor(con);// añadimos a la bbdd
					autores.add(autor);
				}
				do {
					try {
						System.out.println("¿Tiene más autores?(Si/No)");
						siNo = scan.nextLine().trim();
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
						aliasD = op.toMayus(scan.nextLine().trim());
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

				dibuja = check.checkDibuj(con, aliasD);// comprobamos con la bbdd

				if (dibuja != null) {
					System.out.println("Ya tenemos el autor: " + dibuja.getAlias());
				} else {

					System.out.println("No tenemos ese autor");
					dibuja = addDibujante(con);// añadimos a la bbdd
				}
				System.out.println(dibuja.getAlias());
			}
			// -....................................COLEC-IN
			do {
				try {
					System.out.println("¿El libro pertenece a alguna Coleccion?(Si/No)");
					siNo = scan.nextLine();
					min = siNo.toLowerCase().trim();
					if (min.equals("")) {
						System.out.println("Conteste si o no");
						flag = false;
					} else {
						if (min.equals("si")) {
							colec = true;
							flag = true;
						} else if (min.equals("no")) {
							colec = false;
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
			if (colec != false) {
				do {
					try {
						System.out.println("Introduce el Nombre de la Coleccion:");
						clc = scan.nextLine().trim();
						if (clc.equals("")) {
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

				col = check.checkCol(con, clc);

				if (col != null) {
					System.out.println("Ya tenemos la Coleccion " + col.getNombre());
				} else {
					System.out.println("Aun no tenemos esa coleccion");
					col = addCol(con);
				}
			}
			// -....................................COLEC-OUT

			// -....................................SAGA-IN
			if (colec != false) {
				do {
					try {
						System.out.println("¿El libro pertenece a alguna Saga?(Si/No)");
						siNo = scan.nextLine().trim();
						min = siNo.toLowerCase().trim();
						if (min.equals("")) {
							System.out.println("Conteste si o no");
							flag = false;
						} else {
							if (min.equals("si")) {
								sag = true;
								flag = true;
							} else if (min.equals("no")) {
								sag = false;
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
				if (sag != false) {
					do {
						try {
							System.out.println("Introduce el Nombre de la Saga:");
							sg = scan.nextLine().trim();
							if (sg.equals("")) {
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

					saga = check.checkSaga(con, col, sg);

					if (saga != null) {
						System.out.println("Ya tenemos la saga " + saga.getNombre());
					} else {
						System.out.println("Aun no tenemos esa saga");
						saga = addSaga(con, col);
						col.getSagas().add(saga);
					}
				}
			}
			// -....................................SAGA-OUT
			// -....................................TOMO-IN
			if (colec != false) {
				do {
					System.out.println("Añadimos número de tomo");
					do {
						try {
							System.out.println("Introduce número");
							tom = Integer.parseInt(scan.nextLine().trim());
							if (tom < 0) {
								System.out.println("Introduce numero superiores a 0");
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

					if (sag != false) {

						tomoSag = check.checkTomoSag(con, saga, tom);

						if (tomoSag != null) {
							System.out.println("Este número ya está asignado a un volumen");
							System.out.println(saga.getTomos().get(tom).getNumero());
							flag = false;
						} else {
							tomoSag = addTomo(con, tom);
							saga.getTomos().add(tomoSag);
						}
					} else {

						tomoCol = check.checkTomoCol(con, col, tom);

						if (tomoCol != null) {
							System.out.println("Este número ya está asignado a un volumen");
							System.out.println(col.getTomos().get(tom).getNumero());
							flag = false;
						} else {
							tomoCol = addTomo(con, tom);
							col.getTomos().add(tomoCol);
						}

					}

				} while (flag != true);

			}

			// -....................................TOMO-OUT
			// -....................................TOMCOL EN SAG-IN
			if ((colec != false) && (sag != false)) {
				do {
					try {
						System.out.println("¿El libro tiene un número en la colección?(Si/No)");
						siNo = scan.nextLine();
						min = siNo.toLowerCase().trim();
						if (min.equals("")) {
							System.out.println("Conteste si o no");
							flag = false;
						} else {
							if (min.equals("si")) {
								tc = true;
								flag = true;
							} else if (min.equals("no")) {
								tc = false;
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
			}
			if (tc != false) {
				do {
					System.out.println("Añadimos número de tomo");
					do {
						try {
							System.out.println("Introduce número");
							tom = Integer.parseInt(scan.nextLine().trim());
							if (tom < 0) {
								System.out.println("Introduce numero superiores a 0");
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

					tomoCol = check.checkTomoCol(con, col, tom);

					if (tomoCol != null) {
						System.out.println("Este número ya está asignado a un volumen");
						System.out.println(col.getTomos().get(tom).getNumero());
						flag = false;
					} else {
						tomoCol = addTomo(con, tom);
						col.getTomos().add(tomoCol);
					}

				} while (flag != true);
			}
			// -....................................TOMCOL EN SAG-OUT
			// -....................................GENERO-IN
			do {
				try {
					System.out.println("Introduce Género Literario:");
					genero = op.toMayus(scan.nextLine());
					if (genero.equals("")) {
						System.out.println("¡No te olvides del Genero!");
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

			gen = check.checkGenero(con, genero);
			if (gen != null) {
				System.out.println("Ya tenemos la genero " + gen.getGenero());
			} else {
				gen = addGenero(con, genero);
			}

			// -....................................GENERO-OUT
			// -....................................IDIOMA-IN
			do {
				try {
					System.out.println("¿En qué idioma está?");
					idioma = op.toMayus(scan.nextLine());
					if (idioma.equals("")) {
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

			idio = check.checkIdioma(con, idioma);

			if (idio != null) {
				System.out.println("Ya tenemos el idioma " + idio.getIdioma());

			} else {

				idio = addIdioma(con, idioma);
			}

			// -....................................IDIOMA-OUT
			// -....................................PAGINAS-IN
			do {
				try {
					System.out.println("¿Cuantas páginas tiene?");
					paginas = Integer.parseInt(scan.nextLine().trim());
					if (paginas > 0) {
						flag = true;
					} else {
						flag = false;
					}
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
			// -....................................PAGINAS-OUT
			// -....................................UBICACION-IN
			do {
				System.out.println("¿Dónde está?");
				do {
					try {
						System.out.println("Introduce donde:");
						donde = op.toMayus(scan.nextLine().trim());
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

			ub = check.checkUbic(con, donde);

			if (ub != null) {
				System.out.println("Ubicacion " + ub.getNombre());
			} else {
				System.out.println("Aún no tenemos esa ubicación");
				ub = addUbic(con);
			}
			// -....................................UBIACION-OUT
			// -....................................ESTANTERIA-IN
			do {
				System.out.println("¿En qué Estantería está el libro?");
				do {
					try {
						System.out.println("Introduce la Estanteria");
						stant = scan.nextLine().trim();
						if (stant.equals("")) {
							System.out.println("¡No te olvides de la Estanteria!");
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

			st = check.checkStante(con, ub, stant);

			if (st != null) {
				System.out.println("Estanteria " + st.getNombre());
			} else {
				System.out.println("No tenemos esa estanteria");
				st = addStant(con, ub);
				ub.getEstanterias().add(st);
			}

			// -....................................ESTANTERIA-OUT
			// -....................................BALDA-IN
			do {
				System.out.println("¿En qué Balda está el libro?");
				do {
					try {
						System.out.println("Introduce el numero de Balda");
						bald = Integer.parseInt(scan.nextLine().trim());
						if (bald <= 0) {
							System.out.println("Introduce valores superiores a 0");
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

			balda = check.checkBalda(con, st, bald);

			if (balda != null) {
				System.out.println("Balda " + balda.getNumero());
			} else {
				System.out.println("No tenemos esa balda");
				balda = addBalda(con, ub, st);
				st.getBaldas().add(balda);
			}
			// -....................................BALDA-OUT
			// -....................................LEIDO-IN
			do {
				try {
					System.out.println("¿Te lo has leido ya?");
					siNo = scan.nextLine().trim();
					if (siNo.equals("")) {
						flag = false;
					} else {
						min = siNo.toLowerCase();

						if (min.equals("si")) {
							leido = true;
							flag = true;
						} else if (min.equals("no")) {
							leido = false;
							flag = true;
						} else {
							flag = false;
						}
					}
				} catch (Exception e) {
					System.out.println("Valores no aceptados");
					System.out.println(e.toString());
					flag = false;
				}
			} while (flag != true);
			// -....................................LEIDO-OUT
			// -....................................ID-IN
			String tabla = "libro";
			id = op.contar(con, tabla) + 1;// me autogenero un nuevo id
			// -....................................ID-OUT

			// -....................................CREACION-IN
			if (colec != false) {
				if (sag != false) {
					// TENEMOS SAGA Y COLECCION
					if (tc == false) {
						tomoCol = new Tomo();
					}
				} else {
					// TENEMOS COLECCION, NO TENEMOS SAGA
					saga = new Saga();
					tomoSag = new Tomo();
				}
			} else {
				// NO TENEMOS NI COLECCION NI SAGA
				col = new Coleccion();
				saga = new Saga();
				tomoCol = new Tomo();
				tomoSag = new Tomo();
			}
			libro = new Libro(id, titulo, paginas, genero, idioma, leido, autores, col, saga, tomoCol, tomoSag, ub, st,
					balda);
			balda.getLibros().add(libro);
			// -....................................CREACION-OUT
			// -....................................BBDD-IN
			addBook(con, libro);// añadimos libro a la BBDD
			for (int i = 0; i < autores.size(); i++) {
				addAutoBook(con, autores.get(i), libro);// añadimos Libro y Autores a la tabla intermedia
			}
			if (colec != false) {
				if (sag != false) {
					addTomSag(con, saga, tomoSag, libro);// añadimos tomo a la Saga
					if(tc != false) {
						addTomCol(con, col, libro, tomoCol);
					}
				} else {

					addTomCol(con, col, libro, tomoCol);// añadimos tmo a a Coleccin
				}
			}
			addToBalda(con, libro, balda, st, ub);// añadimos libro a la Balda
			if (comic != false) {
				for (int i = 0; i < autores.size(); i++) {
					addComic(con, autores.get(i), dibuja, libro);// añadimos Comic a la tabla intermedia
				}
			}
			// -....................................BBDD-OUT
		} while (flag != true);
		return libro;

	}

	// ------------------------------------------------------------------LIBRO
	private void addBook(Connection con, Libro libro) {
		String sql = "INSERT INTO libro (titulo, paginas, genero, idioma, leido, coleccion, saga, ubicacion, estanteria, balda, tomoCol, tomoSag)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			//sentencia.setInt(1, libro.getId());
			sentencia.setString(1, libro.getTitulo());
			sentencia.setInt(2, libro.getPaginas());
			sentencia.setString(3, libro.getGenero());
			sentencia.setString(4, libro.getIdioma());
			sentencia.setBoolean(5, libro.isLeido());
			sentencia.setString(6, libro.getColeccion().getNombre());
			sentencia.setString(7, libro.getSaga().getNombre());
			sentencia.setString(8, libro.getUbicacion().getNombre());
			sentencia.setString(9, libro.getEstanteria().getNombre());
			sentencia.setInt(10, libro.getBalda().getNumero());
			sentencia.setInt(11, libro.getTomoCol().getNumero());
			sentencia.setInt(12, libro.getTomoSag().getNumero());

			af = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar libros aqui");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " libros");
	}

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
		addAut(con, autor);// añado autor a la tabla
		return autor;
	}

	// ------------------------------------------------------------------AUTOR-BBDD
	private void addAut(Connection con, Autor autor) {
		String sql = "INSERT INTO autor(nombre, apellidos, alias, bio)" + " VALUES(?, ?, ?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, autor.getNombre());
			sentencia.setString(2, autor.getApellidos());
			sentencia.setString(3, autor.getAlias());
			sentencia.setString(4, autor.getBio());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar autor");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " autores");

	}

	// ------------------------------------------------------------------DIBUJANTE
	public Dibujante addDibujante(Connection con) {
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

		Dibujante dibuja = new Dibujante(nombre, apellidos, alias, bio);
		addDibu(con, dibuja);
		return dibuja;
	}

	// ------------------------------------------------------------------DIBUJANTE
	private void addDibu(Connection con, Dibujante dibu) {
		String sql = "INSERT INTO dibujante(nombre, apellidos, alias, bio)" + " VALUES(?, ?, ?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, dibu.getNombre());
			sentencia.setString(2, dibu.getApellidos());
			sentencia.setString(3, dibu.getAlias());
			sentencia.setString(4, dibu.getBio());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar autor");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " dibujantes");

	}

	// ------------------------------------------------------------------COLECCION
	public Coleccion addCol(Connection con) {
		Coleccion colec = null;
		String nombre = "";
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
		addColec(con, colec);
		return colec;
	}

	// ------------------------------------------------------------------COLECCION
	private void addColec(Connection con, Coleccion colec) {
		String sql = "INSERT INTO coleccion(nombre)" + " VALUES(?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, colec.getNombre());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar coleccion");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " colecciones");

	}

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
		addSaga(con, col, saga);
		return saga;
	}

	// ------------------------------------------------------------------SAGA
	private void addSaga(Connection con, Coleccion colec, Saga saga) {
		String sql = "INSERT INTO saga(nombre, coleccion)" + " VALUES(?, ? )";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, saga.getNombre());
			sentencia.setString(2, colec.getNombre());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar saga");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " sagas");

	}

	// ------------------------------------------------------------------TOMO
	public Tomo addTomo(Connection con) {
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

		tomo = new Tomo(numero);

		return tomo;
	}

	// ------------------------------------------------------------------TOMO2
	public Tomo addTomo(Connection con, int numero) {
		Tomo tomo = null;

		tomo = new Tomo(numero);

		return tomo;
	}

	// ------------------------------------------------------------------TOMO-COL
	private void addTomCol(Connection con, Coleccion col, Libro libro, Tomo tomo) {
		String sql = "INSERT INTO colec_volumen(coleccion, libro, numero) VALUES(?, ?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, col.getNombre());
			sentencia.setString(2, libro.getTitulo());
			sentencia.setInt(3, tomo.getNumero());
			af = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en tabla col_volumen");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " a la tabla");
	}

	// ------------------------------------------------------------------TOMO-SAG
	private void addTomSag(Connection con, Saga saga, Tomo tomo, Libro libro) {
		String sql = "INSERT INTO saga_volumen(saga, libro, numero) VALUES(?, ?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, saga.getNombre());
			sentencia.setString(2, libro.getTitulo());
			sentencia.setInt(3, tomo.getNumero());
			af = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en tabla saga_volumen");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " a la tabla");
	}

	// ------------------------------------------------------------------UBI
	public Ubicacion addUbic(Connection con) {
		Ubicacion ub = null;
		String donde = "";
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
		addUbic(con, ub);
		return ub;
	}

	// ------------------------------------------------------------------UBI
	private void addUbic(Connection con, Ubicacion ubic) {
		String sql = "INSERT INTO ubicacion(nombre)" + " VALUES(?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, ubic.getNombre());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar ubicacion");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " ubicaciones");

	}

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
		addStnts(con, ubic, st);
		return st;
	}

	// ------------------------------------------------------------------STANTERIA
	private void addStnts(Connection con, Ubicacion ubic, Estanteria st) {
		String sql = "INSERT INTO estanteria(nombre, ubicacion)" + " VALUES(?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, st.getNombre());
			sentencia.setString(2, ubic.getNombre());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar estanteria");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " estanterias");

	}

	// ------------------------------------------------------------------BALDA
	public Balda addBalda(Connection con, Ubicacion ub, Estanteria st) {
		Balda balda = null;
		int num = 0;
		boolean flag = false;

		do {
			try {
				System.out.println("Introduce el numero de Balda");
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
		addBalda(con, ub, st, balda);
		return balda;
	}

	// ------------------------------------------------------------------BALDA
	private void addBalda(Connection con, Ubicacion ub, Estanteria st, Balda bald) {
		String sql = "INSERT INTO balda(numero, ubicacion, estanteria)" + " VALUES(?, ?, ?)";
		String tabla = "balda";
		int id = op.contar(con, tabla) + 1;// autor genero un id nuevo

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			//sentencia.setInt(1, id);
			sentencia.setInt(1, bald.getNumero());
			sentencia.setString(2, ub.getNombre());
			sentencia.setString(3, st.getNombre());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar Balda");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " baldas");

	}

	// ------------------------------------------------------------------BALDA
	private void addToBalda(Connection con, Libro libro, Balda balda, Estanteria st, Ubicacion ub) {
		String tabla = "libro_balda";
		String sql = "INSERT INTO libro_balda(libro, balda, estanteria, ubicacion) VALUES(?, ?, ?, ?)";
		int id = op.contar(con, tabla) + 1;// autor genero un id nuevo

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			//sentencia.setInt(1, id);
			sentencia.setString(1, libro.getTitulo());;
			sentencia.setInt(2, balda.getNumero());
			sentencia.setString(3, st.getNombre());
			sentencia.setString(4, ub.getNombre());
			af = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar Libro a la balda");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha añadido " + af + " Libros a las baldas");
	}

	// ------------------------------------------------------------------COMIC
	private void addComic(Connection con, Autor autor, Dibujante dibu, Libro libro) {
		String tabla = "libro_autor_dibujante";
		int id = op.contar(con, tabla)+1;// auto genero un ID nuevo
		String sql = "INSERT INTO libro_autor_dibujante(libro, autor, dibujante) VALUES(?, ?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			//sentencia.setInt(1, id);
			sentencia.setString(1, libro.getTitulo());
			sentencia.setString(2, autor.getAlias());
			sentencia.setString(3, dibu.getAlias());
			af = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar Libro al dibujante");
			System.out.println(e.getMessage());
			return;
		}

		System.out.println("Se ha añadido " + af + " Comic");
	}

	// ------------------------------------------------------------------AUTOR-LIBRO
	private void addAutoBook(Connection con, Autor autor, Libro libro) {
		String tabla = "libro_autor";
		int id = op.contar(con, tabla) + 1;// auto genero un id nuevo
		String sql = "INSERT INTO libro_autor(libro, autor) VALUES(?, ?)";

		PreparedStatement sentencia;
		int af;
		try {
			sentencia = con.prepareStatement(sql);
			//sentencia.setInt(1, id);
			sentencia.setString(1, libro.getTitulo());
			sentencia.setString(2, autor.getAlias());
			af = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar Libro al autor");
			System.out.println(e.getMessage());
			return;
		}

		System.out.println("Se ha añadido " + af + " Libro al autor");
	}

	// ------------------------------------------------------------------GENERO
	public Genero addGenero(Connection con, String genero) {
		Genero gen = null;

		gen = new Genero(genero);
		addGen(con, gen);

		return gen;
	}

	// ------------------------------------------------------------------GENERO-BBDD
	private void addGen(Connection con, Genero genero) {

		String sql = "INSERT INTO genero(genero) VALUES(?)";

		PreparedStatement sentencia;
		int af;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, genero.getGenero());
			af = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el género");
			System.out.println(e.getMessage());
			return;
		}

		System.out.println("Se ha añadido " + af + " genero");

	}

	// ------------------------------------------------------------------IDIOMA
	public Idioma addIdioma(Connection con, String idioma) {
		Idioma id = null;

		id = new Idioma(idioma);
		addIdio(con, id);

		return id;
	}

	// ------------------------------------------------------------------IDIOMA-BBDD
	private void addIdio(Connection con, Idioma idioma) {

		String sql = "INSERT INTO idioma(idioma) VALUES(?)";

		PreparedStatement sentencia;
		int af;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, idioma.getIdioma());
			af = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar el género");
			System.out.println(e.getMessage());
			return;
		}

		System.out.println("Se ha añadido " + af + " idioma");
	}

}
