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
/**
 * PantryController - ca.foc.controller.PantryController
 * PantryController-  invokes PantryService class to process pantry related tasks, and then redirects to the front end.
 * 					  this controller only works when a member is logged in
 * @author Claudia Rivera, Mariia Voronina
 * 
 * 	Implementation- Mariia Voronina
 * 	Configuration to send and get request from and to back end. Claudia Rivera
 *
 */
@CrossOrigin
@RestController
public class PantryController {
   
	
	@Autowired
    PantryRepository pantryRepository;
    @Autowired
    PantryService pantryService;
    
    /**
     * Create pantry
     * @param pantry object with attributes to save the pantry: Patry name, Pantry description 
     * @return Pantry created
     */
    @PostMapping("/createPantry")
    public Pantry createPantry(@RequestBody Pantry pantry) {
        return pantryService.createPantry(pantry);
    }
    
    /**
     * Delete pantry
     * @param id is the pantryId  to be deleted
     * @return true if the pantry was successfully deleted, otherwise false.
     */
    //delete pantry
    @DeleteMapping("/deletepantry/{id}")
    @ResponseBody
	@Transactional
    public boolean deletePantry(@PathVariable int id) {
        
        return pantryService.deletePantry(id);
    }
    
    /**
     * List of pantries for one user identified by email
     * @param email, Member email
     * @return List of pantries belong to the same member
     */
    @GetMapping("/userPantries/{email}")
    public List<Pantry> getUserPantries(@PathVariable String email) {
        return pantryService.getUserPantries(email);
    }
    /**
     * List of products in a a pantry to belongs a member
     * @param email. Member email
     * @param pantryId, Id of the pantr
     * @return list of products with the appropiate response (productDetail Object)
     */
    @GetMapping("/productsInPantry/{email}/{pantryId}")
    public List<ProductDetail> getProductsInPantry(@PathVariable String email,@PathVariable int pantryId) {
        return pantryService.getProductsInPantry(email,pantryId);
    }

    /**
     * Add a product to Pantry. A product must be identified by PantryId, ProductId and regionId
     * @param pantryId. Pantry Id
     * @param productId. Id of the product
     * @param regionId. Id of the regions
     * @param coordinates. Location on the map
     * @return True if product was added, false otherwise
     */
    @PostMapping("/pantryproduct/{pantryId}/{productId}/{regionId}/{coordinates}")
    @ResponseBody
    public boolean addProductToPantry(@PathVariable int pantryId, @PathVariable int productId, @PathVariable int regionId, @PathVariable String coordinates) {
        return pantryService.addProductToPantry(pantryId, productId, regionId, coordinates);
    }

   /**
    * Delete a product from a pantry. A product must be identified by PantryId, ProductId and regionId
    *@param pantryId. Pantry Id
    * @param productId. Id of the product
    * @param regionId. Id of the regions
    * @return boolean true if the pantry was deleted. false otherwise
    */
    @DeleteMapping("/deleteproduct/{pantryId}/{productId}/{regionId}")
    @ResponseBody
    @Transactional
    public boolean deleteProductFromPantry(@PathVariable int pantryId, @PathVariable int productId, @PathVariable int regionId)
    {
        return  pantryService.deleteProductFromPantry(pantryId,productId,regionId);
    }
    /**
     * Pantry Info 
     * @param email. Member email, to identify the owner's pantry
     * @param pantryId, Pantry Id
     * @return a Pantry object with the appropiate response
     */
   	@GetMapping("/pantryinfo/{email}/{pantryId}")
   	@ResponseBody
   	public Optional<Pantry> getProductInfo(@PathVariable String email, @PathVariable Integer pantryId) {

   		return pantryService.getPantryInfo(email,pantryId);

   	}
   	
   	/**
   	 * Edit Pantry info: name, description
   	 * @param pantryId, Pantry id
   	 * @param pantry Pantry object contains the new information
   	 * @return Pantry updated
   	 */
	@PutMapping("/pantry/{pantryId}")
	@ResponseBody
	public Pantry editPantry(@PathVariable int pantryId, @RequestBody Pantry pantry) {

		return pantryService.editPantry(pantryId, pantry);
	}
    
}
