package com.crm.project.dao;

import org.hibernate.Session;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.InvoiceData;
import com.crm.project.entity.Customer;
import com.crm.project.entity.Invoice;
import com.crm.project.entity.Order;
import com.crm.project.entity.Product;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	OrderDao orderdao;
	
	@Autowired
	CustomerDao customerdao;
	
	@Autowired
	ProductDao productdao;
	
	
	@Override
	@Transactional
	public void addInvoice(String ordid) {
		Session currentSession=sessionFactory.getCurrentSession();
		Order o=orderdao.getOrder(ordid);
		Product p=productdao.getProduct(o.getPid());
		Customer c=customerdao.getCustomer(o.getCustoid());
		
		Invoice inv=new Invoice();
		inv.setAcuser(o.getAccountusers());
		inv.setCustid(c.getCid());
		double amount= p.getAmount()*((p.getTax())/100);
		inv.setAmount(amount);
		inv.setOrdid(o.getIdorder());
		inv.setProductid(p.getIdproduct());
		inv.setSexeuserid(c.getSeuserid());
		
		inv.setIdinvoice("hello");
		currentSession.save(inv);
		

	}
	
	
	
	@Override
	@Transactional
	public void getInvoice(String invoiceid) {
		String name;
		String address1;
		 String address2;
		 String cid;
		 double amount;
		 double tax;
		String productname;
		 double total;
		 String idinvoice;
		 String city;
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Invoice i where i.idinvoice=\'"+invoiceid+"\'";
		Query <Invoice> theQuery=currentSession.createQuery(query,Invoice.class);
		Invoice i=theQuery.getSingleResult();
		Customer c=customerdao.getCustomer(i.getCustid());
		Product p=productdao.getProduct(i.getProductid());
		InvoiceData ind=new InvoiceData();
		name=c.getFname()+" "+c.getLname();
		address1=c.getAddress1();
		address2=c.getAddress2();
		cid=c.getCid();
		amount=p.getAmount();
		tax=p.getTax();
		productname=p.getProductname();
		total=i.getAmount();  
		idinvoice=i.getIdinvoice();
		city=c.getCity();
		ind.setName(name);
		ind.setAddress1(address1);
		ind.setAddress2(address2);
		ind.setCid(cid);
		ind.setAmount(amount);
		ind.setTax(tax);
		ind.setProductname(productname);
		ind.setTotal(total);
		ind.setIdinvoice(idinvoice);
		ind.setCity(city);
		
		try {
		/* User home directory location */
        String userHomeDirectory = System.getProperty("user.home");
        /* Output file location */
        String outputFile = userHomeDirectory + File.separatorChar + "JasperTableExample.pdf";
        
        List<InvoiceData> listItems = new ArrayList<InvoiceData>();
        
        listItems.add(ind);
        
        /* Convert List to JRBeanCollectionDataSource */
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
        
        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource", itemsJRBean);
        
        /* Using compiled version(.jasper) of Jasper report to generate PDF */
        JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\src\\com\\crm\\project\\dao\\Invoices.jasper", parameters, new JREmptyDataSource());
		
        /* outputStream to create PDF */
        OutputStream outputStream = new FileOutputStream(new File(outputFile));
        /* Write content to PDF file */
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		
		}
		
		 catch (JRException ex) {
	            ex.printStackTrace();
	        } 
		
		catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        }
		
	}



	@Override
	@Transactional
	public String getInvoiceid(String ordid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Invoice i where i.ordid=\'"+ordid+"\'";
		Query <Invoice> theQuery=currentSession.createQuery(query,Invoice.class);
		Invoice i=theQuery.getSingleResult();
		return i.getIdinvoice();
	}



	@Override
	@Transactional
	public void getInvoiceItext(String invoiceid) {
		String name;
		String address1;
		 String address2;
		 String cid;
		 double amount;
		 double tax;
		String productname;
		 double total;
		 String idinvoice;
		 String city;
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Invoice i where i.idinvoice=\'"+invoiceid+"\'";
		Query <Invoice> theQuery=currentSession.createQuery(query,Invoice.class);
		Invoice i=theQuery.getSingleResult();
		Customer c=customerdao.getCustomer(i.getCustid());
		Product p=productdao.getProduct(i.getProductid());
		InvoiceData ind=new InvoiceData();
		name=c.getFname()+" "+c.getLname();
		address1=c.getAddress1();
		address2=c.getAddress2();
		cid=c.getCid();
		amount=p.getAmount();
		tax=p.getTax();
		productname=p.getProductname();
		total=i.getAmount();  
		idinvoice=i.getIdinvoice();
		city=c.getCity();
		ind.setName(name);
		ind.setAddress1(address1);
		ind.setAddress2(address2);
		ind.setCid(cid);
		ind.setAmount(amount);
		ind.setTax(tax);
		ind.setProductname(productname);
		ind.setTotal(total);
		ind.setIdinvoice(idinvoice);
		ind.setCity(city);
		
		Document d=new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\WebContent\\resources\\abcd.pdf"));
			d.open();
			d.add(new Paragraph("Dada"));
			d.close();
			writer.close();
		}
		catch(DocumentException e) {
			e.printStackTrace();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
