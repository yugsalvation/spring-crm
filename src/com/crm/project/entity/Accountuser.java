package com.crm.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountuser")
public class Accountuser {
	@Id
	@Column(name="idaccountuser")	
	private String idaccountuser;
	
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

	public String getIdaccountuser() {
		return idaccountuser;
	}

	public void setIdaccountuser(String idaccountuser) {
		this.idaccountuser = idaccountuser;
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

	public int getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}

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

	@Column(name="fname")
	private String fname;

	@Column(name="lname")
	private String lname;

	@Column(name="ordernumber")
	private int ordernumber;
	
	@Column(name="useremail")
	private String useremail;
	
	@Column(name="emailpassword")
	private String emailpassword;
	
	@Column(name="doj")
	private Date doj;
	
	@Column(name="preminorder")
	private int preminorder;

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public int getPreminorder() {
		return preminorder;
	}

	public void setPreminorder(int preminorder) {
		this.preminorder = preminorder;
	}
	

}
