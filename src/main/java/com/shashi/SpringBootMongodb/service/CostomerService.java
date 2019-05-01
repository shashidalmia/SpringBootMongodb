package com.shashi.SpringBootMongodb.service;

import java.util.List;

import com.shashi.SpringBootMongodb.model.Customer;

public interface CostomerService {

    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    public boolean saveNewCustomer(Customer customer);
	
}
