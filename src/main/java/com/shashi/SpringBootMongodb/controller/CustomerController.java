package com.shashi.SpringBootMongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.SpringBootMongodb.service.CostomerService;
import com.shashi.SpringBootMongodb.model.Customer;


@RestController
@RequestMapping("")
@CrossOrigin
public class CustomerController {

	@Autowired
	CostomerService customerService;
	
	
	
	@GetMapping("/getCustomerByFirstName/{firstName}")
	public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable("firstName") String firstName) {
		try {
			List<Customer> listOfCustomers = customerService.findByFirstName(firstName);
			if(listOfCustomers == null)
				return new ResponseEntity <List<Customer>> (HttpStatus.NOT_FOUND);
			
			
			return new ResponseEntity <List<Customer>>  (listOfCustomers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <List<Customer>> (HttpStatus.UNAUTHORIZED);
		}
	}


	@GetMapping("/getCustomerByLastName/{lastName}")
	public ResponseEntity<List<Customer>> getCustomerByLasttName(@PathVariable("lastName") String lastName) {
		try {
			List<Customer> listOfCustomers = customerService.findByLastName(lastName);
			if(listOfCustomers == null)
				return new ResponseEntity <List<Customer>> (HttpStatus.NOT_FOUND);
			
			
			return new ResponseEntity <List<Customer>>  (listOfCustomers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <List<Customer>> (HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping
	public ResponseEntity<Customer> CreateNewCustomer(@RequestBody Customer customer) {
		
		boolean abc = customerService.saveNewCustomer(customer);
		
		if(!abc)
			return new ResponseEntity<Customer> (HttpStatus.CONFLICT);
		
		return new ResponseEntity<Customer> (customer, HttpStatus.CREATED);
		
	}	
	
	
}
