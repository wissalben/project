package com.packt.project.domaine.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.project.domaine.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

	
private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
Customer customer1 = new Customer();
	
	customer1.setCustomerId("1");
	customer1.setName("wissal");
	customer1.setAdress("rabat");
	customer1.setNoOfOrdersMade("nothing so far");
	
Customer customer2 = new Customer();
	
	customer2.setCustomerId("2");
	customer2.setName("wissal");
	customer2.setAdress("rabat");
	customer2.setNoOfOrdersMade("nothing so far");
	
Customer customer3 = new Customer();
	
	customer3.setCustomerId("3");
	customer3.setName("wissal");
	customer3.setAdress("rabat");
	customer3.setNoOfOrdersMade("nothing so far");
	
	
	listOfCustomers.add(customer1);

	listOfCustomers.add(customer2);

	listOfCustomers.add(customer3);
	
	}
	
	
	public List<Customer> getAllCustomers() {
		
		return listOfCustomers;
	}
	
	}

