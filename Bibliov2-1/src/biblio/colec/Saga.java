package biblio.colec;

import java.util.ArrayList;

public class Saga extends Compilacion {

	// PROPIEDADES
	private ArrayList<Tomo> tomos;

	// CONSTRUCTOR
	public Saga(String nombre) {
		super(nombre);
		this.tomos = new ArrayList<Tomo>();
	}

	public Saga() {
		super();
	}
	// METODOS

	@Override
	public String detalle() {
		return super.getNombre() + " ";
	}

	@Override
	public String toString() {
		return "Saga [tomos=" + tomos + "]";
	}

	// GETTER Y SETTER
	public ArrayList<Tomo> getTomos() {
		return tomos;
	}

	public void setTomos(ArrayList<Tomo> tomos) {
		this.tomos = tomos;
	}

}
