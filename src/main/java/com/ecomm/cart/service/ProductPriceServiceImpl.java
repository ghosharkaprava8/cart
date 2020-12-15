package com.ecomm.cart.service;

import com.ecomm.cart.dao.ProductDAO;
import com.ecomm.cart.dao.productPriceDAO;
import com.ecomm.cart.entity.Product;
import com.ecomm.cart.entity.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.management.Query;
import java.util.List;

public class ProductPriceServiceImpl implements ProductPriceService {

    private productPriceDAO productPriceDao;

    @Autowired
    public ProductPriceServiceImpl(@Qualifier("ProductPriceDAOJpaImpl") productPriceDAO theproductPriceDAO) {
        productPriceDao = theproductPriceDAO;
    }

    @Override
    public List<ProductPrice> findAll() {
        return productPriceDao.findAll();

    }

    @Override
    public ProductPrice findById(int theId) {

        return productPriceDao.findById(theId);
    }

    @Override
    public void save(ProductPrice theProductPrice) {
        productPriceDao.save(theProductPrice);


    }

    @Override
    public void deleteById(int theId) {

        productPriceDao.deleteById(theId);
    }
}
