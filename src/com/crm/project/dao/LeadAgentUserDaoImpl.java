package com.crm.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.Emails;
import com.crm.project.entity.LeadAgentUser;
import com.crm.project.entity.Salesuser;
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

	@Override
	@Transactional
	public String forgotPassword(String email, String leaduserid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from LeadAgentUser su where su.agentid="+"\'"+leaduserid+"\' and emailid=\'"+email+"\'";
		try {
		Query<LeadAgentUser> theQuery=currentSession.createQuery(query,LeadAgentUser.class);
	
		LeadAgentUser usr=theQuery.getSingleResult();
		String pass=usr.getPassword();
		return pass;}
		catch(Exception e) {
			return "";
		}
	}

	@Override
	@Transactional
	public String getPassword(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from LeadAgentUser su where su.agentid="+"\'"+id+"\'";
		try {
		Query<LeadAgentUser> theQuery=currentSession.createQuery(query,LeadAgentUser.class);
	
		LeadAgentUser usr=theQuery.getSingleResult();
		String pass=usr.getPassword();
		return pass;}
		catch(Exception e) {
			return "";
		}
	}

	@Override
	@Transactional
	public void changePassword(String id, String newpass) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update LeadAgentUser set password=\'"+newpass+"\' where agentid="+"\'"+id+"\'";
		Query thequery=currentSession.createQuery(query);
		int result=thequery.executeUpdate();
		
	}

	@Override
	@Transactional
	public Emails getEmailsid(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from LeadAgentUser su where su.agentid="+"\'"+id+"\'";
		Query<LeadAgentUser> theQuery=currentSession.createQuery(query,LeadAgentUser.class);
		LeadAgentUser usr=theQuery.getSingleResult();
		Emails e=new Emails();
		e.setFrom(usr.getEmailid());
		e.setUsername(usr.getUseremail());
		e.setPassword(usr.getEmailpassword());
		
		return e;
	}
}
