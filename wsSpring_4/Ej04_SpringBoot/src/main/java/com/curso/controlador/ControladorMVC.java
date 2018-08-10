package com.curso.controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMVC {

	@RequestMapping(value="verInicio")
	public ModelAndView verInicio(){

		//LC
		
		//paginas/inicio.jsp
		ModelAndView mav = new ModelAndView("inicio");
		mav.addObject("saludo", "Hola que tal");
	
		return mav;
	}
	
	@RequestMapping(value="insertarCliente")
	public ModelAndView insertar(){
		return null;
	}
	
	
}
