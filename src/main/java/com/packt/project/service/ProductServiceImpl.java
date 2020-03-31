package com.packt.project.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.project.domaine.Product;
import com.packt.project.domaine.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
  
	ProductRepository repository;
	
	@Autowired
    public ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

	@Override
	public List<Product> getAllProducts() {
		
		
		return repository.getAllProducts();
	}

	public Product getProductById(String productID) {
		
		return repository.getProductById(productID);
	}

	public List<Product> getProductsByCategory(String category) {
		
		return repository.getProductsByCategory(category);
		}
	

	
}
		

	 
	
	


