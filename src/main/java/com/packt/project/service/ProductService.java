package com.packt.project.service;

import java.util.List;

import com.packt.project.domaine.Product;

public interface ProductService {
	List<Product> getAllProducts(); 
	Product getProductById(String productID);
	List<Product> getProductsByCategory(String category);

}
