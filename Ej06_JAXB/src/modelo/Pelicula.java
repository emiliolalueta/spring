package modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pelicula {

	private int idPelicula;
	private String titulo;
	private String director;
	private int year;

	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelicula(int idPelicula, String titulo, String director, int year) {
		super();
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.director = director;
		this.year = year;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
