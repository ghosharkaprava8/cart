package com.ecomm.cart.dao;

import com.ecomm.cart.entity.ProductPrice;

import java.util.List;

public interface productPriceDAO {

    public List<ProductPrice> findAll();

    public ProductPrice findById(int theId);

    public void save(ProductPrice theProductPrice);

    public void deleteById(int theId);
}
