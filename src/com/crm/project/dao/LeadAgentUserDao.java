package com.crm.project.dao;

import java.util.List;

import com.crm.project.Emails;
import com.crm.project.entity.LeadAgentUser;

public interface LeadAgentUserDao {
public List<LeadAgentUser> getLeadAgentUsers();
public String getLeadAgentUser(String a,String b);
public String forgotPassword(String email,String leaduserid);
public String getPassword(String id);
public void changePassword(String id,String newpass);
public Emails getEmailsid(String id);
}
