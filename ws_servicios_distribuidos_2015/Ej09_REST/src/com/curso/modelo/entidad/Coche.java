package com.curso.modelo.entidad;

import java.io.Serializable;

public class Coche implements Serializable {

	private String marca;
	private String modelo;
	private String matricula;

	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coche(String marca, String modelo, String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", matricula="
				+ matricula + "]";
	}
	
	

}
