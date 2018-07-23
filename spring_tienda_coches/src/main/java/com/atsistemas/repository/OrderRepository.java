package com.atsistemas.repository;

import org.springframework.data.repository.CrudRepository;

import com.atsistemas.model.Customerorder;


public interface OrderRepository extends CrudRepository<Customerorder,Long>{

}
