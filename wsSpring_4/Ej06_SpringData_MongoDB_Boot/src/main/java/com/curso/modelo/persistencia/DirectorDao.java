package com.curso.modelo.persistencia;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.curso.modelo.entidad.Director;


public interface DirectorDao extends MongoRepository<Director, Integer>{

	
	
}
