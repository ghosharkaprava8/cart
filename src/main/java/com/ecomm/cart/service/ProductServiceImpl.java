package com.ecomm.cart.service;

import java.util.List;

import com.ecomm.cart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.cart.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(@Qualifier("ProductDAOJpaImpl") ProductDAO theProductDAO) {
		productDAO = theProductDAO;
	}
	
	@Override
	@Transactional
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	@Transactional
	public Product findById(int theId) {
		return productDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Product theProduct) {
		productDAO.save(theProduct);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		productDAO.deleteById(theId);
	}

}






