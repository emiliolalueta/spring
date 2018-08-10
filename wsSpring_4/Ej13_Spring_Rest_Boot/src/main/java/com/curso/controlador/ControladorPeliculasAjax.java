package com.curso.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculas;

@Controller  
public class ControladorPeliculasAjax {

	@RequestMapping("/mostrarPeliculasAjax")
	public ModelAndView mostrarListado(){
		ModelAndView mav = new ModelAndView("peliculasAjax");
		return mav;
	}
	
}







