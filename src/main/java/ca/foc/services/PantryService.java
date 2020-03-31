package ca.foc.services;

import ca.foc.dao.PantryRepository;
import ca.foc.domain.Pantry;
import ca.foc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


@Service
public class PantryService {
    @Autowired
    EntityManagerFactory emf;

//    public boolean createPantry(int pantry_id, String email, String description, String name) {
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("insert into (pantry_id, owner, name,description)" +
//                "values (?,?,?,?)");
//        query.setParameter(1,pantry_id);
//        query.setParameter(2,email);
//        query.setParameter(3,name);
//        query.setParameter(4,description);
//        query.executeUpdate();
//
//        return false;
//    }


    public boolean addProductToPantry(int pantry_id, int prod_id, int reg_id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("insert into PantryProductRegion " +
                "ppr" +
                " (pantry_id, prod_id, reg_id) values (?,?,?)");
        query.setParameter(1,pantry_id);
        query.setParameter(2,prod_id);
        query.setParameter(3,reg_id);
        return false;
    }


    public boolean deleteProductFromPantry(int pantry_id, int prod_id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("delete from PantryProductRegion ppr " +
                "where  ppr.pantry_id="+pantry_id+" " +
                "and ppr.prod_id="+prod_id);
        return false;
    }


    public boolean deletePantry(int pantry_id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("delete from Pantry p " +
                "where p.pantry_id="+pantry_id);
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