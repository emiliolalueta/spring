package com.curso.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculas;
import com.curso.servicio.dto.PeliculaDTO;

@RestController
//Singleton
//SIN ESTADO
public class ServicioPeliculas {

	@Autowired
	private GestorPeliculas gestorPeliculas;	

	@RequestMapping(value="peliculas", 
					method=RequestMethod.POST, 
					consumes="application/json")
	public void insertarJSON(@RequestBody PeliculaDTO peliculaDTO){
		System.out.println("ServicioPeliculas. Insertar:"+peliculaDTO);
		Pelicula pelicula = peliculaDTO.asPelicula();		
		gestorPeliculas.insertar(pelicula);
	}
	
	@RequestMapping(value="peliculas", method=RequestMethod.PUT)
	public void modificar(@RequestBody PeliculaDTO peliculaDTO){
		System.out.println("ServicioPeliculas. Modificar:"+peliculaDTO);
		//gestorPeliculas.insertar(pelicula);
	}
	
	@RequestMapping(value="peliculas/{idPelicula}", 
				    method=RequestMethod.DELETE)
	public void borrar(@PathVariable("idPelicula") Integer idPelicula){
		System.out.println("ServicioPeliculas. Borrar:"+idPelicula);
		//gestorPeliculas.insertar(pelicula);
	}
	
	@RequestMapping(value="peliculas/{idPelicula}", 
			        method=RequestMethod.GET)
	public PeliculaDTO buscar(@PathVariable("idPelicula") Integer idPelicula){
		System.out.println("ServicioPeliculas. Buscar:"+idPelicula);
		Pelicula pelicula = gestorPeliculas.buscar(idPelicula);
		return new PeliculaDTO(pelicula);
	}
	
	@RequestMapping(value="peliculas", 
			        method=RequestMethod.GET, 
			        produces="application/json")
	public List<PeliculaDTO> listar(){
		System.out.println("LISTAR");
		List<Pelicula> peliculas = gestorPeliculas.listar();
		List<PeliculaDTO> peliculasDTO = new ArrayList<PeliculaDTO>();
		for(Pelicula p: peliculas){
			peliculasDTO.add(new PeliculaDTO(p));
		}		
		return peliculasDTO;
	}	
	
}





