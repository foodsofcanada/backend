package ca.foc.controller;

import ca.foc.dom.ProductDetail;
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

	//Get product in region 
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/productRegion/{id}")
	public List<ProductDetail> getAllProductsInRegion(@PathVariable int id) {
		return productService.getAllProductsInRegion(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/regions/{id}")
	public List<Region> getProductInfo(@PathVariable int id) {

		return regionService.getRegionById(id);

	}

	
	
}
