package ca.foc.controller;

import ca.foc.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.foc.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

<<<<<<< Updated upstream
	 @Autowired
	 ProductRepository productRepository;

	    @CrossOrigin(origins = "http://localhost:3000")
	    @GetMapping(path = "/products")
	    public List<Product> getAllProducts(){
	        List<Product> products = new ArrayList<>();
	        productRepository.findAll().forEach(products :: add);
	        return products;
	    }
	    
//	    @GetMapping(path = "/products/{id}")
//	    public List<Product> getProductsInRegion(@PathVariable int id){
//	        List<Product> products = new ArrayList<>();
//	        productRepository.getAllProductsInRegion(id).forEach(products :: add);
//	        return products;
//	    }
	    
	    @GetMapping(path = "/products/{id}")
	    public List<Product> getProductInfo(@PathVariable int id){
	        List<Product> products = new ArrayList<>();
	        productRepository.getProductInfo(id).forEach(products :: add);
	        return products;
	    }
	    

	    @CrossOrigin(origins = "http://localhost:3000")
	    @PostMapping(path = "/products")
	    public Product addProduct(@RequestBody Product product){
	    	productRepository.save(product);
	        return product;
	    }

	    @CrossOrigin(origins = "http://localhost:3000")
	    @DeleteMapping(path = "/products/{id}")
	    public void deleteProduct(@PathVariable int id){
	    	productRepository.deleteById((long) id);
	    }
=======
	@Autowired
	ProductRepository productRepository;
	@Autowired
	RegionRepository regionRepository;

	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Product> getProductInfo(@PathVariable int id) {
		return productRepository.findById(id);

	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}

	@DeleteMapping(path = "/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
>>>>>>> Stashed changes
}
