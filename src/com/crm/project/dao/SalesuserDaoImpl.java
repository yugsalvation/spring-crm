package com.crm.project.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.LeadAgentUser;
import com.crm.project.entity.Salesuser;

@Repository
public class SalesuserDaoImpl implements SalesuserDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public String getSalesuser(String uname, String password) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Salesuser su where su.username="+"\'"+uname+"\'"+" AND su.password="+"\'"+password+"\'";
		Query<Salesuser> theQuery=currentSession.createQuery(query,Salesuser.class);
		Salesuser usr=theQuery.getSingleResult();
		String id=usr.getIdsalesuser();

		return id;
	}

	@Override
	@Transactional
	public String lessLeadSalesuser() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		CriteriaBuilder criteria=currentSession.getCriteriaBuilder();
		CriteriaQuery<Object>cq=criteria.createQuery(Object.class);
		Root<Salesuser> root = cq.from(Salesuser.class);
		
		cq.select(criteria.min(root.get("leadnumber")));
		Query theQuery=currentSession.createQuery(cq);
		Object minlead=theQuery.getSingleResult();
		Query<Salesuser> theQuery2=currentSession.createQuery("from Salesuser su where su.leadnumber="+minlead,Salesuser.class);
		Salesuser su=theQuery2.setMaxResults(1).getSingleResult();
		
		
		
		return su.getIdsalesuser();
	}

	@Override
	@Transactional
	public void incrementleadnumber(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Salesuser set leadnumber=leadnumber+1 where idsalesuser="+"\'"+id+"\'";
		Query thequery=currentSession.createQuery(query);
		int result=thequery.executeUpdate();
		
	}
	


}
