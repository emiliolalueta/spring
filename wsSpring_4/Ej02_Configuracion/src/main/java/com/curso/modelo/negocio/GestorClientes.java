package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.curso.modelo.persistencia.ClienteDao;

@Service
public class GestorClientes {

	@Autowired
	//@Lazy
	private ClienteDao clienteDao;
	
	@Autowired
	private ClaseGenerica<String> claseGenerica1;
	@Autowired
	private ClaseGenerica<Integer> claseGenerica2;
	
	public void insertar(String cliente){
		clienteDao.insertar(cliente);
		claseGenerica1.add("HOLA");
		claseGenerica2.add(42);
	}	
	
}
