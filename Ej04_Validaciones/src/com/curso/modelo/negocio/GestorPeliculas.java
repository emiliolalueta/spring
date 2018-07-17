package com.curso.modelo.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.persistencia.PeliculaDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class GestorPeliculas {

	@Autowired
	private PeliculaDAO peliculaDAO;

	public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}

	public void insertar(Pelicula pelicula){
		peliculaDAO.insertar(pelicula);
	}
	
	public List<Pelicula> listar(){
		return peliculaDAO.listarTodos();
	}
	
	public Pelicula buscar(Integer id){
		return peliculaDAO.buscar(id);		
	}

	public void modificar(Pelicula pelicula) {
		peliculaDAO.modificar(pelicula);
	}

	public void borrar(Pelicula pelicula) {
		peliculaDAO.borrar(pelicula);
	}
	
}










