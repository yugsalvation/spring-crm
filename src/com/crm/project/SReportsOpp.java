package com.crm.project;

import java.sql.Date;
import java.util.List;

import com.crm.project.entity.Opportunity;

public class SReportsOpp {
	private List<Opportunity>opp;
	private int dropcount;
	private int customercount;
	private Date from;
	private Date to;
	public List<Opportunity> getOpp() {
		return opp;
	}
	public void setOpp(List<Opportunity> opp) {
		this.opp = opp;
	}
	public int getDropcount() {
		return dropcount;
	}
	public void setDropcount(int dropcount) {
		this.dropcount = dropcount;
	}
	public int getCustomercount() {
		return customercount;
	}
	public void setCustomercount(int customercount) {
		this.customercount = customercount;
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
}
