package com.curso.controlador;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

//Un controlador de Spring MVC tiene que ser una java bean
@Controller
public class ControladorSaludos {

	public ControladorSaludos() {
		super();
		System.out.println("Creando ControladorSaludos");
	}

	
	@RequestMapping("/saludar")  //value="/saludar"
	public ModelAndView saludar(HttpServletRequest request){
		System.out.println("============================================");
		String nombre = request.getParameter("nombre");
		System.out.println("Saludando a "+nombre);

		String mensaje = "Hola "+nombre;
		
		ModelAndView mav = new ModelAndView("saludo");
		mav.addObject("saludo", mensaje);
		
		return mav;
	}	
	
}








