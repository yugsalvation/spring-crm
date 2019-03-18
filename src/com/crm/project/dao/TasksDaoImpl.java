package com.crm.project.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.entity.Leads;
import com.crm.project.entity.Tasks;
@Repository
public class TasksDaoImpl implements TasksDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addSalesTask(Tasks t) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.save(t);

	}

	@Override
	@Transactional
	public void addSalesexTask(Tasks t) {
		Session currentSession=sessionFactory.getCurrentSession();
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		t.setDoc(doc);
		currentSession.save(t);


	}

	@Override
	@Transactional
	public Tasks getTask(int taskid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Tasks t where t.idtasks=\'"+taskid+"\'";
		Query <Tasks> theQuery=currentSession.createQuery(query,Tasks.class);
		Tasks t=theQuery.getSingleResult();
		return t;
	}

	@Override
	@Transactional
	public List<Tasks> getSalesTasks(String suserid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Tasks t where t.suser=\'"+suserid+"\' and completed=0 and dropp=0";
		Query <Tasks> theQuery=currentSession.createQuery(query,Tasks.class);
		List<Tasks>t=theQuery.getResultList();
		return t;
	}

	@Override
	@Transactional
	public List<Tasks> getSalesmyTasks(String suserid) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Tasks t where t.suser=\'"+suserid+"\' and t.dor=\'"+doc+"\' and reminder=0 and dropp=0";
		Query <Tasks> theQuery=currentSession.createQuery(query,Tasks.class);
		List<Tasks>t=theQuery.getResultList();
		return t;
	}

	@Override
	@Transactional
	public List<Tasks> getSalesTodayTasks(String suserid) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Tasks t where t.suser=\'"+suserid+"\' and t.dom=\'"+doc+"\'";
		Query <Tasks> theQuery=currentSession.createQuery(query,Tasks.class);
		List<Tasks>t=theQuery.getResultList();
		return t;
	}

	@Override
	@Transactional
	public List<Tasks> getSalesexTasks(String seuserid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Tasks t where t.seuser=\'"+seuserid+"\' and completed=0 and dropp=0";
		Query <Tasks> theQuery=currentSession.createQuery(query,Tasks.class);
		List<Tasks>t=theQuery.getResultList();
		return t;
	}

	@Override
	@Transactional
	public List<Tasks> getSalesexmyTasks(String seuserid) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Tasks t where t.seuser=\'"+seuserid+"\' and t.dor=\'"+doc+"\' and reminder=0 and dropp=0";
		Query <Tasks> theQuery=currentSession.createQuery(query,Tasks.class);
		List<Tasks>t=theQuery.getResultList();
		return t;
	}

	@Override
	@Transactional
	public List<Tasks> getSalesexTodayTasks(String seuserid) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Tasks t where t.seuser=\'"+seuserid+"\' and t.dom=\'"+doc+"\' and completed=0 and dropp=0 and reminder=1";
		Query <Tasks> theQuery=currentSession.createQuery(query,Tasks.class);
		List<Tasks>t=theQuery.getResultList();
		return t;
	}

	@Override
	@Transactional
	public void updateTask(int taskid, Tasks t) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Tasks set description=\'"+t.getDescription()+"\' ,dor=\'"+t.getDor()+"\' ,dom=\'"+t.getDom()+"\' ,tom=\'"+t.getTom()+"\' where idtasks="+taskid;
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void completeTask(int taskid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Tasks set completed=1 where idtasks=\'"+taskid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();

	}

	@Override
	@Transactional
	public void sendReminderTask(int taskid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Tasks set reminder=1 where idtasks=\'"+taskid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();

	}

	@Override
	@Transactional
	public void dropTask(int taskid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Tasks set dropp=1 where idtasks=\'"+taskid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();

	}

}
