package biblio.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpBbdd {

	public OpBbdd() {

	}

	// ------------------------------------------------------------------CUENTA-LIBRO
	public int verLibroCount(Connection con) {

		int total = 0;

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT count(*) FROM libro");

			while (rs.next()) {
				total = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("Error al contar");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}
		return total;

	}

	// ------------------------------------------------------------CUENTA-LIBRO-AUT
	public int verLibroAutCount(Connection con) {

		int total = 0;

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT count(*) FROM libro_autor");

			while (rs.next()) {
				total = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("Error al contar");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}
		return total;

	}

	// ------------------------------------------------------------CUENTA-LIBRO-BALDA
	public int verLibroBalCount(Connection con) {

		int total = 0;

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT count(*) FROM libro_balda");

			while (rs.next()) {
				total = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("Error al contar");
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error general");
			System.out.println(e1.getMessage());
		}
		return total;

	}

}
