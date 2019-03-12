package com.crm.project.dao;

import java.util.List;

import com.crm.project.entity.Leads;



public interface LeadsDao {
	public List<Leads> getLeads(String id);
	public List<Leads> getSalesLeads(String id);
	public void addLead(Leads newLead) throws Exception;
	public Leads getLead(String id);
	public void updateLead(Leads l,String leadid);
	public void updateLead(String leadid);
}
