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

import ca.foc.dao.FavProductsRepository;
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
 *		   Claudia. March/21/2020
 *         Missing:
 *
 *       
 *         ---add products To Favorites
 *         ---delete from favourites 
 *         ---getProducts in Favourites 
 *         ---Change member role
 * 
 *         Claudia: March/15/2020
 * 
 */
@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	 @Autowired
	FavProductsRepository favProductsRepository;

	/* Find a member by email */
	@GetMapping("/members/{email}")
	@ResponseBody
	public Optional<Member> findMember(@PathVariable String email) {

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
	public Member checkMember(@RequestBody Member member) {
		Member check = memberService.CheckMember(member.getEmail(), member.getPassword());
		return check;
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

		return memberService.EditMember(email, member);
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
	public String addSuggestion(@PathVariable String name, @PathVariable String description) {

		memberService.saveProductSuggested(name, description);
		return "Request sent";

	}

	/* View products suggestions. Admin */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/suggestions")
	// public List<Product> getproductData()
	public List<ProductSuggestion> getAllProducts() {
		List<ProductSuggestion> products = new ArrayList<>();
		memberService.getAll().forEach(products::add);
		return products;

	}

}
