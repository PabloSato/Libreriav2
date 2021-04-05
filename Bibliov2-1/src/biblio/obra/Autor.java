package biblio.obra;

import java.util.ArrayList;

public abstract class Autor {

	// PROPIEDADES
	private String nombre;
	private String apellidos;
	private String alias;
	private String bio;
	private ArrayList<Libro> libros;

	// CONSTRUCTOR
	public Autor(String nombre, String apellidos, String alias, String bio) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.alias = alias;
		this.bio = bio;
		this.libros = new ArrayList<Libro>();

	}

	public Autor() {
		this.nombre = "-";
		this.apellidos = "-";
		this.alias = "VVAA";
		this.bio = "";
		this.libros = new ArrayList<Libro>();
	}
	//METODOS
	public abstract String consulta();
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellidos=" + apellidos + ", alias=" + alias + ", bio=" + bio
				+ ", libros=" + libros + "]";
	}

	// GETTER Y SETTER
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

}
