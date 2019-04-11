package com.crm.project;

import java.sql.Date;
import java.util.List;

import com.crm.project.entity.Leads;


public class SReportsLeads {
	private List<Leads>leads;
	private int dropcount;
	private int oppcount;
	private Date from;
	private Date to;
	
	public List<Leads> getLeads() {
		return leads;
	}
	public void setLeads(List<Leads> leads) {
		this.leads = leads;
	}
	public int getOppcount() {
		return oppcount;
	}
	public void setOppcount(int oppcount) {
		this.oppcount = oppcount;
	}
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
}
