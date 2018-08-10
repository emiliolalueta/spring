package com.curso.modelo.persistencia;

public class ClienteDaoXML implements ClienteDao {

	@Override
	public void insertar(String cliente){
		System.out.println("Insertando "+cliente+" en ClienteDaoXML");
	}
	
}
