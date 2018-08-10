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
public class ControladorPeliculas {

	@Autowired
	private GestorPeliculas gestorPeliculas;
	
	public ControladorPeliculas() {
		super();
		System.out.println("Creando ControladorPeliculas");
	}

	@RequestMapping("/mostrarListadoPeliculas")
	public ModelAndView mostrarListado(){
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		List<Pelicula> peliculas = gestorPeliculas.listar();
		mav.addObject("listaPeliculas", peliculas);
		return mav;
	}
	
	@RequestMapping("/nuevaPelicula")
	public ModelAndView nuevo(){
		
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		Pelicula pelicula = new Pelicula();
		mav.addObject("pelicula", pelicula);
		return mav;
	}
	
	@RequestMapping("/seleccionarPelicula")
	public ModelAndView 
				seleccionar(@RequestParam(value="id") Integer id){

		System.out.println("ID:"+id);
		//System.out.println("Pelicula:"+pelicula);
		
		Pelicula pSel = gestorPeliculas.buscar(id);
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula", pSel);
		
		return mav;
	}
	
	@RequestMapping(value="/insertarPelicula")
	public ModelAndView insertar(@ModelAttribute(value="pelicula") Pelicula pelicula){
		System.out.println("Insertar:"+pelicula);
		gestorPeliculas.insertar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:mostrarListadoPeliculas.htm");
		return mav;
	}

	@RequestMapping("/modificarPelicula")
	public ModelAndView modificar(@ModelAttribute("pelicula") Pelicula pelicula){
		gestorPeliculas.modificar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:mostrarListadoPeliculas.htm");
		return mav;
	}

	@RequestMapping("/borrarPelicula")
	public ModelAndView borrar(@ModelAttribute("pelicula") Pelicula pelicula){
		gestorPeliculas.borrar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:mostrarListadoPeliculas.htm");
		return mav;
	}
	
	//Esto es una mierda que se invoca SIEMPRE
	//para dejar en el ModelAndView el objeto que devuelva el método
	//@ModelAttribute(value="listaPeliculas")
	public List<Pelicula> getListaPeliculas(){
		System.out.println("LISTANDO LAS PELICULAS");
		return gestorPeliculas.listar();
	}
	
}







