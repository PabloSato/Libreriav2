package biblio.autor;

import java.util.ArrayList;

import biblio.obra.Libro;

public class Dibujante extends Autor {

	// PROPIEDADES
	private boolean dibujante;
	private ArrayList<Libro> libros;

	// CONSTRUCTOR
	public Dibujante(String nombre, String apellidos, String alias, String bio, boolean dibujante) {
		super(nombre, apellidos, alias, bio);
		this.dibujante = dibujante;
		this.libros = new ArrayList<Libro>();
	}

	// METODOS
	@Override
	public String consulta() {
		return super.getAlias();
	}

	@Override
	public String toString() {
		return "Dibujante [dibujante=" + dibujante + ", libros=" + libros + "]";
	}

	public boolean isDibujante() {
		return dibujante;
	}

	// GETTER Y SETTER
	public void setDibujante(boolean dibujante) {
		this.dibujante = dibujante;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

}
