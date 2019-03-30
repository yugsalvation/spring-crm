package com.crm.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="idproduct")	
	private String idproduct;
	
	@Column(name="productname")	
	private String productname;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name="tax")	
	private double tax;
	
	@Column(name="interest")	
	private double interest;
	
	@Column(name="amount")	
	private double amount;
	
	public String getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	
}
