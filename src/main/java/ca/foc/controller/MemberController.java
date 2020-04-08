package ca.foc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import ca.foc.dom.FavouriteResponse;
import ca.foc.dom.MemberInfo;
import ca.foc.dom.MemberResponse;
import ca.foc.dom.TopTenObject;
import ca.foc.domain.Member;
import ca.foc.domain.ProductSuggestion;
import ca.foc.services.MemberService;

/**
 * Member controller - ca.foc.controller.MemberController
 * Member Controller-  invokes MemberService class to process member related tasks, and then redirects to the front end
 * 
 *  @author Claudia Rivera, Mariia Voronina
 *
 *         Implemented: 
 *         Register(Create an account) 
 *         Login 
 *         Find members by Id (not in controller class documentation) 
 *         Claudia. March/09/2020
 *         Suggest a product 
 *         View suggestions
 *         Edit profile
 *         Delete profile 
 *		   Claudia Rivera. March/21/2020
 *        
 *        add products To Favorites
 *        delete from favourites 
 *        getProducts in Favourites 
 *        Change member role
 *        Mariia Voronina
 * 
 */
@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	
	/**
	 * Find a member by email
	 * @param email to identify the member
	 * @return a MemberResponse object with attributes: boolean isExist, String firstname, String lastname
	 */

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/members/{email}")
	@ResponseBody
	public MemberResponse findMember(@PathVariable String email) {

		return memberService.findByEmail(email);
	}
	
	
	/**
	 * Login
	 * Verify if a member exists in the database. 
	 * @param member
	 * @return Return the member founded, null
	 * otherwise
	 */

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	@ResponseBody
	public MemberInfo checkMember(@RequestBody Member member) {
		
		return  memberService.CheckMember(member.getEmail(), member.getPassword());
	}
	
	/**
	 * Register a new member. 
	 * @param member
	 * @return true if the member was added. false other wise
	 */

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/registration")
	@ResponseBody
	public boolean addMember(@RequestBody Member member) {

		return memberService.NewMember(member);
	}
	/**
	 * Edit profile Returns the member updated
	 * @param email
	 * @param member
	 * @return member updated
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/members/{email}")
	@ResponseBody
	public Member editMember(@PathVariable String email, @RequestBody Member member) {

		return memberService.editMember(email, member);
	}
	/**
	 * Delete profile member operation
	 * @param email
	 * @return a strin indicating profile was deleted
	 */
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/members/{email}")
	@ResponseBody
	@Transactional
	public String deleteProfile(@PathVariable String email) {
		memberService.deleteMember(email);
		return "profile deleted";
	}
	/**
	 *  Member suggest a product
	 * @param name of the product suggested
	 * @param description of the product suggested
	 * @return boolean true if the suggestion was sent, otherwise false
	 */
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/suggest/{name}/{description}")
	@ResponseBody
	public boolean addSuggestion(@PathVariable String name, @PathVariable String description) {
		return memberService.saveProductSuggested(name, description);
	}
	/**
	 * Member add or delete a product in Favourite List. The product must have a unique identity given for: email, productId,regionId
	 * @param email to identify the member
	 * @param productId to identify the product
	 * @param regionId to identify the region 
	 * @param coordinates location of the product on the map
	 * @return boolean True if the product was added to the favourite list or false if the product was deleted
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/fav/{email}/{productId}/{regionId}/{coordinates}")
	@ResponseBody
	//@Transactional
	public boolean addFavourite(@PathVariable String email, @PathVariable int productId, @PathVariable int regionId,@PathVariable String coordinates) {

		return memberService.addDeleteProductFavourites(email,coordinates, productId,regionId);
	}
/**
 * Returns all products in favourite table
 * @param email identify the member
 * @return list of products in the favourite list of member identified by email
 */
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/favourites/{email}")
	public List<FavouriteResponse> getProductsInFavourite(@PathVariable String email) {
		List<FavouriteResponse> favourites = new ArrayList<>();
		memberService.getProductsInFavourite(email).forEach(favourites::add);
		return favourites;

	}
	
//	@PostMapping(path = "/fav/{product}")
//    public FavouriteProducts addProduct(@RequestBody FavouriteProducts product){
//        favProductsRepository.save(product);
//        return product;
//
//    }
//    @DeleteMapping("/deleteFav/{product}")
//    public void deleteProductsFromFavourites(@PathVariable FavouriteProducts product){
//        favProductsRepository.delete(product);
//    }
    
    /**********************************************************/
    /*       Admin Operations related to manage members       */
    /**********************************************************/
    
	
	
	/**
	 * Admin change the member role
	 * @param email to identify the member
	 */
    @PutMapping("/changerole/{email}")
    public void changeMemberRole(@PathVariable String email){
        memberService.changeMemberRole(email);
    }

}
