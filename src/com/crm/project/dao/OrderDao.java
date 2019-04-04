package com.crm.project.dao;

import java.util.List;

import com.crm.project.entity.Order;

public interface OrderDao {
	public void addOrder(Order o)throws Exception;
	public List<Order>getCustomerOrders(String cid);
	public Order getOrder(String ordid);
	public void updateInvoice(String ordid);
	public List<Order>getPending(String idacuser);
	public void addPayment(String ordid,Order o);
}
