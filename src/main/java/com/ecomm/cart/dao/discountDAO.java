package com.ecomm.cart.dao;

import com.ecomm.cart.entity.Discount;
import com.ecomm.cart.entity.Product;

import java.util.List;

public interface discountDAO {

    public List<Discount> findAll();

    public Discount findById(int theId);

    public void save(Discount theDiscount);

    public void deleteById(int theId);

}
