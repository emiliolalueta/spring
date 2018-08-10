package com.curso.modelo.negocio;

public class ClaseGenerica<T> {

	private Object[] elementos = new Object[20];
	private int posicion;
	
	public T getObjeto(int pos){
		return (T) elementos[pos];
	}
	
	public void add(T elemento){
		elementos[posicion] = elemento;
		posicion++;
	}
	
}
