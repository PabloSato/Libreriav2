package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import biblio.bbdd.MetodosAdd;
import biblio.bbdd.MetodosCheck;
import biblio.bbdd.MetodosDelete;
import biblio.bbdd.MetodosVer;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static Menu menu = new Menu();
	private static MetodosAdd add = new MetodosAdd();
	private static MetodosCheck check = new MetodosCheck();
	private static MetodosDelete del = new MetodosDelete();
	private static MetodosVer ver = new MetodosVer();

	public static void main(String[] args) {

		Connection con = abrirConexionBD();

		char opc = 0;
		char opc1 = 0;

		do {
			opc = menu.mostrarMenu();
			switch (opc) {
			case '1':
				opc1 = menu.menuLibros();
				switch(opc1) {
				case '1':
					ver.verLibro(con);
					break;
				case '2':
					add.addLibro(con);
					break;
				case '3':
					check.checkBook(con);
					break;
				case '4':
					del.delBook(con);
					break;
				case '0':
					menu.mostrarMenu();
					default:
						System.out.println("Introduce numeros de 1 al 4 o 0 para volver");
				}
				break;
			case '2':

				opc1 = menu.menuAutores();
				switch(opc1) {
				case '1':
						ver.verAut(con);
					break;
				case '2':
					add.addAutor(con);
					break;
				case '3':
					check.checkAut(con);
					break;
				case '4':
					del.delAut(con);
					break;
				case '0':
					menu.mostrarMenu();
					default:
						System.out.println("Introduce numeros de 1 al 4 o 0 para volver");
				}
				break;
			case '3':

				opc1 = menu.menuLibros();
				switch(opc1) {
				case '1':
					break;
				case '2':
					break;
				case '3':
					break;
				case '4':
					break;
				case '0':
					menu.mostrarMenu();
					default:
						System.out.println("Introduce numeros de 1 al 4 o 0 para volver");
				}
				break;
			case '4':

				opc1 = menu.menuLibros();
				switch(opc1) {
				case '1':
					break;
				case '2':
					break;
				case '3':
					break;
				case '4':
					break;
				case '0':
					menu.mostrarMenu();
					default:
						System.out.println("Introduce numeros de 1 al 4 o 0 para volver");
				}
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
		String conex = "jdbc:mysql://127.0.0.1:3306/biblio2";
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
