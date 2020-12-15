package com.ecomm.cart.service;

import com.ecomm.cart.entity.Product;
import com.ecomm.cart.entity.ProductPrice;

import java.util.List;

public interface ProductPriceService {

    public List<ProductPrice> findAll();

    public ProductPrice findById(int theId);

    public void save(ProductPrice theProduct);

    public void deleteById(int theId);

}
