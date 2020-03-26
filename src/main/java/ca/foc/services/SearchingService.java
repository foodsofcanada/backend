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

import ca.foc.dao.ProductRegionRepository;
import ca.foc.dao.ProductRepository;
import ca.foc.dao.TopTenSearchedRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.dom.SearchObject;
import ca.foc.domain.Product;
import ca.foc.domain.ProductRegion;
import ca.foc.domain.TopTenSearched;

/**
 * Service class. Implement Searching by filters
 * 
 * @author
 * 
 *         Claudia R. Receive a SearchObject object with 3 arrayList one for
 *         each filter. Then filters are passed to a String and inserted in each
 *         query. Returns a list with ProductDetail objects that fit the search
 *         The data returned is Coordinates, reg_id, regionName,prod_id name
 * 
 *         Date:March-15-2020
 *         Modified: product list is empty, added.
 *         Date: March 18-2020
 * 
 *
 */
@Service
public class SearchingService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	TopTenSearchedRepository topTenSearchedRepository;
	@Autowired
	ProductRegionRepository productRegionRepository;
	@Autowired
	EntityManagerFactory emf;

	public List<ProductDetail> SerchingResult(SearchObject so) {

		ArrayList<Integer> productList = so.getProductsSearched();
		ArrayList<String> seasonList = so.getSeasonSearched();
		ArrayList<Integer> regionList = so.getRegionSearched();

		EntityManager em = emf.createEntityManager();
		List<ProductDetail> resultSearch = null;
		List<ProductDetail> list = new ArrayList<ProductDetail>();

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
       if(!productList.isEmpty()) {
		for (int i = 0; i < productList.size(); i++) {
			products += productList.get(i) + ", ";
		}
		if (products.length() > 0)
			products = products.substring(0, products.length() - 2);
		
		/*Updated Counter. Counts every time a product is selected in the search sidebar */
		
		for (int i=0; i<productList.size();i++) {
		int uniqueid= productList.get(i);
		    TopTenSearched top = new TopTenSearched();
		 System.out.println(top.toString());
		 System.out.println (topTenSearchedRepository.existsById(uniqueid));
		 if (topTenSearchedRepository.existsById(uniqueid)) {
		    	Optional<TopTenSearched> t = (topTenSearchedRepository.findById(uniqueid));
		    	top=t.get();
		    	
		    	int counter=top.getSearch_counter()+1;
		    	top.setSearch_counter(counter);
		    	topTenSearchedRepository.save(top);
		    }
		    else {
		    	System.out.println("Prodid: "+ uniqueid);
		    
		    	Optional<Product>  pr= productRepository.findById(uniqueid);
		    	//System.out.println(productRegionRepository.existsByProdId(uniqueid));
		    	//System.out.println(pr.toString());
		    	Product r= pr.get();
		    	System.out.println(r.toString());
		    	top.setSearch_counter(1);
		    //op.setCoordinate(r.getCoordinate());
		    	top.setProduct_id( r.getProd_id());
		    	topTenSearchedRepository.save(top);
		    }
		}
       }
		// Build a string with regions id filters
		if (!regionList.isEmpty()) {
			for (int i = 0; i < regionList.size(); i++) {
				regions += regionList.get(i) + ", ";
			}
			if (regions.length() > 0)
				regions = regions.substring(0, regions.length() - 2);
		}

		// productList  is not empty
		if (!productList.isEmpty()) {
			// check if seasons is not empty
			if (!seasonList.isEmpty()) {
				// Check if regions is not empty. Then search by product id, region id and season
				if (!regionList.isEmpty()) {
					Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
									+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prodId "
									+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
									+ "WHERE pr.prodId IN(" + products + ") " 
									+ "AND pr.reg_id IN (" + regions + ") " 
									+ "AND p.season IN (" + seasons + ")");

					resultSearch = query.getResultList();

				} else 
				    { // regions is empty only search by product id and season
					Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
									+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prodId "
									+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
									+ "WHERE pr.prodId IN(" + products + ") " + "AND p.season IN (" + seasons + ")");
					resultSearch = query.getResultList();

				    }
				// if seasonList is empty the check if region is not empty
			} else if (!regionList.isEmpty()) {
				// then search by product_id and region id
				Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.prod_id =pr.prodId "
						+ "INNER JOIN Region r ON pr.reg_id = r.reg_id " 
						+ "WHERE pr.prod_id IN (" + products + ") "
						+ "AND pr.prodId IN (" + regions + ")");

				resultSearch = query.getResultList();
			
			} else if (regionList.isEmpty() && seasonList.isEmpty())
			// season is empty and region is empty then search by product id
			{
				Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prodId "
						+ "INNER JOIN Region r ON pr.reg_id = r.reg_id " 
						+ "WHERE pr.prodId IN(" + products + ") ");
				resultSearch = query.getResultList();

			}
			// product list is empty
		} else {
			
			if (!seasonList.isEmpty()) {
				// Check if regions is not empty. Then search by region id and  season
				if (!regionList.isEmpty()) {

					Query query = em .createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
									+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prodId "
									+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
									+ "WHERE pr.reg_id IN (" + regions + ") " 
									+ "AND p.season IN (" + seasons + ")");

					resultSearch = query.getResultList();

				} else { // regions is empty only search by  season

					Query query = em
							.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
									+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prodId "
									+ "INNER JOIN Region r ON pr.reg_id = r.reg_id " 
									+ "WHERE p.season IN (" + seasons + ")");
					resultSearch = query.getResultList();

				}
				// if seasonList is empty the check if region is not empty
			} else if (!regionList.isEmpty()) {
				// then search by  region id
				Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prodId "
						+ "INNER JOIN Region r ON pr.reg_id = r.reg_id "
						+ "WHERE pr.reg_id IN (" + regions + ")");

				resultSearch = query.getResultList();


			} else //if (regionList.isEmpty() && seasonList.isEmpty())
			// season is empty and region is empty then search by product id
			{
				Query query = em.createQuery("SELECT pr.coordinate, r.reg_id, r.name, p.prod_id, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.prod_id = pr.prod_id "
						+ "INNER JOIN Region r ON pr.reg_id = r.reg_id " );
				resultSearch = query.getResultList();

			}

		}
		Iterator it = resultSearch.iterator();
		while (it.hasNext()) {
			Object[] line = (Object[]) it.next();
			ProductDetail pd = new ProductDetail();
			pd.setCoordinates((String) line[0]);
			pd.setReg_id((int) line[1]);
			pd.setRegionName((String) line[2]);
			pd.setProd_id((int) line[3]);
			pd.setName((String) line[4]);
			list.add(pd);
			
		/*to fill top ten searched table */	
//		 int uniqueid= pd.getProd_id();
//		    TopTenSearched top = new TopTenSearched();
//		 
//		    if (topTenSearchedRepository.existsById(uniqueid)) {
//		    	Optional<TopTenSearched> t = (topTenSearchedRepository.findById(uniqueid));
//		    	top=t.get();
//		    	
//		    	int counter=top.getSearch_counter()+1;
//		    	top.setSearch_counter(counter);
//		    	topTenSearchedRepository.save(top);
//		    }
//		    else {
//		    	top.setSearch_counter(1);
//		    	top.setCoordinate(pd.getCoordinates());
//		    	top.setProduct_id(pd.getProd_id());
//		    	topTenSearchedRepository.save(top);
//		    }
		}
		em.close();

		return list;
	}

}
