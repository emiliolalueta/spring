package com.curso.eventos;

public class Evento {

	private String dato1;
	private int dato2;

	public Evento(String dato1, int dato2) {
		super();
		this.dato1 = dato1;
		this.dato2 = dato2;
	}

	public Evento() {
		super();
	}

	public String getDato1() {
		return dato1;
	}

	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	public int getDato2() {
		return dato2;
	}

	public void setDato2(int dato2) {
		this.dato2 = dato2;
	}

	@Override
	public String toString() {
		return "Evento [dato1=" + dato1 + ", dato2=" + dato2 + "]";
	}

}
