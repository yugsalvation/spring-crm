package com.crm.project.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.io.Serializable;
@Entity
@Table(name="leadagentuser")
public class LeadAgentUser implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="agentid")
private String agentid;

@Column(name="name")
private String name;

@Column(name="emailid")
private String emailid;

@Column(name="contact_number")
private long contact_number;

public String getUseremail() {
	return useremail;
}

public void setUseremail(String useremail) {
	this.useremail = useremail;
}

public String getEmailpassword() {
	return emailpassword;
}

public void setEmailpassword(String emailpassword) {
	this.emailpassword = emailpassword;
}

@Column(name="company")
private String company;

@Column(name="uname")
private String uname;

@Column(name="password")
private String password;

@Column(name="useremail")
private String useremail;

@Column(name="emailpassword")
private String emailpassword;


public String getAgentid() {
	return agentid;
}

public void setAgentid(String agentid) {
	this.agentid = agentid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
