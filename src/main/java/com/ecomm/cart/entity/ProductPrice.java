package com.ecomm.cart.entity;

import javax.persistence.*;

@Entity
@Table(name="product_price")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="productid")
    private int productId;

    @Column(name= "price")
    private float price;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "productId=" + productId +
                ", price=" + price +
                '}';
    }
}
