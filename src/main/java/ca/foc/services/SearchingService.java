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

import ca.foc.dao.FavProductsRepository;
import ca.foc.dao.ProductRegionRepository;
import ca.foc.dao.ProductRepository;
import ca.foc.dao.TopTenSearchedRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.dom.SearchObject;
import ca.foc.domain.FavouriteProductsIdentity;
import ca.foc.domain.Product;
import ca.foc.domain.ProductRegion;
import ca.foc.domain.TopTenSearched;
import ca.foc.domain.TopTenSearchedIdentity;

/**
 * Service class. Implement Searching by filters
 * 
 * @author
 * 
 *         Claudia R. Receive a SearchObject object with 3 arrayList one for
 *         each filter. Then filters are passed to a String and inserted in each
 *         query. Returns a list with ProductDetail objects that fit the search
 *         The data returned is Coordinates, regionId, regionName,productId name.
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
	FavProductsRepository favProductsRepository;
	@Autowired
	EntityManagerFactory emf;
	

	public List<ProductDetail> SerchingResult(SearchObject so) {

		String memberId= so.getEmail();		
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
					Query query = em.createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
									+ "INNER JOIN ProductRegion pr on p.productId = pr.productId "
									+ "INNER JOIN Region r ON pr.regionId = r.regionId "
									+ "WHERE pr.productId IN(" + products + ") " 
									+ "AND pr.regionId IN (" + regions + ") " 
									+ "AND p.season IN (" + seasons + ")");

					resultSearch = query.getResultList();

				} else 
				    { // regions is empty only search by product id and season
					Query query = em.createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
									+ "INNER JOIN ProductRegion pr on p.productId = pr.productId "
									+ "INNER JOIN Region r ON pr.regionId = r.regionId "
									+ "WHERE pr.productId IN(" + products + ") " 
									+ "AND p.season IN (" + seasons + ")");
					resultSearch = query.getResultList();

				    }
				// if seasonList is empty the check if region is not empty
			} else if (!regionList.isEmpty()) {
				// then search by product_id and region id
				Query query = em.createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.productId = pr.productId "
						+ "INNER JOIN Region r ON pr.regionId = r.regionId " 
						+ "WHERE pr.productId IN (" + products + ") "
						+ "AND pr.regionId IN (" + regions + ")");

				resultSearch = query.getResultList();
				
			} else if (regionList.isEmpty() && seasonList.isEmpty())
			// season is empty and region is empty then search by product id
			{
				Query query = em.createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.productId = pr.productId "
						+ "INNER JOIN Region r ON pr.regionId = r.regionId " 
						+ "WHERE pr.productId IN(" + products + ") ");
				resultSearch = query.getResultList();

			}
			// product list is empty
		} 
		else 
			{
			
				if (!seasonList.isEmpty()) {
					// Check if regions is not empty. Then search by region id and  season
					if (!regionList.isEmpty()) {

						Query query = em .createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
								                      + "INNER JOIN ProductRegion pr on p.productId = pr.productId "
									                  + "INNER JOIN Region r ON pr.regionId = r.regionId "
									                  + "WHERE pr.regionId IN (" + regions + ") " 
									                  + "AND p.season IN (" + seasons + ")");

						resultSearch = query.getResultList();

				       } 
					else 
					{ // regions is empty only search by  season
					    Query query = em.createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
									+ "INNER JOIN ProductRegion pr on p.productId = pr.productId "
									+ "INNER JOIN Region r ON pr.regionId = r.regionId " 
									+ "WHERE p.season IN (" + seasons + ")");
					     resultSearch = query.getResultList();

				}
				// if seasonList is empty the check if region is not empty
			} else if (!regionList.isEmpty()) {
				// then search by  region id
				Query query = em.createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.productId = pr.productId "
						+ "INNER JOIN Region r ON pr.regionId = r.regionId "
						+ "WHERE pr.regionId IN (" + regions + ")");

				resultSearch = query.getResultList();


			} else //if (regionList.isEmpty() && seasonList.isEmpty())
			// season is empty and region is empty then search by product id
			{
				Query query = em.createQuery("SELECT pr.coordinate, r.regionId, r.regionName, p.productId, p.name from Product p "
						+ "INNER JOIN ProductRegion pr on p.productId = pr.productId "
						+ "INNER JOIN Region r ON pr.regionId = r.regionId " );
				resultSearch = query.getResultList();

			}

		}
		Iterator it = resultSearch.iterator();
		
		//when a member is not signed
					
		 while (it.hasNext()) {
			Object[] line = (Object[]) it.next();
			ProductDetail pd = new ProductDetail();
			pd.setCoordinates((String) line[0]);
			pd.setRegionId((int) line[1]);
			pd.setRegionName((String) line[2]);
			pd.setProductId((int) line[3]);
			pd.setName((String) line[4]);
			list.add(pd);
			
		/*to fill top ten searched table */	
		 int uniqueid= pd.getProductId();
		 int regionid= pd.getRegionId();
		    TopTenSearched top = new TopTenSearched();
		   
		  if (topTenSearchedRepository.existsById(new TopTenSearchedIdentity(uniqueid,regionid))) {
		    	
		    	Optional<TopTenSearched> t = (topTenSearchedRepository.findById(new TopTenSearchedIdentity(uniqueid,regionid)));
		    	top=t.get();
		    	
		    	int counter=top.getSearchCounter()+1;
		    	top.setSearchCounter(counter);
		    	topTenSearchedRepository.save(top);
		  }
		  else {
			  TopTenSearchedIdentity topId= new TopTenSearchedIdentity(pd.getProductId(),pd.getRegionId());
			  top.setSearchCounter(1);
		      top.setCoordinate(pd.getCoordinates());	    	
		      top.setTopTenSearchedIdentity(topId);
		      top.setProductName(pd.getName());
		      top.setRegionName(pd.getRegionName());
		    	
		      topTenSearchedRepository.save(top);
		    }
		  

		}
		
	//member is signed
		 if (!memberId.isEmpty()) {
			 
			 System.out.println("member is here: "+ memberId);
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
