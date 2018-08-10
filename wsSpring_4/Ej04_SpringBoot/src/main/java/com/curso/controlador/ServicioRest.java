package com.curso.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")
public class ServicioRest {

	@RequestMapping("/saludo")
	public String saludar(){
		return "Bo que pacha";
	}
		
}
