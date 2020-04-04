package ca.foc.controller;

import ca.foc.dom.ProductDetail;
import ca.foc.dom.ProductRegionJoin;
import ca.foc.domain.Product;
import ca.foc.domain.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/*
 * 
 * Implemented:
 *            getAllRegions()
 *            getProductsInRegion(reg_id)
 *            getRegion(reg_id)
 *            
 *  Claudia: March/15/2020          
 */
@RestController
//@RequestMapping(path = "/region")
public class RegionController {
	
	@Autowired
	ca.foc.services.ProductService productService;

	@Autowired
	ca.foc.services.RegionServices regionService;
	
	
	//Get all regions
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/regions")
	public List<Region> getAllRegions() {
		return regionService.getAllRegions();
	}

	//Get products in region 
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/productRegion/{id}/{email}")
	public List<ProductRegionJoin> getAllProductsInRegion(@PathVariable int id,@PathVariable String email) {
		return productService.getAllProductsInRegion(id,email);
	}
	
	//Get region 
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/regions/{id}")
	public Optional<Region> getRegion(@PathVariable int id) {

		return regionService.getRegionById(id);

	}

	
	
}
