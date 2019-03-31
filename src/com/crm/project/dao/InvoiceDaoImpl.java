package com.crm.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.Invoice;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addInvoice(Invoice inv) {
		Session currentSession=sessionFactory.getCurrentSession();
		inv.setIdinvoice("hello");
		currentSession.save(inv);

	}

}
