package biblio.autor;

import java.util.ArrayList;

import biblio.obra.Libro;

public class Dibujante extends Autor {

	// PROPIEDADES
	private ArrayList<Libro> libros;

	// CONSTRUCTOR
	public Dibujante(String nombre, String apellidos, String alias, String bio) {
		super(nombre, apellidos, alias, bio);
		this.libros = new ArrayList<Libro>();
	}

	// METODOS
	@Override
	public String consulta() {
		return super.getAlias();
	}

	@Override
	public String toString() {
		return "Dibujante [libros=" + libros + "]";
	}


	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

}
