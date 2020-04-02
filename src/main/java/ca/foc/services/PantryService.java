package ca.foc.services;

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

	/*Member create a Pantry attributes: owner(email), imagePath, description and Pantry*/
    public void createPantry(Pantry pantry) {    	
    	pantryRepository.save(pantry);
    	
    }
    
    /*Member delete a pantry*/
    public void deletePantry(int pantry_id) {
    	pantryRepository.deleteById(pantry_id);
    }

    /*member edit a pantry: name,description and imgPath*/
    public Pantry editPantry(int pantryId, Pantry newPantry) {
    	Optional<Pantry>p = pantryRepository.findById(pantryId);
    	Pantry pantryUpdated = p.get();
    	pantryUpdated.setDescription(newPantry.getDescription());
    	pantryUpdated.setImgPath(newPantry.getImgPath());
    	pantryUpdated.setPantryName(newPantry.getPantryName());
    	
    	return pantryRepository.save(pantryUpdated);
    }

    public void addProductToPantry(int pantryId, int productId, int regionId) {
        PantryProductRegion ppr = new PantryProductRegion();
//        ppr.setPantryId(pantryId);
//        ppr.setProductId(productId);
//        ppr.setRegionId(regionId);
    	
    	EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("insert into PantryProductRegion " +
                " (pantryId, productId, regionId) values (?,?,?)");
        query.setParameter(1,pantryId);
        query.setParameter(2,productId);
        query.setParameter(3,regionId);
        //return false;
    }


    public boolean deleteProductFromPantry(int pantry_id, int prod_id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("delete from PantryProductRegion ppr " +
                "where  ppr.pantry_id="+pantry_id+" " +
                "and ppr.prod_id="+prod_id);
        return false;
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