package ca.foc.controller;
import ca.foc.dao.PantryRepository;
import ca.foc.domain.Pantry;
import ca.foc.domain.Product;
import ca.foc.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void createPantry(@RequestBody Pantry pantry) {
        pantryService.createPantry(pantry);
    }
    
    //delete pantry
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deletepantry/{id}")
    @ResponseBody
	@Transactional
    public String deletePantry(@PathVariable int id) {
        pantryService.deletePantry(id);
        return "Pantry deleted";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/userPantries/{email}")
    public List<Pantry> getUserPantries(@PathVariable String email) {
        return pantryService.getUserPantries(email);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/productsInPantry/{pantry_id}")
    public List<Product> getProductsInPantry(@PathVariable int pantry_id) {
        return pantryService.getProductsInPantry(pantry_id);
    }

   

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addproduct/{pantryId}/{productId}/{regionId}")
    @ResponseBody
    public boolean addProductToPantry(@PathVariable int pantryId, @PathVariable int productId, @PathVariable int regionId) {
        return pantryService.addProductToPantry(pantryId, productId, regionId);
    }

   

//    @CrossOrigin(origins = "http://localhost:3000")
//    @DeleteMapping("/deleteProduct/{pantryId}/{productId}/{regionId")
//    @ResponseBody
//   	@Transactional
//    public void deleteProductFromPantry(@PathVariable int pantryId, @PathVariable int productId, @PathVariable int regionId)
//    {
//        pantryService.deleteProductFromPantry(pantryId,productId, regionId);
//    }
}
