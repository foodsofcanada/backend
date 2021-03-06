package ca.foc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import ca.foc.dom.ProductDetail;
import ca.foc.dom.SearchObject;
import ca.foc.dom.TopTenObject;
import ca.foc.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Product Controller
 * 
 * @author
 * 
 * 
 * No implemented: uploadNewProducts(filePath:string)
 *                 editProduct
 *                
 */
@CrossOrigin(origins = "http://foc-react.s3-website.ca-central-1.amazonaws.com")
@RestController
public class ProductController {

	@Autowired
	ca.foc.services.ProductService productService;
	@Autowired
	ca.foc.services.SearchingService searchingService;
	@Autowired
	ca.foc.services.TopTenSearchedService topTenSearchedService;

	

	//Searching using filters
//	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/search")
	public List<ProductDetail> search(@RequestBody SearchObject search) {

		return searchingService.SerchingResult(search);

	}

	/* Returns all products in the database */
//	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productService.getAllProducts().forEach(products::add);
		return products;

	}
	
    //Product Info 
//	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/{id}")
	public Optional<Product> getProductInfo(@PathVariable int id) {

		return productService.getProductInfo(id);

	}
	
	/* Returns all products in the top ten table */
//	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/top/{email}")
	public List<TopTenObject> getTopTenSearched(@PathVariable String email) {
		
		return topTenSearchedService.getTopTenSearched(email);

	}
	
	 /**********************************************************/
    /*       Admin Operations related to manage products       */
    /**********************************************************/
	// Add New Product. Admin operation
	
//	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/products/")
	public Product addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return product;
	}
	
	//Delete Product. Admin operation
//	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/products/{id}")
	@Transactional
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	

}
