package com.crm.project.dao;

import java.util.List;

import com.crm.project.entity.LeadAgentUser;

public interface LeadAgentUserDao {
public List<LeadAgentUser> getLeadAgentUsers();
public String getLeadAgentUser(String a,String b);
}
