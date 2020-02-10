package com.capstoneproject.FoodOfCanada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstoneproject.FoodOfCanada.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Procedure(name = "getProductInfo")
	List<Product> getProductInfo(@Param("id") long inParam1);
	
}