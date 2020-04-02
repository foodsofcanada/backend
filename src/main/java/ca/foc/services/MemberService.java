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
import ca.foc.dao.ProductSuggestionRepository;
import ca.foc.dom.FavouriteResponse;
import ca.foc.dom.MemberResponse;
import ca.foc.dom.TopTenObject;
import ca.foc.domain.FavouriteProducts;
import ca.foc.domain.FavouriteProductsIdentity;
import ca.foc.domain.Member;
import ca.foc.domain.ProductSuggestion;
import ca.foc.domain.TopTenSearched;
import ca.foc.domain.TopTenSearchedIdentity;

/**
 * Service class for Member: Methods related to member.
 * 
 * 
 * @author 787428
 *
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
	EntityManagerFactory emf;
	
	
	//Find all members in Member table
	public Iterable<Member> getAllMembers(){
		return memberRepository.findAll();
	}
	//Save member in member table
	public void saveMember(Member member) {
		memberRepository.save(member);
		
	}
	
	//Find a member by email 
	public MemberResponse findByEmail(String email){
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
	
	/*Validate email and password*/
	public Member CheckMember(String email, String password) {
		
		Member memberDb = null;
		Optional<Member> member= memberRepository.findByEmail(email);  // find a member within the database by the email. Email is unique 
		if (member.isPresent()) {
			
			memberDb= member.get();
			//Check if the fetched member matches the input username and the hash of the password matches
			if (!memberDb.getEmail().equals(email)||!BCrypt.checkpw(password, memberDb.getPassword())) {
				memberDb=null;	
			}
		}
		else
		{
			System.out.println("member doesn't exist");
		}
		
			
		return memberDb;
	}
	
	/* Register a new member
	 * Return true if member was added
	 */
	
	public boolean NewMember(Member member) {
		boolean result= false;
		
		Optional<Member> m = memberRepository.findByEmail(member.getEmail());
		
		if (!m.isPresent()) {
			result=true;  
			Member nMember= new Member();  // new member
			nMember.setFirstname(member.getFirstname());
			nMember.setLastname(member.getLastname());
			//Set the member password to a BCrypt hash of the input password with a complexity of 4 iterations
			nMember.setPassword(BCrypt.hashpw(member.getPassword(), BCrypt.gensalt(4)));
			nMember.setEmail(member.getEmail());
			nMember.setRole(0); // set role to 0 by default
			
			memberRepository.save(nMember);
		}
		else
			result=false;
		
		return result;
		
	}
	
	/*
	 * Update member- Edit profile: change first name, last name, password, email.
	 * Returns the member that was updated
	 * */
	
	public Member editMember(String email, Member newmember) {
		//newmember is the member from the form
		//find member by email and update with data from the form
		Optional<Member> m = memberRepository.findByEmail(email);
		
		Member memberUpdated= m.get();
		memberUpdated.setEmail(newmember.getEmail());
		memberUpdated.setFirstname(newmember.getFirstname());
		memberUpdated.setLastname(newmember.getLastname());
		memberUpdated.setPassword(newmember.getPassword());
		
		return memberRepository.save(memberUpdated);
	}
		
	
	/* Delete a member in the database*/
	public void deleteMember(String email) {
		memberRepository.deleteByEmail(email);
	}
		
	/*Methods related to ProductSuggestions*/
	
	public void saveProductSuggested(String name, String description) {
		ProductSuggestion ps = new ProductSuggestion();
		ps.setDescription(description);
		ps.setName(name);
		productSuggestionRepository.save(ps);
		
	}
	
	public Iterable<ProductSuggestion> getAll(){
		return productSuggestionRepository.findAll();
	}

	
	/*Favourites related*/
	/* add a product to the favourite list.*
	 * First check if the product is already in the list. Using a composite primary key*/
	
	public boolean  addDeleteProductFavourites(String email, String coordinate, int productId, int regionId) {
		boolean isFavourite= false; // false if the product is deleted from favourites or true if it was saved
		
		FavouriteProductsIdentity key= new FavouriteProductsIdentity();
		key.setEmail(email);		
		key.setProductId(productId);
		key.setRegionId(regionId);
		 
		//check if the key exists in FavouriteProducts table
		
	   if(favProductsRepository.existsById(key)) {
					
			Optional<FavouriteProducts> fp = favProductsRepository.findById(key);
			FavouriteProducts fpDB= fp.get();
			fpDB.toString();
			favProductsRepository.delete(fpDB);  
			isFavourite= false;
			
		}
		else {
			// add to table 	
			
			FavouriteProducts fp= new FavouriteProducts(); 
			fp.setCoordinates(coordinate);
			fp.setFavouriteProductsIdentity(new FavouriteProductsIdentity(email,productId,regionId));
			favProductsRepository.save(fp);
			isFavourite =true;
		}
		
		return isFavourite;		
		
	}
	
	/*Get all products in favourite table for a user identified by email*/
	public List<FavouriteResponse> getProductsInFavourite(String email){
			List<FavouriteProducts> resultSearch = null;
			EntityManager em = emf.createEntityManager();
			List<FavouriteResponse> list= new ArrayList<FavouriteResponse>();
			Query query = em.createQuery("SELECT fp FROM FavouriteProducts fp");
			
			resultSearch = query.getResultList();
			

			for (int i= 0; i<resultSearch.size(); i++) {
				FavouriteResponse favourite = new FavouriteResponse();
				FavouriteProductsIdentity favId= resultSearch.get(i).getFavouriteProductsIdentity();
					if(favId.getEmail().equals(email)) {
						favourite.setCoordinate(resultSearch.get(i).getCoordinates());
						favourite.setProductId(favId.getProductId());
						favourite.setRegionId(favId.getRegionId());
						favourite.setIsFavourite(true);
						list.add(favourite);
					}
				
			}
			em.close();
			return list;

	}

/*Mariia*/
	
//	public List<FavouriteProductModel> getProductsInFavourite(String email) {
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("select p.name from " +
//                "Product p inner join FavouriteProducts fp on " +
//                "p.prod_id=fp.prod_id where fp.email="+email);
//        List<FavouriteProductModel> list = (List<FavouriteProductModel>) query.getResultList();
//        return list;
//    }
//
//	
	/*Admin manage member*/
    public void deleteAccount(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("DELETE from Member m where m.email="+email);
        query.executeUpdate();
    }


    public void changeMemberRole(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select role from Member where email="+email);
        List<Integer> role = query.getResultList();
        int roleToUpdate = 0;
        if (role.get(0) == 1) {
            roleToUpdate = 0;
        }
        else if (role.get(0)==0) {
            roleToUpdate = 1;
        }
        Query queryUpdate = em.createQuery("UPDATE Member m SET role=?");
        queryUpdate.setParameter(1,roleToUpdate);
        queryUpdate.executeUpdate();
    }
	
}

