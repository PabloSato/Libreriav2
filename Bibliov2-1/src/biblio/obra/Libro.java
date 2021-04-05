package biblio.obra;

import java.util.ArrayList;

import biblio.autor.Autor;
import biblio.colec.Coleccion;
import biblio.colec.Saga;
import biblio.ubi.Balda;
import biblio.ubi.Estanteria;
import biblio.ubi.Ubicacion;

public class Libro extends Obra {

	// PROPIEDADES
	private int id;
	private ArrayList<Autor> autores;
	private Coleccion coleccion;
	private Saga saga;
	private Ubicacion ubicacion;
	private Estanteria estanteria;
	private Balda balda;

	// CONSTRUCTOR
	public Libro(int id, String titulo, int paginas, String genero, String idioma, boolean leido,
			ArrayList<Autor> autores, Coleccion coleccion, Saga saga, Ubicacion ubicacion, Estanteria estanteria,
			Balda balda) {
		super(id, titulo, paginas, genero, idioma, leido);
		this.autores = autores;
		this.coleccion = coleccion;
		this.saga = saga;
		this.ubicacion = ubicacion;
		this.estanteria = estanteria;
		this.balda = balda;
	}

	// METODOS
	@Override
	public String consulta() {
		return super.getTitulo();
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autores=" + autores + ", coleccion=" + coleccion + ", saga=" + saga
				+ ", ubicacion=" + ubicacion + ", estanteria=" + estanteria + ", balda=" + balda + "]";
	}

	// GETTER Y SETTER
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	public Coleccion getColeccion() {
		return coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}

	public Saga getSaga() {
		return saga;
	}

	public void setSaga(Saga saga) {
		this.saga = saga;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Estanteria getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(Estanteria estanteria) {
		this.estanteria = estanteria;
	}

	public Balda getBalda() {
		return balda;
	}

	public void setBalda(Balda balda) {
		this.balda = balda;
	}

}
