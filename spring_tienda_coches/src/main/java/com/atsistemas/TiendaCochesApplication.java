package com.atsistemas;

import com.atsistemas.model.Products;
import com.atsistemas.model.Usuario;
import com.atsistemas.repository.CustomerRepository;
import com.atsistemas.repository.OrderRepository;
import com.atsistemas.repository.ProductRepository;
import com.atsistemas.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TiendaCochesApplication implements CommandLineRunner {

	@Autowired
    ProductRepository productRepository;

	@Autowired
    CustomerRepository customerRepository;

	@Autowired
    OrderRepository orderRepository;

    public static void main(String[] args) {
		SpringApplication.run(TiendaCochesApplication.class, args);      	
	}


    @Override
    public void run(String... strings) throws Exception {

        Products seat = new Products();
        seat.setProductName("Seat ");
        seat.setProductPrice(3.95);

        Products ford = new Products();
        ford.setProductName("Ford ");
        ford.setProductPrice(4.95);

       // productRepository.save(seat);
       // productRepository.save(ford);


    }


}
