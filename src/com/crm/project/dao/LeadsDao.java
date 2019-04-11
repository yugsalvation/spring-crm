package com.crm.project.dao;

import java.sql.Date;
import java.util.List;

import com.crm.project.LAReports;
import com.crm.project.SReportsLeads;
import com.crm.project.entity.Leads;



public interface LeadsDao {
	public List<Leads> getLeads(String id);
	public List<Leads> getSalesLeads(String id);
	public void addLead(Leads newLead) throws Exception;
	public Leads getLead(String id);
	public void updateLead(Leads l,String leadid);
	public void updateLead(String leadid);
	public int getOppCount(String sid,Date from,Date to);
	public SReportsLeads getSReportsLeads(String sid,Date from,Date to);
	public String getSLeadsReport(String sid,Date from,Date to);
	public LAReports getLAReports(String luserid,Date from,Date to);
	public String getLAReport(String luserid,Date from,Date to);
}
