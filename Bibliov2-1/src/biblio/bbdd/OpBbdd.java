package biblio.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpBbdd {

	public OpBbdd() {

	}

	// ------------------------------------------------------------------CONTAR
	public int contar(Connection con, String tabla) {
		int cuenta = 0;

		cuenta = verCount(con, tabla);

		return cuenta;
	}

	// ------------------------------------------------------------------CONTAR
	private int verCount(Connection con, String tabla) {

		int total = 0;

		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT count(*) FROM " + tabla);

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
	// ------------------------------------------------------------------MAYUSCULAS
	public String toMayus(String cadena) {
		String corta = cadena.trim();
		
		return corta.toUpperCase().charAt(0) + corta.substring(1, corta.length()).toLowerCase();
		
	}
	public String toMayusPalabra(String cadena) {
		
		return "";
	}

}
