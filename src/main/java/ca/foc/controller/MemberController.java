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
@CrossOrigin(origins = "http://foc-react.s3-website.ca-central-1.amazonaws.com")
@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	

	/* Find a member by email */
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
	@PostMapping("/login")
	@ResponseBody
	public Member checkMember(@RequestBody Member member) {
		Member check = memberService.CheckMember(member.getEmail(), member.getPassword());
		return check;
	}

	/*
	 * Register a new member. Returns true if the member was added. false other wise
	 */
	@PostMapping("/registration")
	@ResponseBody
	public boolean addMember(@RequestBody Member member) {

		return memberService.NewMember(member);
	}

	/* Edit profile Returns the member updated */
	@PutMapping("/members/{email}")
	@ResponseBody
	public Member editMember(@PathVariable String email, @RequestBody Member member) {

		return memberService.editMember(email, member);
	}

	// Delete profile member operation
	@DeleteMapping("/members/{email}")
	@ResponseBody
	@Transactional
	public String deleteProfile(@PathVariable String email) {
		memberService.deleteMember(email);
		return "profile deleted";
	}

	/* Member suggest a product */
	@PostMapping("/suggest/{name}/{description}")
	@ResponseBody
	public String addSuggestion(@PathVariable String name, @PathVariable String description) {

		memberService.saveProductSuggested(name, description);
		return "Request sent";

	}
	
	/*Member add or delete a product in Favourite List*/
	@PostMapping("/fav/{email}/{productId}/{regionId}/{coordinates}")
	@ResponseBody
	//@Transactional
	public boolean addFavourite(@PathVariable String email, @PathVariable int productId, @PathVariable int regionId,@PathVariable String coordinates) {

		return memberService.addDeleteProductFavourites(email,coordinates, productId,regionId);
	}
   
	/* Returns all products in favourite table */
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
