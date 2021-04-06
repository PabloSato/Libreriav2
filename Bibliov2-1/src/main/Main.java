package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static Menu menu = new Menu();

	public static void main(String[] args) {

		Connection con = abrirConexionBD();

		char opc = 0;

		do {
			opc = menu.mostrarMenu();
			switch (opc) {
			case '1':
				menu.menuLibros();
				break;
			case '2':
				menu.menuAutores();
				break;
			case '3':
				break;
			case '4':
				break;
			case '0':
				break;
			default:
				System.out.println("Introduce numeros de 1 al 4 o 0 para salir");

			}

		} while (opc != 0);

	}

	// ---------------------------------------------------------------------BBDD-------------

	private static Connection abrirConexionBD() {
		Connection con;

		// PASO1 - CARGAR EL DRIVER
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectar");
			System.out.println(e.getMessage());
			return null;
		}

		System.out.println("Driver cargado");

		// PASO 2 - ESTABLECER CONEXION
		String conex = "jdbc:mysql://127.0.0.1:3306/biblio1";
		String user = "root";
		String pass = "";

		try {
			con = DriverManager.getConnection(conex, user, pass);
		} catch (SQLException e) {
			System.out.println("Error al establecer a conexion");
			System.out.println(e.getMessage());
			return null;
		}
		System.out.println("Se ha establecido la conexion");

		return con;
	}

	// ---------------------------------------------------------------------BBDD-CLOSE
	public static void cerrarConexion(Connection con) {

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar");
			System.out.println(e.getMessage());
		}
	}

}
