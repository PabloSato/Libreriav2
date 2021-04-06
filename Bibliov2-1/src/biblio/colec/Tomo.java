package biblio.colec;

public class Tomo extends Compilacion {

	// PROPIEDADES
	private int numero;

	// CONSTRUCTOR
	public Tomo(int numero) {
		this.numero = numero;
	}

	// METODOS
	@Override
	public String detalle() {
		return " - " + this.numero;
	}

	@Override
	public String toString() {
		return "Tomo [numero=" + numero + "]";
	}

	// GETTER Y SETTER
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
