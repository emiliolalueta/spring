package com.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Cliente;

@Component
public class PruebasEntityManager {

	@Autowired
	private EntityManagerFactory emf;
	
	public void pruebas(){
	
		EntityManager em = null;

		//INSERT
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Cliente c1 = new Cliente(null,"Bart","C/Evergreen Terrace","555",500);;
		//em.persist(c1);
		System.out.println(c1.getId());
		
		em.getTransaction().commit();
		em.close();
		
		//UPDATE CON TODOS LOS CAMPOS
		System.out.println("==========================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Cliente c2 = new Cliente();
		//c2.setId(33);
		//c2.setTelefono("666");
		//em.merge(c2);
		Cliente c2 = new Cliente(878,"Hubert J Farnsworth","C/Evergreen Terrace","666",500);;
		em.merge(c2);		
		
		em.getTransaction().commit();
		em.close();
		
		//UPDATE CUANDO NO TENEMOS TODOS LOS CAMPOS
		System.out.println("==========================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		int id=33;
		String telefono = "666 666";
		
		Cliente c3 = em.find(Cliente.class, id);
		c3.setTelefono(telefono);

		//em.merge(c3);
		
		em.getTransaction().commit();
		em.close();
		
		//CACHÉ DE PRIMER NIVEL
		System.out.println("==========================================");
		em = emf.createEntityManager();

		Cliente c4a = em.find(Cliente.class, 33);
		Cliente c4b = em.find(Cliente.class, 33);
		Cliente c4c = em.find(Cliente.class, 33);
		
		c4a.setNombre("Ringo");
		System.out.println(c4c.getNombre());
		
		em.close();		
		
		//BORRAR
		System.out.println("==========================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Esto es fetén
		//Cliente c5 = em.find(Cliente.class, 33);
		//em.remove(c5);
		
		
		Cliente c5 = new Cliente();
		c5.setId(33);
		
		em.merge(c5);
		em.remove(c5);		
		
		em.getTransaction().commit();
		em.close();
		
	
	}
	
}
