package com.ecomm.cart.dao;

import com.ecomm.cart.entity.Product;
import com.ecomm.cart.entity.ProductPrice;
import javax.persistence.Query;

import jdk.nashorn.internal.ir.FunctionNode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class productPriceDAOJpaImpl implements productPriceDAO{

    private EntityManager entityManager;

    @Autowired
    public productPriceDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<ProductPrice> findAll() {

        Query theQuery = entityManager.createQuery("from product_price");

        List<ProductPrice> productPrices= theQuery.getResultList();

        return productPrices;
    }

    @Override
    public ProductPrice findById(int theId) {
        ProductPrice theProductprice =
                entityManager.find(ProductPrice.class, theId);

        return theProductprice;
    }

    @Override
    public void save(ProductPrice theProductPrice) {

        ProductPrice dbProductPrice = entityManager.merge(theProductPrice);

        theProductPrice.setProductId(dbProductPrice.getProductId());

    }

    @Override
    public void deleteById(int theId) {

    }
}
