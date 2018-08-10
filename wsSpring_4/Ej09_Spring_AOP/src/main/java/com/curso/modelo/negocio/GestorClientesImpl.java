package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

public class GestorClientesImpl implements GestorClientes {

	@Override
	public void insertar(Cliente cliente){
		
		System.out.println("Insertando en GestorClientes:"+cliente);
	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public void borrar(Cliente cliente){
		System.out.println("Borrando en GestorClientes:"+cliente);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
	}

	
}
