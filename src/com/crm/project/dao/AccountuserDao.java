package com.crm.project.dao;

import com.crm.project.Emails;

public interface AccountuserDao {
	public String getAccountuser(String a,String b);
	public String lessOrderAccountuser();
	public void incrementordernumber(String id);
	public String forgotPassword(String email,String acusrid);
	public String getPassword(String id);
	public void changePassword(String id,String newpass);
	public Emails getEmailsid(String id);
}
