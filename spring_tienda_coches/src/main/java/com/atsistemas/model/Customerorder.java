package com.atsistemas.model;

import org.hibernate.annotations.Fetch;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.Set;



@Entity
public class Customerorder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long orderid;

    private Double total;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} , fetch = FetchType.LAZY)    
    @JoinTable(name = "ORDER_PRODUCTS", joinColumns = {@JoinColumn(name = "ORDER_ID")},inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID")})
    private Set<Products> products;

    //@OneToOne
    //añadido******
   //NO                   @JoinColumn(name="customerid")
    
    
    @OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="customer_order",
	joinColumns={@JoinColumn(name="order_id", referencedColumnName="orderid")},
	inverseJoinColumns={@JoinColumn(name="customer_id", referencedColumnName="customerid")})
   
    //**************
    private Customer customer;

    public Long getOrderId() {
        return orderid;
    }

    public void setOrderId(Long orderId) {
        this.orderid = orderId;
    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer Customer) {        
    	this.customer = Customer;
    }


}
