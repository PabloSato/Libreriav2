package biblio.ubi;

public abstract class Donde {

	// PROPIEDADES
	private String nombre;

	// CONSTRUCTOR
	public Donde(String nombre) {
		this.nombre = nombre;
	}

	// METODOS
	public abstract String detalle();

	public abstract String detalles();

	@Override
	public String toString() {
		return "Donde [nombre=" + nombre + "]";
	}

	// GETTER Y SETTER
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
