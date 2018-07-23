package com.atsistemas.model;


import javax.persistence.*;



@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long customerid;

    private String firstname;

    private String lastname;
    
    private int phone;

    public int getPhone() {
		return phone;
	}

	public void setPhone(int Phone) {
		this.phone = Phone;
	}

	public long getCustomerId() {
        return customerid;
    }

    public void setCustomerId(long customerId) {
        this.customerid = customerId;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

}
