package com.curso.cfg;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

public class Applicacion {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);

		GestorClientes gc = (GestorClientes) appCtx.getBean("gestorClientes");
		
		List<Cliente> clientes = gc.listarTodos();
		for(Cliente c: clientes){
			System.out.println(c.getNombre());
		}	
		
	}
	
}
