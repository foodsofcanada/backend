package ca.foc.controller;
import ca.foc.dao.PantryRepository;
import ca.foc.domain.Pantry;
import ca.foc.domain.Product;
import ca.foc.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PantryController {
    @Autowired
    PantryRepository pantryRepository;
    @Autowired
    PantryService pantryService;

    @GetMapping("/userPantries/{email}")
    public List<Pantry> getUserPantries(@PathVariable String email) {
        return pantryService.getUserPantries(email);
    }

    @GetMapping("/productsInPantry/{pantry_id}")
    public List<Product> getProductsInPantry(@PathVariable int pantry_id) {
        return pantryService.getProductsInPantry(pantry_id);
    }

    @PostMapping("/createPantry")
    public void createPantry(@RequestBody Pantry pantry) {
        pantryRepository.save(pantry);
    }

    @PostMapping("/addproduct/{pantry_id}{prod_id}{reg_id}")
    public void addProductToPantry(@PathVariable int pantry_id, @PathVariable int prod_id, @PathVariable int reg_id) {
        pantryService.addProductToPantry(pantry_id, prod_id, reg_id);
    }

    @DeleteMapping("/deletepantry/{pantry}")
    public void deletePantry(@PathVariable Pantry pantry) {
        pantryRepository.delete(pantry);
    }

    @DeleteMapping("/deleteProduct/{prod_id}{pantry_id}")
    public void deleteProductFromPantry(@PathVariable int prod_id, @PathVariable int pantry_id)
    {
        pantryService.deleteProductFromPantry(pantry_id,prod_id);
    }
}
