package com.crm.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.Leads;
@Repository
public class LeadsDaoImpl implements LeadsDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional

	public List<Leads> getLeads(String id) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads l where agentid=\'"+id+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		List<Leads>l=theQuery.getResultList();
		return l;
	}
	
	@Override
	@Transactional
	public List<Leads> getSalesLeads(String id) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads l where opp=0 and leadsuserid=\'"+id+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		List<Leads>l=theQuery.getResultList();
		return l;
	}

	@Override
	@Transactional
	public void addLead(Leads newLead) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		newLead.setLeadid("hello");
		currentSession.save(newLead);

	}

	@Override
	@Transactional
	public Leads getLead(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads l where leadid=\'"+id+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		Leads l=theQuery.getSingleResult();
		return l;
		
	}
	
	@Override
	@Transactional
	public void updateLead(Leads l,String leadid)
	{
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Leads set names=\'"+l.getNames()+"\',walking_date=\'"+l.getWalking_date()+"\',emailid=\'"+l.getEmailid()+"\',contact_number="+l.getContact_number()+",city=\'"+l.getCity()+"\' where leadid=\'"+leadid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void updateLead(String leadid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Leads set opp=1 where leadid=\'"+leadid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	
}
