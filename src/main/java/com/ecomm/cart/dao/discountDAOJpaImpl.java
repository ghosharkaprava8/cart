package com.ecomm.cart.dao;

import com.ecomm.cart.entity.Discount;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import java.util.List;

public class discountDAOJpaImpl implements discountDAO{

    private EntityManager entityManager;

    @Autowired
    public discountDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Discount> findAll() {
        // create a query
        Query theQuery =
                entityManager.createQuery("from Discount");

        // execute query and get result list
        List<Discount> discounts = theQuery.getResultList();

        // return the results
        return discounts;
    }

    @Override
    public Discount findById(int theId) {

        Discount discount= entityManager.find(Discount.class,theId);

        return discount;
    }

    @Override
    public void save(Discount theDiscount) {



    }

    @Override
    public void deleteById(int theId) {

    }
}
