package com.ecomm.cart.service;

import com.ecomm.cart.dao.discountDAO;
import com.ecomm.cart.entity.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DiscountServiceImpl implements DiscountService{

    private discountDAO discountDao;

    @Autowired
    public DiscountServiceImpl(@Qualifier("discountDAOJpaImpl") discountDAO thediscountDao) {
        discountDao = thediscountDao;
    }


    @Override
    @Transactional
    public List<Discount> findAll() {
        return discountDao.findAll();
    }

    @Override
    @Transactional
    public Discount findById(int theId) {
        return discountDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Discount theDiscount) {
        discountDao.save(theDiscount);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        discountDao.deleteById(theId);

    }


}
