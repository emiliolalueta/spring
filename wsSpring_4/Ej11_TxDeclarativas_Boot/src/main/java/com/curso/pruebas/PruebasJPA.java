package com.curso.pruebas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Pedido;

@Component
public class PruebasJPA {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public void insertar(){
		
		Cliente c = new Cliente(null, "Harpo Marx","C/Tal","555",1);
		
		Pedido p1 = new Pedido(null, "PED-0", new Date(), "Pendiente", c);
		Pedido p2 = new Pedido(null, "PED-1", new Date(), "Pendiente", c);
		Pedido p3 = new Pedido(null, "PED-2", new Date(), "Pendiente", c);
		Pedido p4 = new Pedido(null, "PED-3", new Date(), "Pendiente", c);
		Pedido p5 = new Pedido(null, "PED-4", new Date(), "Pendiente", c);
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		pedidos.add(p4);
		pedidos.add(p5);
		
		c.setPedidos(pedidos);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
		/*
		//Esto funciona sin necesidad de cascade:
		em.persist(c);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);	
		*/			
		
		em.persist(c);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void cargasPerezosas(){
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
		
		Cliente c = em.find(Cliente.class, 2);
		System.out.println(c.getNombre());
		
		em.getTransaction().commit();
		em.close();
		
		for(Pedido p: c.getPedidos()){
			System.out.println(p.getCodigo());
		}
		
		
	}
	
}






















