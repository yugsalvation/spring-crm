package com.crm.project.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.Customer;
import com.crm.project.entity.Order;
import com.crm.project.entity.Product;
@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addOrder(Order o) throws Exception{
		Session currentSession=sessionFactory.getCurrentSession();
		
		
		o.setIdorder("hello");
		currentSession.save(o);

	}

	@Override
	@Transactional
	public List<Order> getCustomerOrders(String cid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Order where custoid=\'"+cid+"\' and dropp=0";
		Query<Order> theQuery=currentSession.createQuery(query,Order.class);
		
		List<Order>orders=theQuery.getResultList();
		
		return orders;
		
	}

	@Override
	@Transactional
	public Order getOrder(String ordid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Order o where o.idorder=\'"+ordid+"\' and dropp=0";
		Query <Order> theQuery=currentSession.createQuery(query,Order.class);
		Order o=theQuery.getSingleResult();
		
		return o;
	}

	@Override
	@Transactional
	public void updateInvoice(String ordid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Order o set o.invoices=1 where o.idorder=\'"+ordid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
		
	}

	@Override
	@Transactional
	public List<Order> getPending(String idacuser) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Order o where o.accountusers=\'"+idacuser+"\' and o.dropp=0 and payment=\'PENDING\' and o.duedate>=\'"+doc+"\' order by o.duedate";
		Query<Order> theQuery=currentSession.createQuery(query,Order.class);
		
		List<Order>orders=theQuery.getResultList();
		
		return orders;
		
	}

	@Override
	@Transactional
	
	public void addPayment(String ordid,Order o) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Order o set o.payment=\'COMPLETED\' ,referencenumber=\'"+o.getReferencenumber()+"\' where o.idorder=\'"+ordid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

}
