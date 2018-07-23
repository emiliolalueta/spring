package com.atsistemas.controller;

import com.atsistemas.model.Customer;
import com.atsistemas.model.Customerorder;
import com.atsistemas.model.Products;
import com.atsistemas.repository.CustomerRepository;
import com.atsistemas.repository.OrderRepository;
import com.atsistemas.repository.ProductRepository;
import com.atsistemas.repository.RolerRepository;
import com.atsistemas.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;




@Controller
public class OrdersController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RolerRepository roleRepository; 
    
     
    
    

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String productsList(Model model){
        model.addAttribute("products", productRepository.findAll());        
        model.addAttribute("orders", orderRepository.findAll());
        
       return "orders";      
    }
    
    
   

    @RequestMapping(value="/createorder", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrder(@RequestParam String firstName, @RequestParam String lastName, @RequestParam(value="productIds[]") Long[] productIds){

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
        Customerorder customerOrder = new Customerorder();
        customerOrder.setCustomer(customerRepository.findOne(customer.getCustomerId()));
        Set<Products> productSet = new HashSet<Products>();
        for (Long productId:productIds){
            productSet.add(productRepository.findOne(productId));
        }
        customerOrder.setProducts(productSet);
        Double total = 0.0;
        for (Long productId:productIds){
            total = total + (productRepository.findOne(productId).getProductPrice());
        }
        customerOrder.setTotal(total);
        orderRepository.save(customerOrder);

        return customerOrder.getOrderId().toString();
    }

    @RequestMapping(value = "/removeorder", method = RequestMethod.POST)
    @ResponseBody
    public String removeOrder(@RequestParam Long Id){
        orderRepository.delete(Id);
        return Id.toString();
    }
}