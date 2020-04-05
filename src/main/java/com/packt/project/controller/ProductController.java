package com.packt.project.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.project.domaine.Product;
import com.packt.project.exception.NoProductsFoundUnderCategoryException;
import com.packt.project.exception.ProductNotFoundException;
import com.packt.project.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping
	public String list(Model model) {
	
			model.addAttribute("products", productService.getAllProducts());
			return "products";
			
		
	
	}
	 @RequestMapping("/all")
	    public String allProducts(Model model){
	        model.addAttribute("products", productService.getAllProducts());
	        return "products";
	    }
	 
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId,Model model) {
		
		
	model.addAttribute("product",productService.getProductById(productId));

	return "product";
	}
	
	
	
    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model,@PathVariable("category") String category) {
    		List<Product> products=productService.getProductsByCategory(category);
    		if (products == null || products.isEmpty()) {
    		throw new NoProductsFoundUnderCategoryException();
    		}
    		model.addAttribute("products", products);
    		return "products";
    		}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams,Model model) {
	model.addAttribute("products",productService.getProductsByFilter(filterParams));
	return "products";
	}
 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
	Product newProduct = new Product();
	model.addAttribute("newProduct", newProduct);
	return "addProduct";
	}
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	
    	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, BindingResult result, HttpServletRequest request) {
            if(result.hasErrors()) {
                return "addProduct";
            }

            String[] supressedFields = result.getSuppressedFields();
            if (supressedFields.length > 0) {
                throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(supressedFields));
            }

            MultipartFile productImage = productToBeAdded.getProductImage();
            String rootDirectory = request.getSession().getServletContext().getRealPath("/");
            if (productImage!=null && !productImage.isEmpty()) {
                try {
                    productImage.transferTo(new File(rootDirectory+"/resources/images/"+productToBeAdded.getProductId() + ".jpeg"));
                } catch (Exception e) {
                    throw new RuntimeException("Product Image saving failed", e);
                }
            }
           

            productService.addProduct(productToBeAdded);

            return "redirect:/products";
        }
    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
    binder.setDisallowedFields("unitsInOrder", "discontinued");
    binder.setAllowedFields("productId", "name", "unitPrice", "description",
            "manufacturer", "category", "unitsInStock", "productImage", "condition");
    }
    
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);

        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
	}

	



