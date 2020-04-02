package ca.foc.services;

import ca.foc.dao.PantryProductRegionRepository;
import ca.foc.dao.PantryRepository;
import ca.foc.domain.Pantry;
import ca.foc.domain.PantryProductRegion;
import ca.foc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Service
public class PantryService {
   
	@Autowired
    EntityManagerFactory emf;
	@Autowired
	PantryRepository pantryRepository;
	@Autowired
	PantryProductRegionRepository pantryProductRegionRepository;

	/*Member create a Pantry attributes: owner(email), imagePath, description and Pantry*/
    public void createPantry(Pantry pantry) {    	
    	pantryRepository.save(pantry);
    	
    }
    
    /*Member delete a pantry*/
    public void deletePantry(Long pantry_id) {
    	pantryRepository.deleteById(pantry_id);
    }

    /*member edit a pantry: name,description and imgPath*/
    public Pantry editPantry(Long pantryId, Pantry newPantry) {
    	Optional<Pantry>p = pantryRepository.findById(pantryId);
    	Pantry pantryUpdated = p.get();
    	pantryUpdated.setDescription(newPantry.getDescription());
    	pantryUpdated.setImgPath(newPantry.getImgPath());
    	pantryUpdated.setPantryName(newPantry.getPantryName());
    	
    	return pantryRepository.save(pantryUpdated);
    }

    public boolean addProductToPantry(int pantryId, int productId, int regionId) {
        PantryProductRegion ppr = new PantryProductRegion();
        boolean save= false;
        //find if it this exists
        Optional<PantryProductRegion> pprO=pantryProductRegionRepository.findByPantryIdAndProductIdAndRegionId(pantryId, productId, regionId);
        if (!pprO.isPresent()) {
        ppr.setPantryId(pantryId);
        ppr.setProductId(productId);
        ppr.setRegionId(regionId);
        pantryProductRegionRepository.save(ppr);
        save = true;
        }
     
//    	EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("insert into PantryProductRegion " +
//                " (pantryId, productId, regionId) values (?,?,?)");
//        query.setParameter(1,pantryId);
//        query.setParameter(2,productId);
//        query.setParameter(3,regionId);
        return save;
    }


    public boolean deleteProductFromPantry(int pantryId, int productId, int regionId) {
       
    	 PantryProductRegion ppr = new PantryProductRegion();
          boolean deleted= false;
        // find if it this exists
        Optional<PantryProductRegion> pprO=pantryProductRegionRepository.findByPantryIdAndProductIdAndRegionId(pantryId, productId, regionId);
         if (!pprO.isPresent()) {
         pantryProductRegionRepository.deleteByPantryIdAndProductIdAndRegionId(pantryId, productId, regionId);
        deleted = true;
         }
         
        return deleted;
    }


   


    public List<Pantry> getUserPantries(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select pantry_id, owner,name,description" +
                "from Pantry p where email="+email);
        List<Pantry> pantry = (List<Pantry>) query.getResultList();
        return pantry;
    }


    public List<Product> getProductsInPantry(int pantry_id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select" +" p.name " +
                "from PantryProductRegion ppr " +
                "inner join Product p on p.prod_id=ppr.prod_id " +
                "where ppr.pantry_id ="+pantry_id);
        List<Product> products = (List<Product>) query.getResultList();
        return products;
    }

}