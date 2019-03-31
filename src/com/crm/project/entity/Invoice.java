package com.crm.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {
	
	@Id
	@Column(name="idinvoice")	
	private String idinvoice;
	
	@Column(name="custid")	
	private String custid;
	
	@Column(name="productid")	
	private String productid;
	
	@Column(name="amount")	
	private double amount;
	
	@Column(name="duedays")	
	private int duedays;
	
	@Column(name="interest")	
	private int interest;
	
	@Column(name="ordid")	
	private String ordid;
	
	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}

	public String getIdinvoice() {
		return idinvoice;
	}

	public void setIdinvoice(String idinvoice) {
		this.idinvoice = idinvoice;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDuedays() {
		return duedays;
	}

	public void setDuedays(int duedays) {
		this.duedays = duedays;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public String getSexeuserid() {
		return sexeuserid;
	}

	public void setSexeuserid(String sexeuserid) {
		this.sexeuserid = sexeuserid;
	}

	public String getAcuser() {
		return acuser;
	}

	public void setAcuser(String acuser) {
		this.acuser = acuser;
	}

	@Column(name="sexeuserid")	
	private String sexeuserid;
	
	@Column(name="acuser")	
	private String acuser;
	
	
}
