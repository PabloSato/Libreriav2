package biblio.ubi;

import java.util.ArrayList;

public class Ubicacion extends Donde{
	
	//PROPIEDADES
	private ArrayList<Estanteria> estanterias;
	
	//CONSTRUCTOR
	public Ubicacion(String nombre) {
		super(nombre);
		this.estanterias = new ArrayList<Estanteria>();
	}
	//METODOS
	@Override
	public String detalle() {
		return super.getNombre();
	}
	@Override
	public String detalles() {
		return ""; //desarrollar
	}
	@Override
	public String toString() {
		return "Ubicacion [estanterias=" + estanterias + "]";
	}
	//GETTER Y SETTER
	public ArrayList<Estanteria> getEstanterias() {
		return estanterias;
	}

	public void setEstanterias(ArrayList<Estanteria> estanterias) {
		this.estanterias = estanterias;
	}
	
	

}
