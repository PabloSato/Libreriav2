package biblio.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import biblio.autor.Autor;
import biblio.autor.Escritor;
import biblio.colec.Coleccion;
import biblio.colec.Saga;
import biblio.ubi.Balda;
import biblio.ubi.Estanteria;
import biblio.ubi.Ubicacion;

public class MetodosCheck {

	private static Scanner scan = new Scanner(System.in);
	
	//CONSTRUCTOR
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

				autor = new Escritor(name, apellidos, alias, bio);
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

				col = new Coleccion(nombre);

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
	public void checkValda(Connection con, Estanteria st) {

		try {
			System.out.println("Escribe el numero de la valda que buscas");
			int num = Integer.parseInt(scan.nextLine());
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM valda WHERE numero LIKE '%" + num + "%'"
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
	public Balda checkValda(Connection con, Estanteria st, int num) {

		int balda = 0;
		Balda b = null;
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM valda WHERE numero LIKE '%" + num + "%'"
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
	// ------------------------------------------------------------------SAGA

}
