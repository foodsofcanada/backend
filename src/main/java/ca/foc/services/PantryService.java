package ca.foc.services;

import ca.foc.dao.FavProductsRepository;
import ca.foc.dao.PantryProductRegionRepository;
import ca.foc.dao.PantryRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.domain.FavouriteProductsIdentity;
import ca.foc.domain.Pantry;
import ca.foc.domain.PantryProductRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
/**
 * Pantry service
 * @author Claudia Rivera, Mariia Voronina
 * 
 *
 */

@Service
public class PantryService {
   
	@Autowired
    EntityManagerFactory emf;
	@Autowired
	PantryRepository pantryRepository;
	@Autowired
	PantryProductRegionRepository pantryProductRegionRepository;
	@Autowired
	FavProductsRepository favProductsRepository;

	/*Member create a Pantry attributes: owner(email), imagePath, description and Pantry*/
    public Pantry createPantry(Pantry pantry) {    	
    	
    	Pantry newpantry= pantryRepository.save(pantry);
		return newpantry;
    	
    }
    
    /*Member delete a pantry*/
    public void deletePantry(int pantryId) {
    	pantryProductRegionRepository.deleteByPantryId(pantryId);
    	pantryRepository.deleteById(pantryId);
    }
    /**
     * member edit a pantry: name,description and imgPath*
     * @param pantryId
     * @param newPantry
     * @return a Pantry object
     */
    
    public Pantry editPantry(Integer pantryId, Pantry newPantry) {
    	Optional<Pantry>p = pantryRepository.findById(pantryId);
    	Pantry pantryUpdated = p.get();
//    	
//    	if(newPantry.getPantryId()!=null) {
//    		pantryUpdated.setPantryId(pantryUpdated.getPantryId());//pantryId cannot be changed
//    	}
//
//    	if(!newPantry.getEmail().equals("")) {
//    		pantryUpdated.setEmail(pantryUpdated.getEmail());// Pantry email cannot be changed
//    	}
    	
    	if(!newPantry.getDescription().equals("")) {
    		pantryUpdated.setDescription(newPantry.getDescription());
    	}
    	if(!newPantry.getImgPath().equals("")) {
    	pantryUpdated.setImgPath(newPantry.getImgPath());
    	}
    	if(!newPantry.getPantryName().equals("")) {
    	pantryUpdated.setPantryName(newPantry.getPantryName());
    	}
    	return pantryRepository.save(pantryUpdated);
    }
    
    
    /**
    /* addProductToPantry.-Method used to a member Add a product in their pantry 
     * @return a boolean true if product was added or false otherwise
     */
    public boolean addProductToPantry(int pantryId, int productId, int regionId, String coordinate) {
        PantryProductRegion ppr = new PantryProductRegion();
        boolean save= false;
        //find if it this exists
        Optional<PantryProductRegion> pprO=pantryProductRegionRepository.findByPantryIdAndProductIdAndRegionId(pantryId, productId, regionId);
        System.out.println(pprO.toString());
        if (!pprO.isPresent()) {
        ppr.setPantryId(pantryId);
        ppr.setProductId(productId);
        ppr.setRegionId(regionId);
        ppr.setCoordinate(coordinate);
        pantryProductRegionRepository.save(ppr);
        save = true;
        }
     
        return save;
    }

    //Delete a product in a pantry
    public boolean deleteProductFromPantry(int pantryId, int productId, int regionId) {
       
    	 PantryProductRegion ppr = new PantryProductRegion();
          boolean deleted= false;
        // find if it this exists
        Optional<PantryProductRegion> pprO=pantryProductRegionRepository.findByPantryIdAndProductIdAndRegionId(pantryId, productId, regionId);
         if (pprO.isPresent()) {
        	 
          pantryProductRegionRepository.deleteByPantryIdAndProductIdAndRegionId(pantryId, productId, regionId);
          deleted = true;
         }
         
        return deleted;
    }

    /*Get all Pantries in Pantries table for a user identified by email*/
    public List<Pantry> getUserPantries(String email) {
    	
    	return pantryRepository.findByEmail(email);
        
    }
    
    /*Get Pantry Info*/

    public Optional<Pantry> getPantryInfo(String email, int pantryId) {
    	return pantryRepository.findByEmailAndPantryId(email, pantryId);
    }
    
    //Display all products in a pantry
    public List<ProductDetail> getProductsInPantry(String email,int pantryId) {
    	String memberId= email;
    	//List<ProductDetail> resultSearch= null;
    	List<ProductDetail> list = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        Query query1 = em.createQuery("SELECT ppr.regionId, ppr.productId, p.name, ppr.coordinate "
                 + " FROM PantryProductRegion ppr "
                 + " INNER JOIN Product p on p.productId = ppr.productId " 
                 + " WHERE ppr.pantryId ="+pantryId);
       // Query query2 = em.createQuery("SELECT rr.regionName FROM Region rr INNER JOIN PantryProductRegion ppr ON rr.regionId = ppr.regionId");
        
//        List<String> l = query2.getResultList();
//        String regName = "";
//        if (l.size() != 0) {
//        	 regName = l.get(0);
//        }
       
        List<ProductDetail> resultSearch = (List<ProductDetail>) query1.getResultList();
        Iterator it = resultSearch.iterator();
		while (it.hasNext()) {
			
			Object[] line = (Object[]) it.next();
			ProductDetail pd = new ProductDetail();
			pd.setRegionId((int) line[0]);
			pd.setProductId((int) line[1]);
			pd.setName((String) line[2]);
			pd.setCoordinates((String) line[3]);
			
			Query query2 = em.createQuery("SELECT DISTINCT rr.regionName FROM Region rr INNER JOIN PantryProductRegion ppr ON rr.regionId = ppr.regionId where rr.regionId= "+pd.getRegionId());
			String regName = (String) query2.getSingleResult();
			pd.setRegionName(regName);
						
			list.add(pd);
		}
        // check if products are favourites
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