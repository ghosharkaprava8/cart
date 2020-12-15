package com.ecomm.cart.entity;

import javax.persistence.*;

@Entity
@Table(name="discount")
public class Discount {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int productid;

    @Column(name="discount")
    private float discount;

    public int getId() {
        return productid;
    }

    public void setId(int productid) {
        this.productid = productid;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "productid=" + productid +
                ", discount=" + discount +
                '}';
    }
}

