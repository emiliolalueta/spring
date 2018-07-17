package com.curso.modelo.persistencia;

import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Pelicula;

@Repository
public class PeliculaJPAImplementationDAO extends AbstractJPADAO<Pelicula, Integer>
										  implements PeliculaDAO {

}
