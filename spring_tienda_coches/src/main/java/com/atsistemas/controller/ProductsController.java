package com.atsistemas.controller;

import com.atsistemas.model.Products;
import com.atsistemas.repository.ProductRepository;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class ProductsController {

    @Autowired
    ProductRepository productRepository;


    @RequestMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model){
        model.addAttribute("product", productRepository.findOne(id));
        return "product";
    }
    
    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public String productsList(Model model){
        model.addAttribute("products", productRepository.findAll());
        
        return "products";
    }

    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    @ResponseBody
    public String saveProduct(@RequestBody Products product) {
        productRepository.save(product);        
        return product.getProductId().toString();
    }
    
    @RequestMapping(value = "/removeproduct", method = RequestMethod.POST)
    @ResponseBody
    public String removerProduct(@RequestParam Long Id) {    	    	
        productRepository.delete(Id);        
        return Id.toString();
    }    
 
}
