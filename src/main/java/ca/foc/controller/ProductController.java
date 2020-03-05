package ca.foc.controller;

import ca.foc.services.ProductServices;
import org.springframework.web.bind.annotation.*;
import ca.foc.domain.Product;
import java.util.List;
import java.util.Optional;

/**
 * ProductController - ca.foc.controller.ProductController Description:
 * Responsible for connecting frontend to the backend
 */

@RestController
@RequestMapping(path = "/products")
public class ProductController {

	static ProductServices productServices;

	@GetMapping(path = "/products")
	public List<Product> getAllProducts() {
		return productServices.getAllProducts();
	}

	@GetMapping(path = "/products/{id}")
	public Optional<Product> getProductInfo(@PathVariable int id) {
		return productServices.getProductInfo(id);
	}

	@PostMapping(path = "/products")
	public Product addProduct(@RequestBody Product product) {
		return productServices.addProduct(product);
	}

	@DeleteMapping(path = "/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productServices.deleteProduct(id);
	}
}
