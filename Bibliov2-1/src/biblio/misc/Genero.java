package biblio.misc;

import java.util.ArrayList;

import biblio.obra.Libro;

public class Genero {
	
	private String genero;
	private ArrayList<Libro> libros;
	
	public Genero(String genero) {
		this.genero = genero;
		this.libros = new ArrayList<Libro>();
	}

	@Override
	public String toString() {
		return "Genero [genero=" + this.genero + ", libros=" + this.libros + "]";
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	

}
