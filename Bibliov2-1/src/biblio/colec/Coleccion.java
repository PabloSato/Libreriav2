package biblio.colec;

import java.util.ArrayList;

public class Coleccion extends Compilacion{
	
	//PROPIEDADES
	private ArrayList<Saga> sagas;
	private ArrayList<Tomo> tomos;
	
	//CONSTRUCTOR
	public Coleccion(String nombre) {
		super(nombre);
		this.sagas = new ArrayList<Saga>();
		this.tomos = new ArrayList<Tomo>();
	}
	public Coleccion() {
		super();
	}
	//METODOS
	@Override
	public String detalle() {
		return super.getNombre()+" ";
	}
	@Override
	public String toString() {
		return "Coleccion [sagas=" + sagas + ", tomos=" + tomos + "]";
	}
	//GETTER Y SETTER
	public ArrayList<Saga> getSagas() {
		return sagas;
	}
	
	public void setSagas(ArrayList<Saga> sagas) {
		this.sagas = sagas;
	}

	public ArrayList<Tomo> getTomos() {
		return tomos;
	}

	public void setTomos(ArrayList<Tomo> tomos) {
		this.tomos = tomos;
	}
	
	

}
