package com.curso.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.persistencia.ClienteDao;

public class Applicacion {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		GestorClientes gc = appCtx.getBean(GestorClientes.class);
		
		ClienteDao cDao = appCtx.getBean(ClienteDao.class);
		
		//cDao.save(new Cliente(null,"N10","Salamanca","923"));
		/*for(Cliente c: cDao.findByMovida("Salamanca")){
			System.out.println(c.getNombre());
		}*/		
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(null,"N11","D11","T11"));
		clientes.add(new Cliente(null,"N22","D22","T22"));
		clientes.add(new Cliente(null,"N33","D33","T33"));
		clientes.add(new Cliente(null,"N44","D44","T44"));
		clientes.add(new Cliente(null,"N55","D55",null));
		
		gc.insertar(clientes);
		
		for(Cliente c: cDao.findAll()){
		System.out.println(c.getNombre());
		}		
		
		
	}
	
}
