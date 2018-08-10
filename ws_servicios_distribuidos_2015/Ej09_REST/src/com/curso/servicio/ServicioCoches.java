package com.curso.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.modelo.entidad.Coche;

@Controller
public class ServicioCoches {

	public static List<Coche> coches;
	
	static {
		coches = new ArrayList<Coche>();
		coches.add(new Coche("Marca1","Modelo1","Matricula1"));
		coches.add(new Coche("Marca2","Modelo2","Matricula2"));
		coches.add(new Coche("Marca3","Modelo3","Matricula3"));
		coches.add(new Coche("Marca4","Modelo4","Matricula4"));
		coches.add(new Coche("Marca5","Modelo5","Matricula5"));		
	}	
	
	public ServicioCoches() {
		super();
		System.out.println("============================================");
		System.out.println("Movidas gordísimas");
	}
	
	@RequestMapping(value="/coches",
			        method = RequestMethod.GET,
			        headers="Accept=application/json")	
	@ResponseBody
	public List<Coche> listarTodos(){
		System.out.println("LISTAR");
		return coches;
	}

	@RequestMapping(value = "coches/{idCoche}", 
					method = RequestMethod.GET)
    @ResponseBody
    public Coche buscar(@PathVariable(value = "idCoche") long userId) {
        return new Coche("111","222","333");
    }
	
	@RequestMapping(value = "coches", 
					method = RequestMethod.POST)
    @ResponseBody
    public void create(@RequestBody Coche coche) {
		coches.add(coche);
    }
 		
}
