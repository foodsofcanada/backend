package ca.foc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ca.foc.dao.FavProductsRepository;
import ca.foc.dao.MemberRepository;
import ca.foc.dao.PantryProductRegionRepository;
import ca.foc.dao.PantryRepository;
import ca.foc.dao.ProductSuggestionRepository;
import ca.foc.dom.FavouriteResponse;
import ca.foc.dom.MemberInfo;
import ca.foc.dom.MemberResponse;
import ca.foc.dom.TopTenObject;
import ca.foc.domain.FavouriteProducts;
import ca.foc.domain.FavouriteProductsIdentity;
import ca.foc.domain.Member;
import ca.foc.domain.Pantry;
import ca.foc.domain.ProductSuggestion;
import ca.foc.domain.TopTenSearched;
import ca.foc.domain.TopTenSearchedIdentity;

/**
 * Service class for Member: Methods related to member.
 * @author Claudia Rivera, Mariia Voronina
 * 
 * 
 *Christian: add hashed password and password validation
 */

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ProductSuggestionRepository productSuggestionRepository;
	@Autowired
	FavProductsRepository favProductsRepository;
	@Autowired
	PantryRepository pantryRepository;
	@Autowired
	PantryProductRegionRepository pantryProductRegionRepository;
	@Autowired
	EntityManagerFactory emf;

	/**
	 * Find all members in Member table
	 * @return list of members
	 */
	 
	public Iterable<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	/**
	 * Store a member in Member table
	 * @param member to be stored
	public void saveMember(Member member) {
		memberRepository.save(member);

	}

	/**
	 * Find a member in member table finding by email
	 * @param email, member email
	 * @return a MemberResponse object contains only the appropriate response:
	 */
	public MemberResponse findByEmail(String email) {
		Optional<Member> m = memberRepository.findByEmail(email);
		MemberResponse mr = new MemberResponse();
		if (m.isPresent()) {
			Member member = m.get();
			mr.setIsExist(true);
			mr.setFirstName(member.getFirstname());
			mr.setLastName(member.getLastname());
		}
		return mr;
	}
	
     /**
      * Validate email and password 
      * @param email. member email
      * @param password. member password
      * @return MemberInfo Object contains the appropiate response 
      */
	@SuppressWarnings("null")
	public MemberInfo CheckMember(String email, String password) {

		Member memberDb = null;
		MemberInfo memberInfo = new MemberInfo();
		Optional<Member> member = memberRepository.findByEmail(email); // find a member within the database by the
																		// email. Email is unique
		if (member.isPresent()) {
			memberDb = member.get();// member in the database
			// Check if the fetched member matches the input username and the hash of the
			// password matches
			if (!memberDb.getEmail().equals(email) || !BCrypt.checkpw(password, memberDb.getPassword())) {
				memberDb = null;
			}
			if (memberDb != null) {
				memberInfo.setEmail(memberDb.getEmail());
				memberInfo.setFirstName(memberDb.getFirstname());
				memberInfo.setLastName(memberDb.getLastname());
			} else
				memberInfo = null;
		} else {
			System.out.println("member doesn't exist");
		}

		return memberInfo;
	}

	/*
	 * 
	 */
	/**
	 * Register a new member 
	 * @param member member to be registered
	 * @return true if member was added
	 */
	public boolean NewMember(Member member) {
		boolean result = false;

		Optional<Member> m = memberRepository.findByEmail(member.getEmail());

		if (!m.isPresent()) {
			result = true;
			Member nMember = new Member(); // new member
			nMember.setFirstname(member.getFirstname());
			nMember.setLastname(member.getLastname());
			// Set the member password to a BCrypt hash of the input password with a
			// complexity of 4 iterations
			nMember.setPassword(BCrypt.hashpw(member.getPassword(), BCrypt.gensalt(4)));
			nMember.setEmail(member.getEmail());
			nMember.setRole(0); // set role to 0 by default

			memberRepository.save(nMember);
		} else
			result = false;

		return result;

	}

	/*
	 * 
	 * Returns the member that was updated
	 * */
	/**
	 * Update member- Edit profile: change first name, last name, password.
	 * @param email. Member's email 
	 * @param newmember. Information to be edited
	 * @return Member with the new information
	 */
	public Member editMember(String email, Member newmember) {
		//newmember is the member from the form
		//find member by email and update with data from the form
		Optional<Member> m = memberRepository.findByEmail(email);
		Member memberUpdated = m.get();
		
		if(!newmember.getFirstname().equals("")) {	
			memberUpdated.setFirstname(newmember.getFirstname());
		}
		if(!newmember.getLastname().equals("")) {
		   memberUpdated.setLastname(newmember.getLastname());
		}
		if(!newmember.getPassword().equals("")) {
			//Set the member password to a BCrypt hash of the input password with a complexity of 4 iterations
	    	memberUpdated.setPassword(BCrypt.hashpw(newmember.getPassword(),BCrypt.gensalt(4)));
		}
//		Member memberSaved = memberRepository.save(memberUpdated);
//		MemberInfo memberInfo = new MemberInfo();
//		memberInfo.setEmail(memberSaved.getEmail());;
//		memberInfo.setFirstName(memberSaved.getFirstname());
//		memberInfo.setLastName(memberSaved.getLastname());
		return memberRepository.save(memberUpdated);
	}
	/**
	 * Delete a member in the database 
	 * @param email. member email
	 */
	public void deleteMember(String email) {

		// first delete FavouriteProducts, Pantries
		List<Pantry> pantryMember = pantryRepository.findByEmail(email); // find all pantries belongs to a member
		for (int i = 0; i < pantryMember.size(); i++) {
			int pantryId = pantryMember.get(i).getPantryId();
			pantryProductRegionRepository.deleteByPantryId(pantryId);
		}
		List<FavouriteResponse> favouriteMember = this.getProductsInFavourite(email);
		for (int i = 0; i < favouriteMember.size(); i++) {
			FavouriteProductsIdentity id = new FavouriteProductsIdentity();
			id.setEmail(email);
			id.setProductId(favouriteMember.get(i).getProductId());
			id.setRegionId(favouriteMember.get(i).getRegionId());
			Optional<FavouriteProducts> fp = favProductsRepository.findById(id);
			FavouriteProducts fpDB = fp.get();
			fpDB.toString();
			favProductsRepository.delete(fpDB);
		}

		pantryRepository.deleteByEmail(email);
		memberRepository.deleteByEmail(email);
	}

	
	/**
	 * add a product to the favourite list.*
	 * First check if the product is already in the list. Using a composite primary key
	 * @param email
	 * @param coordinate
	 * @param productId
	 * @param regionId
	 * @return true if the porduct was added to the favourite list, false if it was deleted
	 */
	public boolean  addDeleteProductFavourites(String email, String coordinate, int productId, int regionId) {	

		boolean flag = false; // false if the product is deleted from favourites or true if it was saved
		FavouriteProductsIdentity key= new FavouriteProductsIdentity();	
		key.setEmail(email);					
		key.setEmail(email);
		key.setProductId(productId);			
		key.setRegionId(regionId);			
		 	
		//check if the key exists in FavouriteProducts table			
			
	   if(favProductsRepository.existsById(key)) {			
						
			Optional<FavouriteProducts> fp = favProductsRepository.findById(key);				
			FavouriteProducts fpDB= fp.get();				
			fpDB.toString();				
			favProductsRepository.delete(fpDB);  				
			flag= false;				


		}			
		else {				// add to table
					

			FavouriteProducts fp = new FavouriteProducts();
			fp.setCoordinates(coordinate);				
			fp.setFavouriteProductsIdentity(new FavouriteProductsIdentity(email,productId,regionId));				
			favProductsRepository.save(fp);				
			flag =true;				
		}			
			
		return flag;					
			
	}
	
	/**
	 * Get all products in favourite table for a user identified by email
	 * @param email to identify the member 
	 * @return list of favourites products (FavouriteResponse)
	 */
	public List<FavouriteResponse> getProductsInFavourite(String email){
			List<FavouriteProducts> resultSearch = null;
			EntityManager em = emf.createEntityManager();
			List<FavouriteResponse> list= new ArrayList<FavouriteResponse>();
			Query query = em.createQuery("SELECT fp FROM FavouriteProducts fp");
			//Query query2 = em.createQuery("SELECT r.regionId FROM Region r");
			resultSearch = query.getResultList();
			

			for (int i= 0; i<resultSearch.size(); i++) {
				FavouriteResponse favourite = new FavouriteResponse();
				FavouriteProductsIdentity favId= resultSearch.get(i).getFavouriteProductsIdentity();
							
				Query query2 = em.createQuery("SELECT r.regionName FROM Region r WHERE r.regionId= "+ favId.getRegionId());
				Query query3 = em.createQuery("SELECT p.name FROM Product p WHERE p.productId= "+favId.getProductId());
				String regName=(String) query2.getSingleResult();
				String prodName= (String) query3.getSingleResult();
				
				if(favId.getEmail().equals(email)) {
					  
						favourite.setCoordinates(resultSearch.get(i).getCoordinates());
						favourite.setProductId(favId.getProductId());
						favourite.setRegionId(favId.getRegionId());
						favourite.setRegionName(regName);
						favourite.setName(prodName);
						favourite.setIsFavourite(true);
						list.add(favourite);
					}				
			}

		em.close();
		return list;

	}
	
	/*  */
	/**
	 * Method related to ProductSuggestions: save a product in the table Product_suggestions
	 * @param name of the product
	 * @param description of the product
	 * @return true if the suggestion was saved, otherwise false
	 */
	public boolean saveProductSuggested(String name, String description) {
		boolean validation = false;
		ProductSuggestion ps = new ProductSuggestion();
		ps.setDescription(description);
		ps.setName(name);
		ps=productSuggestionRepository.save(ps);
		int id = ps.getId();
		Optional<ProductSuggestion> psDB = productSuggestionRepository.findById(id);
		
		//check if the product was saved in the product suggestion table
		if  (productSuggestionRepository.existsById(id)) {
			validation = true;
			
		}
		return validation;

	}

	/* Mariia */

	// public List<FavouriteProductModel> getProductsInFavourite(String email) {
	// EntityManager em = emf.createEntityManager();
	// Query query = em.createQuery("select p.name from " +
	// "Product p inner join FavouriteProducts fp on " +
	// "p.prod_id=fp.prod_id where fp.email="+email);
	// List<FavouriteProductModel> list = (List<FavouriteProductModel>)
	// query.getResultList();
	// return list;
	// }
	//
	//
	/* Admin manage member */
	
	/**
	 * Admin. Delete a member account
	 * @param email. Member email
	 */
	public void deleteAccount(String email) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("DELETE from Member m where m.email=" + email);
		query.executeUpdate();
	}
	/**
	 * Admin. Change member role
	 * @param email. member email
	 */
	public void changeMemberRole(String email) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select role from Member where email=" + email);
		List<Integer> role = query.getResultList();
		int roleToUpdate = 0;
		if (role.get(0) == 1) {
			roleToUpdate = 0;
		} else if (role.get(0) == 0) {
			roleToUpdate = 1;
		}
		Query queryUpdate = em.createQuery("UPDATE Member m SET role=?");
		queryUpdate.setParameter(1, roleToUpdate);
		queryUpdate.executeUpdate();
	}

}
