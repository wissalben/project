package com.packt.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.project.domaine.Product;
import com.packt.project.domaine.repository.ProductRepository;
import com.packt.project.service.OrderService;




@Service
public class OrderServiceImpl implements OrderService{
	
@Autowired
private ProductRepository productRepository;

public void processOrder(String productId, int quantity) {
	
Product productById = productRepository.getProductById(productId);

if(productById.getUnitsInStock() < quantity){
	
throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());

}
productById.setUnitsInStock(productById.getUnitsInStock() -quantity);
}

}

