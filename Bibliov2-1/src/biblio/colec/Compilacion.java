package biblio.colec;

public abstract class Compilacion {
	
	//PROPIEDADES
	private String nombre;
	
	//CONSTRUCTOR
	public Compilacion(String nombre) {
		this.nombre = nombre;
	}
	//METODOS
	public abstract String detalle();
	@Override
	public String toString() {
		return "Compilacion [nombre=" + nombre + "]";
	}
	//GETTER Y SETTER
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
