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
 * Member Controller
 * 
 * @author
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
 *
 *       
 *         add products To Favorites
 *         delete from favourites 
 *         getProducts in Favourites 
 *         Change member role
 *        Mariia Voronina
 * 
 */
@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	

	/* Find a member by email */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/members/{email}")
	@ResponseBody
	public MemberResponse findMember(@PathVariable String email) {

		return memberService.findByEmail(email);
	}

	/*
	 *Login
	 * Verify if a member exists in the database. Return the member founded, null
	 * otherwise
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	@ResponseBody
	public MemberInfo checkMember(@RequestBody Member member) {
		
		return  memberService.CheckMember(member.getEmail(), member.getPassword());
	}

	/*
	 * Register a new member. Returns true if the member was added. false other wise
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/registration")
	@ResponseBody
	public boolean addMember(@RequestBody Member member) {

		return memberService.NewMember(member);
	}

	/* Edit profile Returns the member updated */
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/members/{email}")
	@ResponseBody
	public Member editMember(@PathVariable String email, @RequestBody Member member) {

		return memberService.editMember(email, member);
	}

	// Delete profile member operation
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/members/{email}")
	@ResponseBody
	@Transactional
	public String deleteProfile(@PathVariable String email) {
		memberService.deleteMember(email);
		return "profile deleted";
	}

	/* Member suggest a product */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/suggest/{name}/{description}")
	@ResponseBody
	public boolean addSuggestion(@PathVariable String name, @PathVariable String description) {
		return memberService.saveProductSuggested(name, description);
	}
	
	/*Member add or delete a product in Favourite List*/
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/fav/{email}/{productId}/{regionId}/{coordinates}")
	@ResponseBody
	//@Transactional
	public boolean addFavourite(@PathVariable String email, @PathVariable int productId, @PathVariable int regionId,@PathVariable String coordinates) {

		return memberService.addDeleteProductFavourites(email,coordinates, productId,regionId);
	}
   
	/* Returns all products in favourite table */
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
    /* View products suggestions. Admin */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/suggestions")
	// public List<Product> getproductData()
	public List<ProductSuggestion> getAllProducts() {
		List<ProductSuggestion> products = new ArrayList<>();
		memberService.getAll().forEach(products::add);
		return products;

	}
	

    @PutMapping("/changerole/{email}")
    public void changeMemberRole(@PathVariable String email){
        memberService.changeMemberRole(email);
    }

}
