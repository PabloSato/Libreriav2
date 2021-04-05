package biblio.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import biblio.colec.Coleccion;
import biblio.ubi.Ubicacion;
import biblio.ubi.Estanteria;

public class MetodosDelete {

	private static Scanner scan = new Scanner(System.in);

	// CONSTRUCTOR
	public MetodosDelete() {

	}

	// METODOS DEL
	// ------------------------------------------------------------------LIBRO
	public void delBook(Connection con) {

		String sql = "DELETE FROM libro WHERE titulo = ?";
		System.out.println("Escribe el titulo del libro que quieres borrar");
		String nombre = scan.nextLine();

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, nombre);
			afect = sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado el libro");

	}

	// ------------------------------------------------------------------AUTOR
	public void delAut(Connection con) {

		String sql = "DELETE FROM autor WHERE alias = ?";
		System.out.println("Escribe el alias del autor que quieres borrar");
		String nombre = scan.nextLine();

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, nombre);
			afect = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado el autor");

	}

	// ------------------------------------------------------------------COLECCION
	public void delCol(Connection con) {

		String sql = "DELETE FROM coleccion WHERE nombre = ?";
		System.out.println("Escribe la coleccion que quieres borrar");
		String nombre = scan.nextLine();

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, nombre);
			afect = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado la coleccion");

	}

	// ------------------------------------------------------------------SAGA
	public void delSaga(Connection con, Coleccion colec) {

		String sql = "DELETE FROM saga WHERE saga = '" + colec.getNombre() + "'";

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, colec.getNombre());
			afect = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado la saga");

	}

	// ------------------------------------------------------------------SAGA2
	public void delSaga(Connection con) {

		String sql = "DELETE FROM saga WHERE nombre = ?";
		System.out.println("Escribe la saga que quieres borrar");
		String nombre = scan.nextLine();

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, nombre);
			afect = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado la saga");

	}

	// ------------------------------------------------------------------TOMO
	// ------------------------------------------------------------------TOMO2
	// ------------------------------------------------------------------UBICACION
	public void delUbic(Connection con) {

		String sql = "DELETE FROM ubicacion WHERE nombre = ?";
		System.out.println("Escribe la coleccion que quieres borrar");
		String nombre = scan.nextLine();

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, nombre);
			afect = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado la ubicacion");

	}

	// ------------------------------------------------------------------ESTANTERIA
	public void delStante(Connection con, Ubicacion ubi) {

		String sql = "DELETE FROM estanteria WHERE ubicacion = '" + ubi.getNombre() + "' AND estanteria = ?";
		System.out.println("Escribe la estanteria que quieres borrar");
		String nombre = scan.nextLine();

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, nombre);
			afect = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado la estanteria");

	}

	// ------------------------------------------------------------------ESTANTERIA2
	public void delBalda(Connection con, Estanteria st) {

		String sql = "DELETE FROM balda WHERE estanteria = '" + st.getNombre() + "' AND balda = ?";
		System.out.println("Escribe la valda que quieres borrar");
		int numero = Integer.parseInt(scan.nextLine());

		PreparedStatement sentencia;
		int afect;

		try {
			sentencia = con.prepareStatement(sql);
			sentencia.setInt(1, numero);
			afect = sentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha borrado la balda");

	}

	// ------------------------------------------------------------------BALDA
	// ------------------------------------------------------------------BALDA2

}
