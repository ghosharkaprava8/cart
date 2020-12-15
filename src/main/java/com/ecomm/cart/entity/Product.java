package com.ecomm.cart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productid")
	private int productid;
	
	@Column(name="name")
	private String productName;
	
	@Column(name="description")
	private String productDescription;
	
	@Column(name="category")
	private String category;
	
		
	// define constructors
	
	public Product() {
		
	}

	public Product(String productName, String productDescription, String category) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.category= category;

	}

	public int getId() {
		return productid;
	}

	public void setId(int productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// define tostring

	@Override
	public String toString() {
		return "Product{" +
				"id=" + productid +
				", productName='" + productName + '\'' +
				", productDescription='" + productDescription + '\'' +
				", category='" + category + '\'' +
				'}';
	}

}











