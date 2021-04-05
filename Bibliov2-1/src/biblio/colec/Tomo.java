package biblio.colec;

import biblio.obra.Libro;

public class Tomo extends Compilacion{
	
	//PROPIEDADES
	private int numero;
	private Libro libro;
	
	//CONSTRUCTOR
	public Tomo(int numero, Libro libro) {
		this.numero = numero;
		this.libro = libro;
	}
	//METODOS
	@Override
	public String detalle() {
		return " - "+this.numero;
	}
	@Override
	public String toString() {
		return "Tomo [numero=" + numero + ", libro=" + libro + "]";
	}
	//GETTER Y SETTER
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	

}
