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

import com.crm.project.entity.Accountuser;
import com.crm.project.entity.SalesExecutiveuser;

@Repository
public class AccountuserDaoImpl implements AccountuserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public String getAccountuser(String uname, String password) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Accountuser au where au.username="+"\'"+uname+"\'"+" AND au.password="+"\'"+password+"\'";
		try {
		Query<Accountuser> theQuery=currentSession.createQuery(query,Accountuser.class);
		Accountuser usr=theQuery.getSingleResult();
		String id=usr.getIdaccountuser();

		return id;}
		catch(Exception e) {
			return "";
		}
	}

	@Override
	@Transactional
	public String lessOrderAccountuser() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		CriteriaBuilder criteria=currentSession.getCriteriaBuilder();
		CriteriaQuery<Object>cq=criteria.createQuery(Object.class);
		Root<Accountuser> root = cq.from(Accountuser.class);
		
		cq.select(criteria.min(root.get("ordernumber")));
		Query theQuery=currentSession.createQuery(cq);
		Object minorder=theQuery.getSingleResult();
		Query<Accountuser> theQuery2=currentSession.createQuery("from Accountuser au where au.ordernumber="+minorder,Accountuser.class);
		Accountuser au=theQuery2.setMaxResults(1).getSingleResult();
		
		
		
		return au.getIdaccountuser();
	}

	@Override
	@Transactional
	public void incrementordernumber(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Accountuser set ordernumber=ordernumber+1 where idaccountuser="+"\'"+id+"\'";
		Query thequery=currentSession.createQuery(query);
		int result=thequery.executeUpdate();

	}

}
