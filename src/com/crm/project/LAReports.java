package com.crm.project;

import java.sql.Date;
import java.util.List;

import com.crm.project.entity.Leads;

public class LAReports {
	private List<Leads>leads;
	private Date from;
	private Date to;
	
	public List<Leads> getLeads() {
		return leads;
	}
	public void setLeads(List<Leads> leads) {
		this.leads = leads;
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
