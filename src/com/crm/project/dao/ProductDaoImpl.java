package com.crm.project.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.Product;
import com.crm.project.entity.Tasks;
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Product getProduct(String pid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Product p where p.idproduct=\'"+pid+"\'";
		Query<Product>theQuery=currentSession.createQuery(query,Product.class);
		Product p=theQuery.getSingleResult();
		return p;
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Product";
		Query <Product> theQuery=currentSession.createQuery(query,Product.class);
		List<Product>t=theQuery.getResultList();
		return t;
	}

	
}
