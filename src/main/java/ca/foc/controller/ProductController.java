package ca.foc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.foc.domain.*;
import ca.foc.dao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/products")
public class ProductController {

	@Autowired
	RegionRepository regionRepository;
	@Autowired
	ProductRepository productRepository;
    @Autowired
	ProductRegionRepository productRegionRepository;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/region")
	public List<Region> getRegions() {
		List<Region> regions = new ArrayList<>();
		regionRepository.findAll().forEach(regions::add);
		return regions;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/products")
	public List<Product> getAllProducts(){
	 List<Product> products = new ArrayList<>();
	 productRepository.findAll().forEach(products :: add);
	 return products;
	 }

	 @CrossOrigin(origins = "http://localhost:3000")
	 @GetMapping(path = "/productRegion")
	 public List<ProductRegion> getProductRegion(){
	 List<ProductRegion> productRegion = new ArrayList<>();
	 productRegionRepository.findAll().forEach(productRegion :: add);
	 return productRegion;
	 }

	 @GetMapping(path = "/productsinreg/{id}")
	 public List<String> getProductsInRegion(@PathVariable int id){
	 List<String> products = new ArrayList<>();
	 productRepository.getAllProductsInRegion(id).forEach(products :: add);
	 return products;
	 }

	@GetMapping(path = "/products/{id}")
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
}
