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
 * ProductController - ca.foc.controller.ProductController
 * ProductController-  invokes:
 * 							 ProductService class to process product related tasks, 
 * 							 SearchingSearchingService class to process searching by filters function
 *                           TopTenSearchedService to get the top ten most searched products
 *                           and then redirects to the front end.
 * 					  
 * @author Claudia Rivera
 * 
 * 
 * No implemented: uploadNewProducts(filePath:string)
 *                 editProduct
 *                
 */
@RestController
public class ProductController {

	@Autowired
	ca.foc.services.ProductService productService;
	@Autowired
	ca.foc.services.SearchingService searchingService;
	@Autowired
	ca.foc.services.TopTenSearchedService topTenSearchedService;

	
	/**
	 * Searching using filters
	 * @param search. Object containig the filters to apply in the searching
	 * @return result list containing all products found during the searching
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/search")
	public List<ProductDetail> search(@RequestBody SearchObject search) {

		return searchingService.SerchingResult(search);

	}
	/**
	 * Get all products in the database
	 * @return list of all products in the database
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products")

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productService.getAllProducts().forEach(products::add);
		return products;

	}
	/**
	 * Product Info 
	 * @param id product id 
	 * @return an product detail object containing in its attributes the appropiate response 
	 */
    //
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/{id}")
	public Optional<Product> getProductInfo(@PathVariable int id) {

		return productService.getProductInfo(id);

	}
	
	/**
	 *  Returns all products in the top ten table
	 * @param email
	 * @return all products in the top ten table
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/top/{email}")
	public List<TopTenObject> getTopTenSearched(@PathVariable String email) {
		
		return topTenSearchedService.getTopTenSearched(email);

	}
	
	 /**********************************************************/
    /*       Admin Operations related to manage products       */
    /**********************************************************/
	 
	/**
	 * Add New Product. Admin operation
	 * @param product
	 * @return the product that was added
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/products/")
	public Product addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return product;
	}
	/**
	 * Delete Product. Admin operation
	 * @param id product id
	 */
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/products/{id}")
	@Transactional
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	
	/**
	 * View products suggestions. Admin
	 * @return list of products suggested
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/suggestions")
	// public List<Product> getproductData()
	public List<ProductSuggestion> getAllProductsSuggested() {
		List<ProductSuggestion> products = new ArrayList<>();
		productService.getAll().forEach(products::add);
		return products;

	}

}
