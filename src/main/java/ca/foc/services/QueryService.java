package ca.foc.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ca.foc.dao.ProductRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.domain.Product;

import java.util.List;
import java.util.Optional;

@Service
public class QueryService implements IQueryService {

    @Autowired
    ProductRepository productrepository;
   

    @Autowired
    EntityManagerFactory emf;

//    @Override
//    public List<ProductDetail> JPQLQuery(int reg)
//    {
//        EntityManager em = emf.createEntityManager();
//        //em.getTransaction().begin( );
//
//        Query query = em.createQuery("Select" +" p from Product p " +
//        "inner join ProductRegion pr on p.prod_id = pr.prod_id where reg_id ="+reg);
//        @SuppressWarnings("unchecked")
//        List<ProductDetail> list =(List<ProductDetail>)query.getResultList();
//        //System.out.println("Student Name :");
//        em.close();
//
//        return list;
//
//    }
  
  /*  public List<Product> productAllData()
    {
        return productrepository.findAll();
    }
    */
    @Override
	public List<ProductDetail> getAllProductsInRegion(int id) {
		 
		 EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("Select" +" p from Product p " +
	                "inner join ProductRegion pr on p.prod_id=pr.prod_id where pr.reg_id ="+id);
	        @SuppressWarnings("unchecked")
	        List<ProductDetail> list =(List<ProductDetail>)query.getResultList();
	        //System.out.println("Student Name :");
	        em.close();

	        return list;
	}

    /*Method to select all information of a product by id*/
	@Override
	public List<Product> getProductInfo(int id) {
		
		 EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("Select" +" name, description,season, "+
					"age, img_path,shelf_life,danger,growth_phases,scientific_name,"+
					"history, cooking_use,preservation, fun_fact, origin_country "+"from Product p " +
		                " where prod_id ="+id);
		        @SuppressWarnings("unchecked")
		        List<Product> list =(List<Product>)query.getResultList();
		        //System.out.println("Student Name :");
		        em.close();

		        return list;
	}

}