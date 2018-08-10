package com.curso.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorClientes {

	
	
    @RequestMapping(value = "/verListado", method = RequestMethod.GET)
    public ModelAndView verInicio() {
        
    	System.out.println("HOLA");
    	ModelAndView mav = new ModelAndView("listadoClientes");
        String str = "TNT";
        mav.addObject("texto", str); 
        return mav;
    }	
	
}
