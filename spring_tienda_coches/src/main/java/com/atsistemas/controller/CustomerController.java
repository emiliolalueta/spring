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

import net.minidev.json.writer.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
@Controller
public class CustomerController {
	
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
	    
	  /*
	    @POST
	    @Path("/controller")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public void controller(String message) {
	        JsonReader reader = Json.createReader(new StringReader(message));	       
	        JsonObject obj = reader.readObject();
	 
	        String oper = obj.getString("oper");
	        switch (oper) {
	        case "add":
	            addElement(obj);
	            break;
	        case "del":
	            deleteElement(obj);
	            break;
	        default:
	            editElement(obj);
	        }
	    }*/
	    
	    @RequestMapping(value = "/datos", method = RequestMethod.GET)
	    public String dataList(Model model){
	      //  model.addAttribute("products", productRepository.findAll());        
	      // model.addAttribute("orders", orderRepository.findAll());     	
	      //model.addAttribute("customer", customerRepository.findAll());  
	    	//Customer customer = new Customer();    	
	    	
	        return "data";
	    }
	    
	    @RequestMapping(value = "/custom", method = RequestMethod.GET)
	    public String customerList(Model model){
	      //  model.addAttribute("products", productRepository.findAll());        
	      // model.addAttribute("orders", orderRepository.findAll());     	
	      //model.addAttribute("customer", customerRepository.findAll());  
	    	//Customer customer = new Customer();    	
	    	
	        return "customer";
	    }
	    
	    @RequestMapping(value = "/logi", method = RequestMethod.GET)
	    public String login(Model model){
	      //  model.addAttribute("products", productRepository.findAll());        
	      // model.addAttribute("orders", orderRepository.findAll());     	
	      //model.addAttribute("customer", customerRepository.findAll());  
	    	//Customer customer = new Customer();    	
	    	
	        return "login";
	    }
	    
	    
	    //**********************************************************
	    @RequestMapping(value = "/customs", method = RequestMethod.GET)
	    public String customerLista(Model model){
	      //  model.addAttribute("products", productRepository.findAll());        
	      // model.addAttribute("orders", orderRepository.findAll());     	
	      //model.addAttribute("customer", customerRepository.findAll());  
	    	//Customer customer = new Customer();    	
	    	
	        return "customnew";
	    }
	    
	    
	    //*********************************************************
	    
	    
	    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
	    public @ResponseBody  List<Customer> ejemList() throws JsonProcessingException{
	    	//Model model
	        //model.addAttribute("products", productRepository.findAll());        
	        //model.addAttribute("orders", orderRepository.findAll());    
	    	Customer customer = new Customer();   
	    	Iterable <Customer> ListaClientes=  customerRepository.findAll();  
	    	Iterator <Customer> Lista=ListaClientes.iterator();    
	    	String jsonfinal="";
	    	List<Customer> list=new Vector<Customer>()  ;
	    	while(  Lista.hasNext()) {    		
	    		 customer = Lista.next(); 
	    		 list.add(customer);
	    		 //ObjectMapper mapper = new ObjectMapper();    		  
	    		// String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
	    		// jsonfinal=jsonfinal+json;
	    		System.out.println(customer.getCustomerId()+ "" + customer.getFirstName() + " " + customer.getLastName());
	    	}    	
	    	
	        return list;
	    }   
	    
	    
	    @RequestMapping(value = "/users", method = RequestMethod.GET)
	    public String usersList(Model model){
	      // model.addAttribute("roler", roleRepository.findAll());        
	      //  model.addAttribute("users", userRepository.findAll());
	        
	        model.addAttribute("products", productRepository.findAll());        
	        model.addAttribute("orders", orderRepository.findAll());
	        
	        return "users";
	    }  
	    
	    
	    
	    
	    
	    
	    
	    @RequestMapping(value="/guardar", method = RequestMethod.POST)
	    @ResponseBody
	    public void saveCustomer(@RequestParam Long customerId,@RequestParam String firstName, @RequestParam String lastName,@RequestParam int phone){
	        Customer customer = new Customer();
	        customer.setCustomerId(customerId);
	        customer.setFirstName(firstName);
	        customer.setLastName(lastName);
	        customer.setPhone(phone);
	        customerRepository.save(customer);  	        
	    }

	    @RequestMapping(value = "/borrar", method = RequestMethod.POST)
	    @ResponseBody
	   // public String removeOrder(@RequestParam Long customerId,@RequestParam String firstName, @RequestParam String lastName,@RequestParam Integer phone){
	    public String removeOrder(@RequestParam Long customerId){	
	    	System.out.println("Pasa por aqui");
	    	//Long Id=Long.parseLong(customerId);
	    	
	    	/*Customer customer = new Customer();
	    	customer.setCustomerId(customerId);
	        customer.setFirstName(firstName);
	        customer.setLastName(lastName);
	        customer.setPhone(phone);*/
	        
	        //System.out.println(customer.getCustomerId()+ "" + customer.getFirstName() + " " + customer.getLastName());
	        //customerRepository.delete(customer);    	
	        customerRepository.delete(customerId);
	      
	        return customerId.toString();
	    }
	    
	    
	    
	    
	    
	  

}
