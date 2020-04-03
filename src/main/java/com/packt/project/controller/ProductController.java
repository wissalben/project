package com.packt.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.project.domaine.Product;
import com.packt.project.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {
	
			model.addAttribute("products", productService.getAllProducts());
			return "products";
			
		
	
	}
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId,Model model) {
		
	model.addAttribute("product",productService.getProductById(productId));

	return "product";
	}
	
	
	
    @RequestMapping("products/{category}")
	public String getProductsByCategory(Model model,@PathVariable("category") String productCategory) {
	model.addAttribute("products",productService.getProductsByCategory(productCategory));
	return "products";
	}
    
	
	@RequestMapping("products/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams,Model model) {
	model.addAttribute("products",productService.getProductsByFilter(filterParams));
	return "products";
	}
 
	@RequestMapping(value = "products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
	Product newProduct = new Product();
	model.addAttribute("newProduct", newProduct);
	return "addProduct";
	}
	
	@RequestMapping(value = "products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct")Product newProduct) {
	productService.addProduct(newProduct);
	return "redirect:/products";
	}
	
	
	
}


