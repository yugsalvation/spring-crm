package com.crm.project;

import java.sql.Date;
import java.util.List;

import com.crm.project.entity.Customer;

public class SeReportsCust {
	private Date from;
	private Date to;
	private List<Customer>cust;
	private int dropcount;
	public int getDropcount() {
		return dropcount;
	}
	public void setDropcount(int dropcount) {
		this.dropcount = dropcount;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public List<Customer> getCust() {
		return cust;
	}
	public void setCust(List<Customer> cust) {
		this.cust = cust;
	}
}
