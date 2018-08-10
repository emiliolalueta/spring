package com.curso;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;

@Component
public class InicializadorBBDD {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void inicializar(){
		
		Cliente c1 = new Cliente(null, "Tio Gilito","C/Tal","555",9999);
		Cliente c2 = new Cliente(null, "Harpo Marx","C/Tal","555",1);
		em.persist(c1);
		em.persist(c2);
		
		Producto pr1 = new Producto(null, "P1", "F1", 25d , 1000);
		Producto pr2 = new Producto(null, "P2", "F2", 50d , 1000);
		Producto pr3 = new Producto(null, "P3", "F3", 75d , 1000);
		Producto pr4 = new Producto(null, "P4", "F4", 100d, 1000);
		Producto pr5 = new Producto(null, "P5", "F5", 125d, 1000);
		em.persist(pr1);
		em.persist(pr2);
		em.persist(pr3);
		em.persist(pr4);
		em.persist(pr5);
		
		Pedido p1 = new Pedido(null, "PED-0", new Date(), "Pendiente", c1);
		Pedido p2 = new Pedido(null, "PED-1", new Date(), "Pendiente", c2);
		em.persist(p1);
		em.persist(p2);
		
		DetallePedido dp1 = new DetallePedido(null, 25d, 25, p1, pr1);
		DetallePedido dp2 = new DetallePedido(null, 25d, 25, p1, pr3);
		DetallePedido dp3 = new DetallePedido(null, 25d, 25, p1, pr5);
		em.persist(dp1);
		em.persist(dp2);
		em.persist(dp3);

		DetallePedido dp4 = new DetallePedido(null, 50d, 50, p2, pr2);
		DetallePedido dp5 = new DetallePedido(null, 50d, 50, p2, pr4);
		em.persist(dp4);
		em.persist(dp5);			
		
	}
	
}
