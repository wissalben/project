package com.packt.project.domaine.repository;

import java.util.List;

import com.packt.project.domaine.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	Product getProductById(String productID);
	List <Product> getProductsByCategory(String category);
}
