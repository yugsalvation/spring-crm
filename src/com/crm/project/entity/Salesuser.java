package com.crm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salesuser")
public class Salesuser {
@Id
@Column(name="idsalesuser")
private String idsalesuser;

@Column(name="username")
private String username;

@Column(name="password")
private String password;

@Column(name="emailid")
private String emailid;

@Column(name="contact_number")
private long contact_number;

@Column(name="dob")
private Date dob;

@Column(name="address")
private String address;

@Column(name="fname")
private String fname;

@Column(name="lname")
private String lname;

@Column(name="leadnumber")
private int leadnumber;

public String getIdsalesuser() {
	return idsalesuser;
}

public void setIdsalesuser(String idsalesuser) {
	this.idsalesuser = idsalesuser;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
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

public int getLeadnumber() {
	return leadnumber;
}

public void setLeadnumber(int leadnumber) {
	this.leadnumber = leadnumber;
}


}
