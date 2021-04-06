package biblio.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import biblio.colec.Coleccion;
import biblio.ubi.Estanteria;
import biblio.ubi.Ubicacion;

public class MetodosVer {

	// CONSTRUCTOR
	public MetodosVer() {

	}

	// METODOS VER
	// ------------------------------------------------------------------LIBRO
	public void verLibro(Connection con) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM libro");

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
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

	// ------------------------------------------------------------------AUTOR
	public void verAut(Connection con) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM autor");

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
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

	// ------------------------------------------------------------------COLECCION
	public void verColec(Connection con) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM colec_volumen");

			while (rs.next()) {
				System.out.print(rs.getString("coleccion"));
				System.out.print(" - ");
				if (rs.getString("saga") != null) {
					System.out.print(rs.getString("saga"));
					System.out.print(" - ");
				}
				System.out.print(rs.getString("libro"));
				System.out.print(", Tomo: ");
				System.out.print(rs.getInt("numero"));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

	// ---------------------------------------------------------------------SAGA
	public void verSaga(Connection con) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM saga");

			while (rs.next()) {
				System.out.print(rs.getString("saga"));
				System.out.print(" - ");
				System.out.print(rs.getString("coleccion"));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

	// ---------------------------------------------------------------------SAGA2
	public void verSaga(Connection con, Coleccion colec) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia
					.executeQuery("SELECT * FROM colec_volumen WHERE coleccion = '" + colec.getNombre() + "'");

			while (rs.next()) {
				System.out.print(rs.getString("saga"));
				System.out.print(" - ");
				System.out.print(rs.getString("libro"));
				System.out.print(", Tomo: ");
				System.out.print(rs.getInt("numero"));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

	// ---------------------------------------------------------------------UBICACION
	public void verUbic(Connection con) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM ubicacion");

			while (rs.next()) {
				System.out.print(rs.getString("nombre"));
				System.out.print(" - ");

				Statement sentencia2 = con.createStatement();
				ResultSet rs2 = sentencia2
						.executeQuery("SELECT * FROM estanteria WHERE ubicacion = '" + rs.getString("nombre") + "'");

				while (rs2.next()) {
					System.out.print("Estanteria ");
					System.out.print(rs2.getString("nombre"));
					System.out.print(" - ");

					Statement sentencia3 = con.createStatement();
					ResultSet rs3 = sentencia3.executeQuery(
							"SELECT * FROM valda WHERE estanteria = '" + rs.getString("estanteria") + "'");
					while (rs3.next()) {
						System.out.print("Valda. ");
						System.out.print(rs3.getInt("numero"));
						System.out.println();
					}
					System.out.println();

				}
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

	// ---------------------------------------------------------------------ESTANTERIA
	public void verStante(Connection con, Ubicacion ubi) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia
					.executeQuery("SELECT * FROM estanteria WHERE ubicacion = '" + ubi.getNombre() + "'");

			while (rs.next()) {
				System.out.print("Estanteria ");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

	// ---------------------------------------------------------------------BALDA
	public void verBalda(Connection con, Estanteria st) {

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM balda WHERE estanteria = '" + st.getNombre() + "'");

			while (rs.next()) {
				System.out.print("Estanteria ");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Error al leer");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}

	}

}
