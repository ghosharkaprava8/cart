package com.ecomm.cart.dao;

import java.util.List;

import com.ecomm.cart.entity.Product;

public interface ProductDAO {

	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public void save(Product theProduct);
	
	public void deleteById(int theId);
	
}
