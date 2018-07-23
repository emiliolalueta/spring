package com.atsistemas.model;

import javax.persistence.*;



@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
      
    
    private Long id;
    
    
    private String marca;

    private Double precio;   
    

    public Long getProductId() {
        return id;
    }

    public void setProductId(Long Id) {
        id = Id;
    }

    public String getProductName() {
        return marca;
    }

    public void setProductName(String Marca) {
        this.marca = Marca;
    }

    public Double getProductPrice() {
        return precio;
    }

    public void setProductPrice(Double Precio) {
        this.precio = Precio;
    }


}

