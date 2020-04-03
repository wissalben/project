package com.packt.project.domaine.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.project.domaine.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	Product getProductById(String productID);
	List <Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>>filterParams);
	void addProduct(Product product);
	
	
}