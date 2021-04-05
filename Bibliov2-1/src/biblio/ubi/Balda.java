package biblio.ubi;

import java.util.ArrayList;

import biblio.obra.Libro;

public class Balda extends Donde{
	
	//PROPIEDADES
	private int numero;
	private ArrayList<Libro>libros;
	
	//CONSTRUCTOR
	public Balda(int numero) {
		super();
		this.numero = numero;
		this.libros = new ArrayList<Libro>();
	}
	//METODOS
	@Override
	public String detalle() {
		return " - "+this.numero;
	}
	@Override
	public String detalles() {
		return "";//desarrollar
	}
	
	
	@Override
	public String toString() {
		return "Balda [numero=" + numero + ", libros=" + libros + "]";
	}
	//GETTER Y SETTER
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	
	
}
