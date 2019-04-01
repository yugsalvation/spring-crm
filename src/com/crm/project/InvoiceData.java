package com.crm.project;

public class InvoiceData {
private String name;
private String address1;
private String address2;
private String cid;
private double amount;
private double tax;
private String productname;
private double total;
private String idinvoice;
private String city;
private String billdate;
private String duedate;
public String getBilldate() {
	return billdate;
}
public void setBilldate(String billdate) {
	this.billdate = billdate;
}
public String getDuedate() {
	return duedate;
}
public void setDuedate(String duedate) {
	this.duedate = duedate;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress1() {
	return address1;
}
public void setAddress1(String address1) {
	this.address1 = address1;
}
public String getAddress2() {
	return address2;
}
public void setAddress2(String address2) {
	this.address2 = address2;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getTax() {
	return tax;
}
public void setTax(double tax) {
	this.tax = tax;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public String getIdinvoice() {
	return idinvoice;
}
public void setIdinvoice(String idinvoice) {
	this.idinvoice = idinvoice;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
}
