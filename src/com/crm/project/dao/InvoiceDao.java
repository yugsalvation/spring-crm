package com.crm.project.dao;

import com.crm.project.entity.Invoice;

public interface InvoiceDao {
	public void addInvoice(String ordid);
	public void getInvoice(String invoiceid);
	public String getInvoiceid(String ordid);
	public void getInvoiceItext(String invoiceid);
}
