package com.ecomm.cart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecomm.cart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOJpaImpl implements ProductDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ProductDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Product> findAll() {

		// create a query
		Query theQuery = 
				entityManager.createQuery("from Products");
		
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
		
		// return the results		
		return products;
	}

	@Override
	public Product findById(int theId) {

		// get product
		Product theProduct =
				entityManager.find(Product.class, theId);
		
		// return product
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {

		// save or update the product
		Product dbProduct = entityManager.merge(theProduct);
		
		// update with id from db ... so we can get generated id for save/insert
		theProduct.setId(dbProduct.getId());
		
	}

	@Override
	public void deleteById(int theId) {

		// delete object with primary key
		Query theQuery = entityManager.createQuery(
							"delete from product where id=:productId");
		
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
	}

}










