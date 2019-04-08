package com.crm.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.LeadAgentUser;
@Repository
public class LeadAgentUserDaoImpl implements LeadAgentUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<LeadAgentUser> getLeadAgentUsers() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<LeadAgentUser> theQuery=currentSession.createQuery("from LeadAgentUser",LeadAgentUser.class);
		
		List<LeadAgentUser>leadagentusers=theQuery.getResultList();
		
		return leadagentusers;
	}

	@Override
	@Transactional
	public String getLeadAgentUser(String uname,String password) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from LeadAgentUser l where l.uname="+"\'"+uname+"\'"+" AND l.password="+"\'"+password+"\'";
		try {
		Query<LeadAgentUser> theQuery=currentSession.createQuery(query,LeadAgentUser.class);
		LeadAgentUser usr=theQuery.getSingleResult();
		String id=usr.getAgentid();

		return id;}
		catch(Exception e) {
			return "";
		}
	}
}
