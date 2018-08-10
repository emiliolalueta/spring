package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

public interface GestorClientes {

	public abstract void insertar(Cliente cliente);

	public abstract void borrar(Cliente cliente);

}