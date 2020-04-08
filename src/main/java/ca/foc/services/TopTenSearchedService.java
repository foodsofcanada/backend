package ca.foc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.foc.dao.FavProductsRepository;
import ca.foc.dao.TopTenSearchedRepository;
import ca.foc.dom.TopTenObject;
import ca.foc.domain.FavouriteProductsIdentity;
import ca.foc.domain.TopTenSearched;
import ca.foc.domain.TopTenSearchedIdentity;

/**
 *  Service class  to get  a list of products in the top ten table
 *   
 * @author Claudia Rivera
 * Date: March-27-2020
 * Modified: Include isFavourite when the list is displayed when a member is present
 * Date: March-30-2020
 */

@Service
public class TopTenSearchedService implements  ITopTenSearched{
	
	@Autowired
	TopTenSearchedRepository topTenSearchedRepository;
	@Autowired
	FavProductsRepository favProductsRepository;
	@Autowired
	EntityManagerFactory emf;
		
	/**
	 * Returns top ten products in top ten table database
	 * @param email to identify a member
	 * @return a list of TopTenObjects with the following attributes:
	 * productId, name, regionId, regionName, coordinate
	 */
	/* Returns top ten products in top ten table database */
	@Override
	public List<TopTenObject> getTopTenSearched(String email) {
		String memberId = email;
		System.out.println(memberId);
		List<TopTenSearched> resultSearch = null;
		EntityManager em = emf.createEntityManager();
		List<TopTenObject> list= new ArrayList<TopTenObject>();
		Query query = em.createQuery("SELECT tt FROM TopTenSearched tt"
				                    +" ORDER BY searchCounter DESC ");
		
		resultSearch = query.getResultList();
		

		for (int i= 0; i<resultSearch.size(); i++) {
			TopTenObject topten = new TopTenObject();
			TopTenSearchedIdentity topId= resultSearch.get(i).getTopTenSearchedIdentity();
			topten.setName(resultSearch.get(i).getProductName());
			topten.setRegionName(resultSearch.get(i).getRegionName());
			topten.setCoordinates(resultSearch.get(i).getCoordinate());
			topten.setProductId(topId.getProductId());
			topten.setRegionId(topId.getRegionId());
			list.add(topten);
		}
		//if a member is logged in
		
		 if (!memberId.isEmpty()) {
			 FavouriteProductsIdentity key= new FavouriteProductsIdentity();
			 key.setEmail(memberId);
			
			for(int i=0; i<list.size();i++) {
				
				 key.setProductId(list.get(i).getProductId());
				 key.setRegionId(list.get(i).getRegionId());
				 if(favProductsRepository.existsById(key)) {
					 list.get(i).setIsFavourite(true);
				 }
							 
			}	
		 }
		em.close();
		return list;

	
	}


	
}
