package ca.foc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.foc.dao.TopTenSearchedRepository;
import ca.foc.dom.TopTenObject;
import ca.foc.domain.TopTenSearched;
import ca.foc.domain.TopTenSearchedIdentity;


@Service
public class TopTenSearchedService implements  ITopTenSearched{
	
	@Autowired
	TopTenSearchedRepository topTenSearchedRepository;
	@Autowired
	EntityManagerFactory emf;
		
	
	/* Returns top ten products in  products in top ten table database */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TopTenObject> getTopTenSearched() {
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
		em.close();
		return list;

	
	}


	
}
