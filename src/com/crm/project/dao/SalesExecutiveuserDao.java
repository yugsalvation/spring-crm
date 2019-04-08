package com.crm.project.dao;

import com.crm.project.Emails;
import com.crm.project.sessionbean.Email;

public interface SalesExecutiveuserDao {
	public String getSalesExecutiveuser(String a,String b);
	public String lessOppSalesExecutiveuser();
	public void incrementoppnumber(String id);
	public String forgotPassword(String email,String seusrid);
	public Emails getEmailsid(String id);
}
