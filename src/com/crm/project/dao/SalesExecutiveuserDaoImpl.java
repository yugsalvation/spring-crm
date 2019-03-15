package com.crm.project.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.SalesExecutiveuser;


@Repository
public class SalesExecutiveuserDaoImpl implements SalesExecutiveuserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional

	public String getSalesExecutiveuser(String uname, String password) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from SalesExecutiveuser seu where seu.username="+"\'"+uname+"\'"+" AND seu.password="+"\'"+password+"\'";
		Query<SalesExecutiveuser> theQuery=currentSession.createQuery(query,SalesExecutiveuser.class);
		SalesExecutiveuser usr=theQuery.getSingleResult();
		String id=usr.getIdseuser();

		return id;
	}

	@Override
	@Transactional
	public String lessOppSalesExecutiveuser() {
Session currentSession=sessionFactory.getCurrentSession();
		
		CriteriaBuilder criteria=currentSession.getCriteriaBuilder();
		CriteriaQuery<Object>cq=criteria.createQuery(Object.class);
		Root<SalesExecutiveuser> root = cq.from(SalesExecutiveuser.class);
		
		cq.select(criteria.min(root.get("oppnumber")));
		Query theQuery=currentSession.createQuery(cq);
		Object minopp=theQuery.getSingleResult();
		Query<SalesExecutiveuser> theQuery2=currentSession.createQuery("from SalesExecutiveuser seu where seu.oppnumber="+minopp,SalesExecutiveuser.class);
		SalesExecutiveuser seu=theQuery2.setMaxResults(1).getSingleResult();
		
		
		
		return seu.getIdseuser();
	}

	@Override
	@Transactional
	public void incrementoppnumber(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update SalesExecutiveuser set oppnumber=oppnumber+1 where idseuser="+"\'"+id+"\'";
		Query thequery=currentSession.createQuery(query);
		int result=thequery.executeUpdate();

	}

}
