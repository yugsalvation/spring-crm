package com.crm.project.dao;

import java.sql.Date;
import java.util.List;

import com.crm.project.SReportsOpp;
import com.crm.project.SeReportsOpp;
import com.crm.project.entity.Leads;
import com.crm.project.entity.Opportunity;

public interface OpportunityDao {
	public List<Opportunity> getOpportunities(String id);
	public List<Opportunity> getSexopportunity(String id);
	public List<Opportunity> getSexDateopportunity(String id,Date from,Date to);
	public void addOpportunity(Leads lead,String salesuserid) throws Exception;
	public Opportunity getOpportunity(String id);
	public void updateOpportunity(Opportunity o,String opportunityid);
	public void dropOpportunity(Opportunity o,String opportunityid);
	public void addSexeuser(String oid,String sexid);
	public void addCustomer(String oid);
	public int getDropCount(String sexid,Date from,Date to);
	public int getCustomerCount(String sexid,Date from,Date to);
	public SeReportsOpp getSeReportsOpp(String sexid,Date from,Date to);
	public String getOppReport(String sexid,Date from,Date to);
	public SReportsOpp getSReportsOpp(String seid,Date from,Date to);
	public String getSOppReport(String seid,Date from,Date to);
	public int getSDropCount(String seid,Date from,Date to);
	
}
