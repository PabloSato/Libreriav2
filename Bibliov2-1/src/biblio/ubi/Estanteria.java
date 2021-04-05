package biblio.ubi;

import java.util.ArrayList;

import biblio.ubi.Balda;

public class Estanteria extends Donde {

	// PROPIEDADES
	private ArrayList<Balda> baldas;

	// CONSTRUCTOR
	public Estanteria(String nombre) {
		super(nombre);
		this.baldas = new ArrayList<Balda>();
	}

	// METODOS
	@Override
	public String detalle() {
		return super.getNombre();
	}

	@Override
	public String detalles() {
		return "";// desarrollar
	}

	@Override
	public String toString() {
		return "Estanteria [baldas=" + baldas + "]";
	}


	// GETTER Y SETTER
	public ArrayList<Balda> getBaldas() {
		return baldas;
	}

	public void setBaldas(ArrayList<Balda> baldas) {
		this.baldas = baldas;
	}

}
