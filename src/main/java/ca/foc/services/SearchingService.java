package ca.foc.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.foc.dao.ProductRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.dom.SearchObject;

/**
 * Service class. Implement Searching by filters
 * 
 * @author
 * 
 *         Claudia R. Receive a SearchObject object with 3 arrayList one for each filter.
 *         Then filters are passed to a String and inserted in each query. 
 *         Returns a list with ProductDetail objects that fit the search
 *         The data returned is 
 *         Coordinates
 *         reg_id
 *         regionName
 *         prod_id
 *         name
 *         
 *         Date:March-15-2020
 * 
 * 
 *
 */
@Service
public class SearchingService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	EntityManagerFactory emf;

	public List<ProductDetail> SerchingResult(SearchObject so) {

		ArrayList<Integer> productList = so.getProductsSearched();
		ArrayList<String> seasonList = so.getSeasonSearched();
		ArrayList<Integer> regionList = so.getRegionSearched();

		EntityManager em = emf.createEntityManager();
		List<Object[]> resultSearch1 = null;
		List<ProductDetail> resultSearch = null;
		List<ProductDetail> list= new ArrayList<ProductDetail>();

		String seasons = "";
		String regions = "";
		String products = "";
		// build a string with season filters
		if (!seasonList.isEmpty()) {
			for (int i = 0; i < seasonList.size(); i++) {
				seasons += "'" + seasonList.get(i) + "', ";
			}
			if (seasons.length() > 0) {
				seasons = seasons.substring(0, seasons.length() - 2);
			}
		}

		// build a string with products id filters if

		for (int i = 0; i < productList.size(); i++) {
			products += productList.get(i) + ", ";
		}
		if (products.length() > 0)
			products = products.substring(0, products.length() - 2);

		// Build a string with regions id filters
		if (!regionList.isEmpty()) {
			for (int i = 0; i < regionList.size(); i++) {
				regions += regionList.get(i) + ", ";
			}
			if (regions.length() > 0)
				regions = regions.substring(0, regions.length() - 2);
		}


		// productList always is not empty
		// check if seasons is not empty
		if (!seasonList.isEmpty()) {
			// Check if regions is not empty. Then search by product id, region id and
			// season
			if (!regionList.isEmpty()) {

				Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prod_id "
						+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
						+ "WHERE pr.prod_id IN(" + products + ") " 
						+ "AND pr.reg_id IN (" + regions + ") " 
						+ "AND p.season IN (" + seasons + ")");

				resultSearch = query.getResultList();

				Iterator it = resultSearch.iterator();
				while(it.hasNext()) {
					Object[] line = (Object[]) it.next();
					ProductDetail pd= new ProductDetail();
					pd.setCoordinates((String) line[0]);
					pd.setReg_id((int) line[1]);
					pd.setRegionName((String) line[2]);
					pd.setProd_id((int) line[3]);
					pd.setName((String) line[4]);
					list.add(pd);
				}
							
				em.close();
			} else { // regions is empty only search by product id and season

				Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prod_id "
						+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
				        + "WHERE pr.prod_id IN(" + products + ") "
				        + "AND p.season IN (" + seasons + ")");
				
//				resultSearch = (List<ProductDetail>) query.getResultList();
				resultSearch = query.getResultList();

				Iterator it = resultSearch.iterator();
				while(it.hasNext()) {
					Object[] line = (Object[]) it.next();
					ProductDetail pd= new ProductDetail();
					pd.setCoordinates((String) line[0]);
					pd.setReg_id((int) line[1]);
					pd.setRegionName((String) line[2]);
					pd.setProd_id((int) line[3]);
					pd.setName((String) line[4]);
					list.add(pd);
				}
				em.close();
			}
			// if seasonList is empty the check if region is not empty
		} else if (!regionList.isEmpty()) {
			// then search by product_id and region id
			Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
					+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prod_id "
					+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
						  + "WHERE pr.prod_id IN (" + products + ") " 
			              + "AND pr.reg_id IN (" + regions + ")");
//			resultSearch = (List<ProductDetail>) query.getResultList();
			resultSearch = query.getResultList();
			Iterator it = resultSearch.iterator();
			while(it.hasNext()) {
				Object[] line = (Object[]) it.next();
				ProductDetail pd= new ProductDetail();
				pd.setCoordinates((String) line[0]);
				pd.setReg_id((int) line[1]);
				pd.setRegionName((String) line[2]);
				pd.setProd_id((int) line[3]);
				pd.setName((String) line[4]);
				list.add(pd);
			}
			
			em.close();

		} else if (regionList.isEmpty() && seasonList.isEmpty())
		// season is empty and region is empty then search by product id
		{
			Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
					+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prod_id "
					+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
					+ "WHERE pr.prod_id IN(" + products + ") ");
			resultSearch = query.getResultList();
			Iterator it = resultSearch.iterator();
			while(it.hasNext()) {
				Object[] line = (Object[]) it.next();
				ProductDetail pd= new ProductDetail();
				pd.setCoordinates((String) line[0]);
				pd.setReg_id((int) line[1]);
				pd.setRegionName((String) line[2]);
				pd.setProd_id((int) line[3]);
				pd.setName((String) line[4]);
				list.add(pd);
			}
			em.close();
		}

		return list;
	}

}
