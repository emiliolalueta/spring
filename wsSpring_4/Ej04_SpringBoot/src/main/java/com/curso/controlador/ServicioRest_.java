package com.curso.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/movidas")
public class ServicioRest_ {

	@RequestMapping("/saludo")
	public String saludo(){
		return "Hola";
	}
	
	@RequestMapping(method=RequestMethod.POST, 
	        		consumes="application/json")
	public void insertar(@RequestBody DTO dto){
		System.out.println("Servicio. Insertar:"+dto);
	}	

	@RequestMapping
	public List<DTO> listar(){
		List<DTO> lista = new ArrayList<DTO>();
		lista.add(new DTO(1,"N1"));
		lista.add(new DTO(2,"N2"));
		lista.add(new DTO(3,"N3"));
		lista.add(new DTO(4,"N4"));
		return lista;		
	}
	
}
