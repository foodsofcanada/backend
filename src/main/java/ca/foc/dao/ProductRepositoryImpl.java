package ca.foc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import ca.foc.domain.*;


public class ProductRepositoryImpl implements ProductRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

//	@Override
//	public List<String> getAllProductsInRegion(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<String> getAllProductsInRegion(int id) {
		Query query = em.createNamedQuery("findByRegId");
		query.setParameter(1, id);
		return query.getResultList();
	}

//	public List<String> getAllProductsInRegion(int id) {
//		Query query = em.createNamedStoredProcedureQuery("getAllProductsInRegion");
//		query.setParameter("p_reg_id", id);
//		return query.getResultList();
//	}
}

