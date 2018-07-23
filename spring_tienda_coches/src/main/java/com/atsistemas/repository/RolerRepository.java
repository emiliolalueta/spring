package com.atsistemas.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.atsistemas.model.Role;

public interface RolerRepository extends CrudRepository<Role, Long> {

   // List<User> findByApellido(String apellido);

  //  List<User> findByEdadLessThan(Integer edad);

}
