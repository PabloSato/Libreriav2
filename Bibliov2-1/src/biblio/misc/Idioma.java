package biblio.misc;

import java.util.ArrayList;

import biblio.obra.Libro;

public class Idioma {
	
	private String idioma;
	private ArrayList<Libro> libros;
	
	public Idioma(String idioma) {
		this.idioma = idioma;
		this.libros = new ArrayList<Libro>();
	}

	@Override
	public String toString() {
		return "Idioma [idioma=" + this.idioma + ", libros=" + this.libros + "]";
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	

}
