package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.modelo.entidad.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByDireccion(String direccion);
	List<Cliente> findByDireccionOrTelefono(String direccion, String telefono);
	
	@Query("select c from Cliente c order by c.direccion")
	List<Cliente> findAllOrderByDireccion();
	


}
