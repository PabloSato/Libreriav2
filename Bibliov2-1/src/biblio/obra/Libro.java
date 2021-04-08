package biblio.obra;

import java.util.ArrayList;

import biblio.autor.Autor;
import biblio.colec.Coleccion;
import biblio.colec.Saga;
import biblio.colec.Tomo;
import biblio.ubi.Balda;
import biblio.ubi.Estanteria;
import biblio.ubi.Ubicacion;

public class Libro extends Obra {

	// PROPIEDADES
	private int id;
	private ArrayList<Autor> autores;
	private Coleccion coleccion;
	private Saga saga;
	private Tomo tomoCol;
	private Tomo tomoSag;
	private Ubicacion ubicacion;
	private Estanteria estanteria;
	private Balda balda;

	// CONSTRUCTOR
	public Libro(int id, String titulo, int paginas, String genero, String idioma, boolean leido,
			ArrayList<Autor> autores, Coleccion coleccion, Saga saga, Tomo tomoCol, Tomo tomoSag, Ubicacion ubicacion,
			Estanteria estanteria, Balda balda) {
		super(id, titulo, paginas, genero, idioma, leido);
		this.autores = autores;
		this.coleccion = coleccion;
		this.saga = saga;
		this.tomoCol = tomoCol;
		this.tomoSag = tomoSag;
		this.ubicacion = ubicacion;
		this.estanteria = estanteria;
		this.balda = balda;
	}
	public Libro(int id, String titulo, int paginas, String genero, String idioma, boolean leido, Coleccion coleccion, Saga saga, Tomo tomoCol, Tomo tomoSag, Ubicacion ubicacion,
			Estanteria estanteria, Balda balda) {
		super(id, titulo, paginas, genero, idioma, leido);
		this.coleccion = coleccion;
		this.saga = saga;
		this.tomoCol = tomoCol;
		this.tomoSag = tomoSag;
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
		return "Libro [id=" + this.id + ", autores=" + this.autores + ", coleccion=" + this.coleccion + ", saga="
				+ this.saga + ", tomoCol=" + this.tomoCol + ", tomoSag=" + this.tomoSag + ", ubicacion="
				+ this.ubicacion + ", estanteria=" + this.estanteria + ", balda=" + this.balda + "]";
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

	public Tomo getTomoCol() {
		return tomoCol;
	}

	public void setTomoCol(Tomo tomoCol) {
		this.tomoCol = tomoCol;
	}

	public Tomo getTomoSag() {
		return tomoSag;
	}

	public void setTomoSag(Tomo tomoSag) {
		this.tomoSag = tomoSag;
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
