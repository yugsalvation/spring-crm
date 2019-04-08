package com.crm.project.dao;

import com.crm.project.entity.Salesuser;

public interface SalesuserDao {
	public String getSalesuser(String a,String b);
	public String lessLeadSalesuser();
	public void incrementleadnumber(String id);
	public String forgotPassword(String email,String susrid);
}