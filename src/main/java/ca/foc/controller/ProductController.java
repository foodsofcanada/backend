package ca.foc.controller;

import ca.foc.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.foc.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	@GetMapping(path = "/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping(path = "/products/{id}")
	public Optional<Product> getProductInfo(@PathVariable int id) {
		return productRepository.findById(id);
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path = "/products")
	public Product addProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(path = "/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
}