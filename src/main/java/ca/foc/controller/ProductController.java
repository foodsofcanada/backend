package ca.foc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.foc.domain.*;
import ca.foc.dao.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	 @Autowired
	    ProductRepository productRepository;
	 
	   // @CrossOrigin(origins = "http://localhost:3000")
	    
//	    productRepository.getProductInfo();
//	    @GetMapping(path = "/products/{id}")
//	    public List<Product> getAllProducts(@PathVariable long id){
//	        List<Product> products = new ArrayList<>();
//	        productRepository.getProductInfo(id).forEach(products :: add);
//	        return products;
//	    }
	    
//	    @GetMapping(path = "/products/{id}")
//	    public List<Product> getProductsInRegion(@PathVariable int id){
//	        List<Product> products = new ArrayList<>();
//	        productRepository.getAllProductsInRegion(id).forEach(products :: add);
//	        return products;
//	    }
	    
	    @GetMapping(path = "/{id}")
	    public List<Product> getProductInfo(@PathVariable int id){
	        List<Product> products = new ArrayList<>();
	        productRepository.getProductInfo(id).forEach(products :: add);
	        return products;
	    }

	    @PostMapping
	    public Product addProduct(@RequestBody Product product){
	    	productRepository.save(product);
	        return product;
	    }

	    @DeleteMapping(path = "/{id}")
	    public void deleteProduct(@PathVariable int id){
	    	productRepository.deleteById((long) id);
	    }
}
