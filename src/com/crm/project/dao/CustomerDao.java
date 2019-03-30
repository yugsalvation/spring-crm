package com.crm.project.dao;

import java.util.List;

import com.crm.project.entity.Customer;
import com.crm.project.entity.Opportunity;

public interface CustomerDao {
	public void addCustomer(Customer c);
	public List<Customer> getSalesexCustomers(String seid);
}
