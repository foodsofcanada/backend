package ca.foc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.foc.domain.*;
import ca.foc.dao.ProductRepository;
import ca.foc.dom.ProductDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class ProductController {

	@Autowired
	ca.foc.services.QueryService queryservice;
	@Autowired
	ProductRepository productRepository;

//	    @GetMapping("/productRegion/{id}")
//	    public List<ProductDetail> getQuery(@PathVariable int id)
//	    {
//	        return queryservice.JPQLQuery(id);
//	    }
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/productRegion/{id}")
	public List<ProductDetail> getAllProductsInRegion(@PathVariable int id) {
		return queryservice.getAllProductsInRegion(id);
	}

	/* Returns all products in the database */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products")
	// public List<Product> getproductData()
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/products/{id}")
	public Optional<Product> getProductInfo(@PathVariable int id) {

		return productRepository.findById(id);

	}

	/*
	 * @PostMapping public Product addProduct(@RequestBody Product product) {
	 * productRepository.save(product); return product; }
	 * 
	 * @DeleteMapping(path = "/{id}") public void deleteProduct(@PathVariable int
	 * id) { productRepository.deleteById(id); }
	 */

}
