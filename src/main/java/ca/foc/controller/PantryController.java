package ca.foc.controller;
import ca.foc.dao.PantryRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.domain.Pantry;
import ca.foc.domain.Product;
import ca.foc.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//@RequestMapping("/api")
public class PantryController {
   
	
	@Autowired
    PantryRepository pantryRepository;
    @Autowired
    PantryService pantryService;
    
    
    //Create pantry
    @PostMapping("/createPantry")
    public void createPantry(@RequestBody Pantry pantry) {
        pantryService.createPantry(pantry);
    }
    
    //delete pantry
    @DeleteMapping("/deletepantry/{id}")
    @ResponseBody
	@Transactional
    public String deletePantry(@PathVariable int id) {
        pantryService.deletePantry(id);
        return "Pantry deleted";
    }
    //List of pantries for one user identified by email
    @GetMapping("/userPantries/{email}")
    public List<Pantry> getUserPantries(@PathVariable String email) {
        return pantryService.getUserPantries(email);
    }

    //List of products in a a pantry to belongs a member
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
}
