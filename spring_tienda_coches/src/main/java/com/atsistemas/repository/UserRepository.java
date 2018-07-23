package com.atsistemas.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.atsistemas.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

   // List<User> findByApellido(String apellido);

  //  List<User> findByEdadLessThan(Integer edad);

}
