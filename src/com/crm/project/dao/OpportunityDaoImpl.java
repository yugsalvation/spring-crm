package com.crm.project.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.Leads;
import com.crm.project.entity.Opportunity;
@Repository
public class OpportunityDaoImpl implements OpportunityDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Opportunity> getOpportunities(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.suserid=\'"+id+"\' and dropp=0 and sexuserid IS NULL";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		return o;
	}

	@Override
	@Transactional
	public List<Opportunity> getSexopportunity(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.sexuserid=\'"+id+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		return o;
	}
	
	@Override
	@Transactional
	public List<Opportunity> getSexDateopportunity(String id, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.sexuserid=\'"+id+"\' and doc BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		return o;
	}

	@Override
	@Transactional
	public void addOpportunity(Leads lead,String salesuserid) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Opportunity newOpportunity=new Opportunity();
		
		newOpportunity.setLid(lead.getLeadid());
		newOpportunity.setNames(lead.getNames());
		newOpportunity.setCity(lead.getCity());
		newOpportunity.setContact_number(lead.getContact_number());
		newOpportunity.setWalking_date(lead.getWalking_date());
		newOpportunity.setEmailid(lead.getEmailid());
		newOpportunity.setSuserid(salesuserid);
		newOpportunity.setOpportunityid("hello");
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		newOpportunity.setDoc(doc);
		currentSession.save(newOpportunity);

	}

	@Override
	@Transactional
	public Opportunity getOpportunity(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.opportunityid=\'"+id+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		Opportunity o=theQuery.getSingleResult();
		return o;
	}

	@Override
	@Transactional
	public void updateOpportunity(Opportunity o, String opportunityid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set description=\'"+o.getDescription()+"\' where opportunityid=\'"+opportunityid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();

	}

	@Override
	@Transactional
	public void dropOpportunity(Opportunity o, String opportunityid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set dropp=1,description=\'"+o.getDescription()+"\' where opportunityid=\'"+opportunityid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void addSexeuser(String oid, String sexid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set sexuserid=\'"+sexid+"\' where opportunityid=\'"+oid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	

}
