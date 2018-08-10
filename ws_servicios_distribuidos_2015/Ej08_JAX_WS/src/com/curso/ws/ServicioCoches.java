package com.curso.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Coche;
import com.curso.modelo.negocio.GestorCoches;

@Component
@WebService(serviceName = "ServicioCoches", 
            portName = "ServicioCochesPort")
public class ServicioCoches {

	@Autowired
	private GestorCoches gestorCoches;

	public void setGestorCoches(GestorCoches gestorCoches) {
		this.gestorCoches = gestorCoches;
	}

	@WebMethod
	//Aqui deberíamos recibir un DTO
	public void insertar(Coche coche) {
		System.out.println("INSERTAR");
		//Transformar de CocheDTO a Coche
		gestorCoches.insertar(coche);
	}

	@WebMethod
	public List<Coche> listarTodos() {
		return gestorCoches.listarTodos();
	}

}
