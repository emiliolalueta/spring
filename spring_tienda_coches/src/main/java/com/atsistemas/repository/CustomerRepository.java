package com.atsistemas.repository;

import org.springframework.data.repository.CrudRepository;

import com.atsistemas.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
