package com.curso.modelo.entidad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "peliculas")
public class Pelicula {

	@Id
	private Integer id;
	private String titulo;
	private Integer year;
	private String genero;
	@DBRef
	private Director director;

	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelicula(Integer id, String titulo, Integer year, String genero, Director director) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.year = year;
		this.genero = genero;
		this.director = director;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

}
