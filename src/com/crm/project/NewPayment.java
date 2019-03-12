package com.crm.project;

public class NewPayment {
private String paymentMode;
private String paymentDate;
private double previousPaid;
private double paid;
private double balance;
private double discount;
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
private double total;
public String getPaymentMode() {
	return paymentMode;
}
public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
}
public String getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(String paymentDate) {
	this.paymentDate = paymentDate;
}
public double getPreviousPaid() {
	return previousPaid;
}
public void setPreviousPaid(double previousPaid) {
	this.previousPaid = previousPaid;
}
public double getPaid() {
	return paid;
}
public void setPaid(double paid) {
	this.paid = paid;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}

}
