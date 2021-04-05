package biblio.obra;

public abstract class Obra {

	// PROPIEDADES
	private int id;
	private String titulo;
	private int paginas;
	private String genero;
	private String idioma;
	private boolean leido;

	// CONSTRUCTOR
	public Obra(int id, String titulo, int paginas, String genero, String idioma, boolean leido) {
		this.id = id;
		this.titulo = titulo;
		this.paginas = paginas;
		this.genero = genero;
		this.idioma = idioma;
		this.leido = leido;
	}

	public Obra() {
		this.id = 0;
		this.titulo = "";
		this.paginas = 0;
		this.genero = "";
		this.idioma = "";
		this.leido = false;
	}

	// METODOS
	public abstract String consulta();

	@Override
	public String toString() {
		return "Obra [id=" + id + ", titulo=" + titulo + ", paginas=" + paginas + ", genero=" + genero + ", idioma="
				+ idioma + ", leido=" + leido + "]";
	}

	// GETTER Y SETTER
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

}
