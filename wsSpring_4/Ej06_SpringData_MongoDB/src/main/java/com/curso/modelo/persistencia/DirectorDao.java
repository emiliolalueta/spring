package com.curso.modelo.persistencia;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Director;

@Repository
public interface DirectorDao extends MongoRepository<Director, Integer>{

	
	
}
