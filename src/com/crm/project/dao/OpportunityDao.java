package com.crm.project.dao;

import java.util.List;


import com.crm.project.entity.Leads;
import com.crm.project.entity.Opportunity;

public interface OpportunityDao {
	public List<Opportunity> getOpportunities(String id);
	public List<Opportunity> getSexopportunity(String id);
	public void addOpportunity(Leads lead,String salesuserid) throws Exception;
	public Opportunity getOpportunity(String id);
	public void updateOpportunity(Opportunity o,String opportunityid);
	public void dropOpportunity(Opportunity o,String opportunityid);
	public void addSexeuser(String oid,String sexid);
	
}
