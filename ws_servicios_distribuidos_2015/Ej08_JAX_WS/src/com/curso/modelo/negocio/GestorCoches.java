package com.curso.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Coche;

@Service
public class GestorCoches {

	private static List<Coche> coches;
	
	static {
		coches = new ArrayList<Coche>();
		coches.add(new Coche("Marca1", "Modelo1", "Matricula1"));
		coches.add(new Coche("Marca2", "Modelo2", "Matricula2"));
		coches.add(new Coche("Marca3", "Modelo3", "Matricula3"));
		coches.add(new Coche("Marca4", "Modelo4", "Matricula4"));
		coches.add(new Coche("Marca5", "Modelo5", "Matricula5"));
	}	
	
	public void insertar(Coche coche) {
		coches.add(coche);
	}

	public List<Coche> listarTodos() {		
		return coches;
	}	
	
}
