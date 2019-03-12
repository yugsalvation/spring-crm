package com.crm.project.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="leads")
public class Leads {
@Id

@Column(name="leadid")	
private String leadid;

@Column(name="names")	
private String names;

@Column(name="walking_date")	
private Date walking_date;

@Column(name="emailid")	
private String emailid;

@Column(name="contact_number")	
private long contact_number;

@Column(name="leadsource")	
private String leadsource;

@Column(name="agentid")	
private String agentid;

@Column(name="city")	
private String city;

@Column(name="opp")	
private int opp;

@Column(name="leadsuserid")
private String leadsuserid;


public String getLeadsuserid() {
	return leadsuserid;
}
public void setLeadsuserid(String leadsuserid) {
	this.leadsuserid = leadsuserid;
}
public String getLeadid() {
	return leadid;
}
public void setLeadid(String leadid) {
	this.leadid = leadid;
}



public String getNames() {
	return names;
}
public void setNames(String names) {
	this.names = names;
}
public Date getWalking_date() {
	return walking_date;
}
public void setWalking_date(Date walking_date) {
	this.walking_date = walking_date;
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
public String getLeadsource() {
	return leadsource;
}
public void setLeadsource(String leadsource) {
	this.leadsource = leadsource;
}
public String getAgentid() {
	return agentid;
}
public void setAgentid(String agentid) {
	this.agentid = agentid;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getOpp() {
	return opp;
}
public void setOpp(int opp) {
	this.opp = opp;
}






}
