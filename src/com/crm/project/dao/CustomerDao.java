package com.crm.project.dao;

import java.sql.Date;
import java.util.List;

import com.crm.project.SeReportsCust;
import com.crm.project.SeReportsOpp;
import com.crm.project.entity.Customer;
import com.crm.project.entity.Opportunity;

public interface CustomerDao {
	public void addCustomer(Customer c);
	public List<Customer> getSalesexCustomers(String seid);
	public Customer getCustomer(String cid);
	public int getDropCount(String sexid, Date from, Date to);
	public SeReportsCust getSeReportsCust(String sexid,Date from,Date to);
	public String getCustReport(String sexid,Date from,Date to);
}
