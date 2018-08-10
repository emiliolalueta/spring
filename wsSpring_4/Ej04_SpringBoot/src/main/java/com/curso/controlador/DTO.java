package com.curso.controlador;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DTO {

	private int id;
	private String nombre;

	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "DTO [id=" + id + ", nombre=" + nombre + "]";
	}

	
	
}
