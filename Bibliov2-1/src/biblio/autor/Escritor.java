package biblio.autor;

import java.util.ArrayList;

import biblio.obra.Libro;

public class Escritor extends Autor {

	// PROPIEDADES
	private boolean escritor;
	private ArrayList<Libro> libros;

	// CONSTRUCTOR
	public Escritor(String nombre, String apellidos, String alias, String bio, boolean escritor) {
		super(nombre, apellidos, alias, bio);
		this.escritor = escritor;
		this.libros = new ArrayList<Libro>();
	}

	// METODOS
	@Override
	public String consulta() {
		return super.getAlias();
	}

	@Override
	public String toString() {
		return "Escritor [libros=" + libros + "]";
	}

	// GETTER Y SETTER

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public boolean isEscritor() {
		return escritor;
	}

	public void setEscritor(boolean escritor) {
		this.escritor = escritor;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
}
