package com.crm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="opportunity")
public class Opportunity {
	@Id
	@Column(name="opportunityid")	
	private String opportunityid;
	
	@Column(name="lid")	
	private String lid;
	
	@Column(name="probability1")	
	private double probability1;
	
	@Column(name="probability2")	
	private double probability2;
	
	@Column(name="suserid")	
	private String suserid;
	
	@Column(name="sexuserid")	
	private String sexuserid;
	
	@Column(name="description")	
	private String description;
	
	@Column(name="doc")	
	private Date doc;
	
	@Column(name="names")	
	private String names;
	
	@Column(name="names2")	
	private String names2;
	
	@Column(name="customer")	
	private int customer;
	
	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public String getNames2() {
		return names2;
	}

	public void setNames2(String names2) {
		this.names2 = names2;
	}

	@Column(name="contact_number")	
	private long contact_number;
	
	@Column(name="walking_date")	
	private Date walking_date;
	
	@Column(name="city")	
	private String city;
	
	@Column(name="emailid")	
	private String emailid;
	
	@Column(name="dropp")	
	private int dropp;
	
	public int getDropp() {
		return dropp;
	}

	public void setDropp(int dropp) {
		this.dropp = dropp;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public Date getWalking_date() {
		return walking_date;
	}

	public void setWalking_date(Date walking_date) {
		this.walking_date = walking_date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOpportunityid() {
		return opportunityid;
	}

	public void setOpportunityid(String opportunityid) {
		this.opportunityid = opportunityid;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public double getProbability1() {
		return probability1;
	}

	public void setProbability1(double probability1) {
		this.probability1 = probability1;
	}

	public double getProbability2() {
		return probability2;
	}

	public void setProbability2(double probability2) {
		this.probability2 = probability2;
	}

	public String getSuserid() {
		return suserid;
	}

	public void setSuserid(String suserid) {
		this.suserid = suserid;
	}

	public String getSexuserid() {
		return sexuserid;
	}

	public void setSexuserid(String sexuserid) {
		this.sexuserid = sexuserid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}

	
	
	
	
	
	
	

	
}
