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

public class ProductController {

	@Autowired
	ca.foc.services.ProductService productService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/productRegion/{id}")
	public List<ProductDetail> getAllProductsInRegion(@PathVariable int id) {
		return productService.getAllProductsInRegion(id);
	}

	/* Returns all products in the database */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products")
	// public List<Product> getproductData()
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productService.getAllProducts().forEach(products::add);
		return products;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/{id}")
	public Optional<Product> getProductInfo(@PathVariable int id) {

		return productService.getProductInfo(id);

	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/products/")
	public Product addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return product;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}

}
