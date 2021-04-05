package biblio.autor;

import java.util.ArrayList;

public class Autor {

	// PROPIEDADES
	private String nombre;
	private String apellidos;
	private String alias;
	private String bio;

	// CONSTRUCTOR
	public Autor(String nombre, String apellidos, String alias, String bio) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.alias = alias;
		this.bio = bio;

	}

	public Autor() {
		this.nombre = "-";
		this.apellidos = "-";
		this.alias = "VVAA";
		this.bio = "";
	}
	//METODOS
	public String consulta() {
		return this.alias;
	};
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellidos=" + apellidos + ", alias=" + alias + ", bio=" + bio+"]";
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


}
