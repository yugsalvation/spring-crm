package com.crm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name="idorder")	
	private String idorder;
	
	@Column(name="custoid")	
	private String custoid;
	
	@Column(name="pid")	
	private String pid;
	
	@Column(name="amount")	
	private double amount;
	
	@Column(name="billdate")	
	private Date billdate;

	@Column(name="duedate")	
	private Date duedate;

	@Column(name="payment")	
	private String payment;
	


	@Column(name="referencenumber")	
	private String referencenumber;
	
	@Column(name="accountusers")	
	private String accountusers;
	
	@Column(name="interest")	
	private int interest;
	
	@Column(name="duedays")	
	private int duedays;
	
	@Column(name="invoices")	
	private int invoices;
	
	@Column(name="dropp")	
	private int dropp;
	
	@Column(name="paydate")	
	private Date paydate;
	
	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public int getDropp() {
		return dropp;
	}

	public void setDropp(int dropp) {
		this.dropp = dropp;
	}

	

	public String getIdorder() {
		return idorder;
	}

	public void setIdorder(String idorder) {
		this.idorder = idorder;
	}

	public String getCustoid() {
		return custoid;
	}

	public void setCustoid(String custoid) {
		this.custoid = custoid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	

	

	public String getReferencenumber() {
		return referencenumber;
	}

	public void setReferencenumber(String referencenumber) {
		this.referencenumber = referencenumber;
	}

	public String getAccountusers() {
		return accountusers;
	}

	public void setAccountusers(String accountuser) {
		this.accountusers = accountuser;
	}


	
	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getDuedays() {
		return duedays;
	}

	public void setDuedays(int duedays) {
		this.duedays = duedays;
	}

	

	public int getInvoices() {
		return invoices;
	}

	public void setInvoices(int invoices) {
		this.invoices = invoices;
	}
	
	
}

