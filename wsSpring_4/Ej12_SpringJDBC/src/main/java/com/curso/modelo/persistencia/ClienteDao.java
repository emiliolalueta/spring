package com.curso.modelo.persistencia;

import java.util.List;

import com.curso.modelo.entidad.Cliente;

public interface ClienteDao {

	public abstract void insertar(Cliente cliente);

	public abstract void modificar(Cliente cliente);

	public abstract void borrar(Cliente cliente);

	public abstract Cliente buscar(int idCliente);

	public abstract List<Cliente> listarTodos();

}