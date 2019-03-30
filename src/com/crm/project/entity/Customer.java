package com.crm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	

	@Id
	@Column(name="cid")	
	private String cid;
	
	@Column(name="fname")	
	private String fname;
	
	@Column(name="lname")	
	private String lname;
	
	@Column(name="signupdate")	
	private Date signupdate;
	
	@Column(name="emailid")	
	private String emailid;
	
	@Column(name="contact_number")	
	private long contact_number;
	
	@Column(name="address1")	
	private String address1;
	
	@Column(name="address2")	
	private String address2;
	
	@Column(name="city")	
	private String city;
	
	@Column(name="salesuserid")	
	private String salesuserid;
	
	@Column(name="seuserid")	
	private String seuserid;
	
	@Column(name="addressproof")	
	private String addressproof;

	

	
	@Column(name="oppid")	
	private String oppid;
	
	@Column(name="dropp")	
	private int dropp;
	
	public int getDropp() {
		return dropp;
	}

	public void setDropp(int dropp) {
		this.dropp = dropp;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getSignupdate() {
		return signupdate;
	}

	public void setSignupdate(Date signupdate) {
		this.signupdate = signupdate;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	public String getSalesuserid() {
		return salesuserid;
	}

	public void setSalesuserid(String salesuserid) {
		this.salesuserid = salesuserid;
	}

	public String getSeuserid() {
		return seuserid;
	}

	public void setSeuserid(String seuserid) {
		this.seuserid = seuserid;
	}

	public String getAddressproof() {
		return addressproof;
	}

	public void setAddressproof(String addressproof) {
		this.addressproof = addressproof;
	}


	

	

	public String getOppid() {
		return oppid;
	}

	public void setOppid(String oppid) {
		this.oppid = oppid;
	}



	
	

}
