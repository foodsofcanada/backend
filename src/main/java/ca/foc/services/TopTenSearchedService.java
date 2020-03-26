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

import ca.foc.domain.TopTenSearched;


@Service
public class TopTenSearchedService implements  ITopTenSearched{
	
	@Autowired
	TopTenSearchedRepository topTenSearchedRepository;
	@Autowired
	EntityManagerFactory emf;
	
	
	
	
	/* Returns all products in the database */
	
	@Override
	public List<TopTenSearched> getTopTenSearched() {
		EntityManager em = emf.createEntityManager();
		List<TopTenSearched> list= new ArrayList<TopTenSearched>();
		Query query = em.createQuery("SELECT t from TopTenSearched t order by search_counter desc  ");

		List<TopTenSearched>  resultSearch = query.getResultList();
//		System.out.println( resultSearch.toString());
//		Iterator it = resultSearch.iterator();
//		while (it.hasNext()) {
//			Object[] line = (Object[]) it.next();
//			TopTenSearched topten = new TopTenSearched();
//			topten.setProduct_id((int) line[0]);
//			topten.setSearch_counter((int) line[1]);
//			topten.setCoordinate((String) line[2]);
////			prj.setReg_id((int) line[1]);
////			prj.setProd_id((int) line[2]);
////			prj.setName((String) line[3]);
//		list.add(topten);
		//}
		em.close();
		return resultSearch;

	
	}
	
}
