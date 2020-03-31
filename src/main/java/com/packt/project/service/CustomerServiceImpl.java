package com.packt.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.project.domaine.Customer;

import com.packt.project.domaine.repository.CustomerRepository;


public class CustomerServiceImpl implements CustomerService{

CustomerRepository repository;
	
	@Autowired
    public CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }

	public List<Customer> getAllCustomers() {
		
		
		return repository.getAllCustomers();
	}

}
