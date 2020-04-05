package ca.foc.controller;
import ca.foc.dao.PantryRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.domain.Member;
import ca.foc.domain.Pantry;
import ca.foc.domain.Product;
import ca.foc.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class PantryController {
   
	
	@Autowired
    PantryRepository pantryRepository;
    @Autowired
    PantryService pantryService;
    
    
    //Create pantry
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createPantry")
    public Pantry createPantry(@RequestBody Pantry pantry) {
        return pantryService.createPantry(pantry);
    }
    
    //delete pantry
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deletepantry/{id}")
    @ResponseBody
	@Transactional
    public boolean deletePantry(@PathVariable int id) {
        
        return pantryService.deletePantry(id);
    }
    //List of pantries for one user identified by email
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/userPantries/{email}")
    public List<Pantry> getUserPantries(@PathVariable String email) {
        return pantryService.getUserPantries(email);
    }

    //List of products in a a pantry to belongs a member
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/productsInPantry/{email}/{pantryId}")
    public List<ProductDetail> getProductsInPantry(@PathVariable String email,@PathVariable int pantryId) {
        return pantryService.getProductsInPantry(email,pantryId);
    }

   
    //Add a product to Pantry
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/pantryproduct/{pantryId}/{productId}/{regionId}/{coordinates}")
    @ResponseBody
    public boolean addProductToPantry(@PathVariable int pantryId, @PathVariable int productId, @PathVariable int regionId, @PathVariable String coordinates) {
        return pantryService.addProductToPantry(pantryId, productId, regionId, coordinates);
    }

   
    //Delete a product from a pantry
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteproduct/{pantryId}/{productId}/{regionId}")
    @ResponseBody
    @Transactional
    public boolean deleteProductFromPantry(@PathVariable int pantryId, @PathVariable int productId, @PathVariable int regionId)
    {
        return  pantryService.deleteProductFromPantry(pantryId,productId,regionId);
    }
    
    //Pantry Info 
   	@CrossOrigin(origins = "http://localhost:3000")
   	@GetMapping("/pantryinfo/{email}/{pantryId}")
   	@ResponseBody
   	public Optional<Pantry> getProductInfo(@PathVariable String email, @PathVariable Integer pantryId) {

   		return pantryService.getPantryInfo(email,pantryId);

   	}
   	
   	/* Edit profile Returns the member updated */
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/pantry/{pantryId}")
	@ResponseBody
	public Pantry editPantry(@PathVariable int pantryId, @RequestBody Pantry pantry) {

		return pantryService.editPantry(pantryId, pantry);
	}
    
}
