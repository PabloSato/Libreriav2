package biblio.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class MetodosCheck {

	private static Scanner scan = new Scanner(System.in);

	// CONSTRUCTOR
	public MetodosCheck() {

	}

	// METODOS CHECK
	// ------------------------------------------------------------------LIBRO
	public void checkBook(Connection con) {

		try {
			System.out.println("Escribe el titulo del libro que buscas");
			String nombre = scan.nextLine();

			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM libro WHERE titulo LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("titulo"));
				System.out.print(" Col:  ");
				System.out.print(rs.getString("coleccion"));
				System.out.print(" (");
				System.out.print(rs.getString("genero"));
				System.out.print(") pag - ");
				System.out.print(rs.getInt("paginas"));
				System.out.print("(idioma: ");
				System.out.print(rs.getString("idioma"));
				System.out.print(" - leido: ");
				System.out.print(rs.getString("leido"));
				System.out.print(") Ubi: ");
				System.out.print(rs.getString("ubicacion"));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}

	}

	// ------------------------------------------------------------------LIBRO2
	public Libro checkBook(Connection con, String nombre) {

		String titulo = "", coleccion = "", saga = "", genero = "", idioma = "", ubicacion = "", estanteria = "";
		String autor = "";
		boolean leido = false;
		int paginas = 0, balda = 0, id = 0, tomo;

		String auto = "";
		Libro libro = null;
		Autor aut = null;
		Coleccion col = null;
		Saga sag = null;
		Ubicacion ub = null;
		Estanteria st = null;
		Balda bald = null;
		Genero gen = null;
		Idioma idi = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM libro WHERE titulo LIKE '%" + nombre + "%'");

			while (rs.next()) {
				id = rs.getInt("indice");
				titulo = rs.getString("titulo");
				autor = rs.getString("autor");
				coleccion = rs.getString("coleccion");
				saga = rs.getString("saga");
				tomo = rs.getInt("tomo");
				genero = rs.getString("genero");
				paginas = rs.getInt("paginas");
				idioma = rs.getString("idioma");
				leido = rs.getBoolean("leido");
				ubicacion = rs.getString("ubicacion");
				estanteria = rs.getString("estanteria");
				balda = rs.getInt("valda");

				col = checkCol(con, coleccion);
				sag = checkSaga(con, col, saga);
				ub = checkUbic(con, ubicacion);
				st = checkStante(con, ub, estanteria);
				bald = checkBalda(con, st, balda);
				gen = checkGenero(con, genero);
				idi = checkIdioma(con, idioma);

				
				

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return libro;

	}

	// ------------------------------------------------------------------AUTOR
	public void checkAut(Connection con) {

		try {
			System.out.println("Escribe el alias del autor que buscas");
			String nombre = scan.nextLine();

			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM autor WHERE alias LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				System.out.print(" ");
				System.out.print(rs.getString("apellidos"));
				System.out.print(" (");
				System.out.print(rs.getString("alias"));
				System.out.print(") ");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}

	}

	// ------REPASARA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Q PASA CON DIBUJANTE!!
	// ------------------------------------------------------------------AUTOR2
	public Autor checkAut(Connection con, String nombre) {
		String name = "", apellidos = "", alias = "", bio = "";
		Autor autor = null, autor1;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM autor WHERE alias LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				name = rs.getString("nombre");
				System.out.print(" ");
				System.out.print(rs.getString("apellidos"));
				apellidos = rs.getString("apellidos");
				System.out.print(" (");
				System.out.print(rs.getString("alias"));
				alias = rs.getString("alias");
				bio = rs.getString("bio");

				System.out.print(") ");
				System.out.println();

				autor = new Autor(name, apellidos, alias, bio);
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return autor;
	}

	// ------------------------------------------------------------------DIBUJANTE
	public void checkDibuj(Connection con) {

		try {
			System.out.println("Escribe el alias del dibujante que buscas");
			String nombre = scan.nextLine();

			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM dibujante WHERE alias LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				System.out.print(" ");
				System.out.print(rs.getString("apellidos"));
				System.out.print(" (");
				System.out.print(rs.getString("alias"));
				System.out.print(") ");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}

	}

	// ------REPASARA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Q PASA CON DIBUJANTE!!
	// ------------------------------------------------------------------DIBUJANTE2
	public Dibujante checkDibuj(Connection con, String nombre) {
		String name = "", apellidos = "", alias = "", bio = "";
		Dibujante dibu = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM dibujante WHERE alias LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				name = rs.getString("nombre");
				System.out.print(" ");
				System.out.print(rs.getString("apellidos"));
				apellidos = rs.getString("apellidos");
				System.out.print(" (");
				System.out.print(rs.getString("alias"));
				alias = rs.getString("alias");
				bio = rs.getString("bio");

				System.out.print(") ");
				System.out.println();

				dibu = new Dibujante(name, apellidos, alias, bio);
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return dibu;
	}

	// ------------------------------------------------------------------COLECCION
	public void checkCol(Connection con) {

		try {

			System.out.println("Escribe el nombre de la coleccion que buscas");
			String nombre = scan.nextLine();
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM coleccion WHERE nombre LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				System.out.print(" ");
				System.out.println();

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------COLECCION2
	public Coleccion checkCol(Connection con, String nombre) {
		String name = "";
		Coleccion col = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM coleccion WHERE nombre LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				name = rs.getString("nombre");
				System.out.print(" ");
				System.out.println();

				col = new Coleccion(name);

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return col;
	}

	// ------------------------------------------------------------------SAGA
	public void checkSaga(Connection con) {

		try {

			System.out.println("Escribe el nombre de la saga que buscas");
			String nombre = scan.nextLine();
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM saga WHERE nombre LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				System.out.print(" ");
				System.out.println();

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------SAGA2
	public Saga checkSaga(Connection con, Coleccion col, String nombre) {
		String name = "", colec = "";
		Saga saga = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM saga WHERE nombre LIKE '%" + nombre + "%'"
					+ " AND coleccion = '" + col.getNombre() + "'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				name = rs.getString("nombre");
				System.out.print(" - ");
				System.out.print(rs.getString("coleccion"));
				colec = rs.getString("coleccion");
				System.out.println();

				saga = new Saga(name);
				System.out.println("Añadida");

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return saga;
	}

	// ------------------------------------------------------------------TOMO-COL
	public void checkTomoCol(Connection con, Coleccion col) {
		int numero = -1;
		try {
			System.out.println("Escribe el número del tomo que buscas de la coleccion");
			numero = Integer.parseInt(scan.nextLine());
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM colec_volumen WHERE numero = " + numero
					+ " AND coleccion = '" + col.getNombre() + "'");

			while (rs.next()) {
				System.out.print(rs.getString("coleccion"));
				System.out.print(" - ");
				System.out.print(rs.getString("titulo"));
				System.out.print(" nº");
				System.out.print(rs.getInt("numero"));
				System.out.println();

			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda tomo en coelccion");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------TOMO2-COLECCION
	public Tomo checkTomoCol(Connection con, Coleccion col, int numero) {
		Tomo tomo = null;
		String colec = "", titulo = "";
		int num = -1;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM colec_volumen WHERE numero = " + numero
					+ " AND coleccion = '" + col.getNombre() + "'");
			while (rs.next()) {
				colec = rs.getString("coleccion");
				titulo = rs.getString("titulo");
				num = rs.getInt("numero");

				tomo = new Tomo(num);
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda del tomo en coelccion");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return tomo;
	}

	// ------------------------------------------------------------------TOMO-SAGA
	public void checkTomoSag(Connection con, Saga saga) {
		int numero = -1;
		try {
			System.out.println("Escribe el número del tomo que buscas de la saga");
			numero = Integer.parseInt(scan.nextLine());
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery(
					"SELECT * FROM saga_volumen WHERE numero = " + numero + " AND saga = '" + saga.getNombre() + "'");

			while (rs.next()) {
				System.out.print(rs.getString("saga"));
				System.out.print(" - ");
				System.out.print(rs.getString("titulo"));
				System.out.print(" nº");
				System.out.print(rs.getInt("numero"));
				System.out.println();

			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda del tomo en saga");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------TOMO2-COLECCION
	public Tomo checkTomoSag(Connection con, Saga sag, int numero) {
		Tomo tomo = null;
		String saga = "", titulo = "";
		int num;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery(
					"SELECT * FROM saga_volumen WHERE numero = " + numero + " AND saga = '" + sag.getNombre() + "'");
			while (rs.next()) {
				saga = rs.getString("saga");
				titulo = rs.getString("titulo");
				num = rs.getInt("numero");

				tomo = new Tomo(num);
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda del tomo en saga aqui");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return tomo;
	}

	// ------------------------------------------------------------------UBIC
	public void checkUbic(Connection con) {

		try {

			System.out.println("Escribe el nombre de la Ubicacion que buscas");
			String nombre = scan.nextLine();
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM ubicacion WHERE nombre LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				System.out.print(" ");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------SAGA
	public Ubicacion checkUbic(Connection con, String nombre) {
		String name = "";
		Ubicacion ub = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM ubicacion WHERE nombre LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				name = rs.getString("nombre");

				ub = new Ubicacion(name);

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return ub;
	}

	// ------------------------------------------------------------------STANTE
	public void checkStante(Connection con) {

		try {

			System.out.println("Escribe el nombre de la estanteria que buscas");
			String nombre = scan.nextLine();
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM estanteria WHERE nombre LIKE '%" + nombre + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				System.out.print(" - ");
				System.out.print(rs.getString("ubicacion"));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------STANTE2
	public Estanteria checkStante(Connection con, Ubicacion ub, String nombre) {
		String name = "";
		Estanteria st = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM estanteria WHERE nombre LIKE '%" + nombre + "%'"
					+ " AND ubicacion = '" + ub.getNombre() + "'");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				name = rs.getString("nombre");

				st = new Estanteria(name);

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return st;
	}

	// ------------------------------------------------------------------BALDA
	public void checkBalda(Connection con, Estanteria st) {

		try {
			System.out.println("Escribe el numero de la balda que buscas");
			int num = Integer.parseInt(scan.nextLine());
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM balda WHERE numero LIKE '%" + num + "%'"
					+ " AND estanteria = '" + st.getNombre() + "'");

			while (rs.next()) {
				System.out.print(rs.getInt("numero"));
				System.out.print(" - ");
				System.out.print(rs.getString("estanteria"));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------BALDA2
	public Balda checkBalda(Connection con, Estanteria st, int num) {

		int balda = 0;
		Balda b = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM balda WHERE numero LIKE '%" + num + "%'"
					+ " AND estanteria = '" + st.getNombre() + "'");

			while (rs.next()) {
				System.out.print(rs.getString("numero"));
				balda = rs.getInt("numero");
				System.out.println();

				b = new Balda(balda);

			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		return b;
	}

	// ------------------------------------------------------------------GENERO
	public void checkGenero(Connection con) {
		try {

			System.out.println("Escribe el nombre del Genero que buscas");
			String genero = scan.nextLine();
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM genero WHERE genero LIKE '%" + genero + "%'");

			while (rs.next()) {
				System.out.print(rs.getString("genero"));
				System.out.print(" ");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda del genero");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

	// ------------------------------------------------------------------GENERO
	public Genero checkGenero(Connection con, String genero) {
		Genero gen = null;

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM genero WHERE genero LIKE '%" + genero + "%'");
			while (rs.next()) {
				String ge = rs.getString("genero");

				gen = new Genero(ge);
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}
		
		return gen;
	}

// ------------------------------------------------------------------IDIOMA
	public void checkIdioma(Connection con) {
		try {

			System.out.println("Escribe el Idioma que buscas");
			String idioma = scan.nextLine();
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM idioma WHERE idioma LIKE '%" + idioma + "%'");
			while (rs.next()) {
				System.out.print(rs.getString("idioma"));
				System.out.print(" ");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda del idioma");
			System.out.println(e.getMessage());
			return;
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
			return;
		}
		return;
	}

// ------------------------------------------------------------------IDIOMA
	public Idioma checkIdioma(Connection con, String idioma) {
		Idioma idiom = null;

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM idioma WHERE idioma LIKE '%" + idioma + "%'");

			while (rs.next()) {
				String idi = rs.getString("idioma");

				idiom = new Idioma(idi);
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar la busqueda");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Valores no Validos");
			System.out.println(e1.getMessage());
		}

		return idiom;
	}

}
