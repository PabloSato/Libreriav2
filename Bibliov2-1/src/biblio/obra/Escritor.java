package biblio.obra;

import java.util.ArrayList;

public class Escritor extends Autor {

	// PROPIEDADES

	private ArrayList<Libro> libros;

	// CONSTRUCTOR
	public Escritor(String nombre, String apellidos, String alias, String bio) {
		super(nombre, apellidos, alias, bio);
		this.libros = new ArrayList<Libro>();
	}
	
	//METODOS
	@Override
	public String consulta() {
		return super.getAlias();
	}
	
	
	@Override
	public String toString() {
		return "Escritor [libros=" + libros + "]";
	}

	//GETTER Y SETTER
	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
}
