package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteDao;

@Service
public class GestorClientes {

	@Autowired
	private ClienteDao clienteDao;
	
	public void insertar(Cliente cliente){
		clienteDao.save(cliente);
	}
	
	public List<Cliente> listarTodos(){
		return clienteDao.findAll();
	}
	
}
