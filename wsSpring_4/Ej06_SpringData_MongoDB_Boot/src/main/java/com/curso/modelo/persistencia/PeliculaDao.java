package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.curso.modelo.entidad.Pelicula;


public interface PeliculaDao extends MongoRepository<Pelicula, Integer>{

	List<Pelicula> findByGeneroOrYear(String genero, Integer year);
	
}
