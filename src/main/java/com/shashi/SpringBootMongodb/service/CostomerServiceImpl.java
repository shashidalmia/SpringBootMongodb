package com.shashi.SpringBootMongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.SpringBootMongodb.model.Customer;
import com.shashi.SpringBootMongodb.repository.CustomerRepository;

@Service
public class CostomerServiceImpl implements CostomerService{
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> findByFirstName(String firstName) {

		System.out.println("First name sent: " + firstName);
		
		List<Customer> customer = repository.findByFirstName(firstName);
		
		return customer;
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		
		System.out.println("Last name sent: " + lastName);
		
		List<Customer> customer = repository.findByLastName(lastName);
		
		return customer;
	}

	@Override
	public boolean saveNewCustomer(Customer customerColl) {
		
		System.out.println("Fist Name = " + customerColl.firstName);
		System.out.println("Last Name = " + customerColl.lastName);
		
		if(repository.save(customerColl) != null)
			return true;
		return false;
	}

}
