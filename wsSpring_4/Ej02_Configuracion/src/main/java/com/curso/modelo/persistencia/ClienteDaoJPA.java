package com.curso.modelo.persistencia;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoJPA implements ClienteDao {
	
	public ClienteDaoJPA() {
		super();
		System.out.println("CREANDO ClienteDaoJPA");
	}

	@Override
	public void insertar(String cliente){
		System.out.println("Insertando "+cliente+" en ClienteDaoJPA");
	}
	
}
