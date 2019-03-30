package com.crm.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.Customer;
import com.crm.project.entity.Opportunity;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	OpportunityDao opportunitydao;
	
	@Autowired
	TasksDao tasksdao;
	@Override
	@Transactional
	public void addCustomer(Customer c) {
		Session currentSession=sessionFactory.getCurrentSession();
		c.setCid("hello");
		opportunitydao.addCustomer(c.getOppid());
		int taskid=tasksdao.getTaskbyOid(c.getOppid());
		tasksdao.completeTask(taskid);
		currentSession.save(c);
		
		
	}
	@Override
	@Transactional
	public List<Customer> getSalesexCustomers(String seid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Customer c where c.seuserid=\'"+seid+"\' and dropp=0";
		Query <Customer> theQuery=currentSession.createQuery(query,Customer.class);
		List<Customer>c=theQuery.getResultList();
		return c;

	}

}
