package com.curso.modelo.persistencia;

import java.util.List;

public interface InterfaceDAO<T, K> {

	public abstract void insertar(T obj);
	public abstract void modificar(T obj);
	public abstract void borrar(T obj);
	public abstract T buscar(K id);
	public abstract List<T> listarTodos();

}