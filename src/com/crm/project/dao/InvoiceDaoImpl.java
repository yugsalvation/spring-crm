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

import com.crm.project.Emails;
import com.crm.project.InvoiceData;
import com.crm.project.entity.Customer;
import com.crm.project.entity.Invoice;
import com.crm.project.entity.Order;
import com.crm.project.entity.Product;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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
	
	@Autowired
	AccountuserDao accountuserdao;
	
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
		double amount= (p.getAmount()*((p.getTax())/100))+p.getAmount();
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
		 String billdate;
		 String duedate;
		 
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Invoice i where i.idinvoice=\'"+invoiceid+"\'";
		Query <Invoice> theQuery=currentSession.createQuery(query,Invoice.class);
		Invoice i=theQuery.getSingleResult();
		Customer c=customerdao.getCustomer(i.getCustid());
		Product p=productdao.getProduct(i.getProductid());
		Order o=orderdao.getOrder(i.getOrdid());
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
		billdate=String.valueOf(o.getBilldate());
		duedate=String.valueOf(o.getDuedate());
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
		Emails e=accountuserdao.getEmailsid(o.getAccountusers());
		
		Document d=new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\WebContent\\resources\\"+ind.getIdinvoice()+".pdf"));
			d.open();
			d.add(new Paragraph("CRM SYSTEMS"));
			PdfPTable heading=new PdfPTable(1);
			heading.setWidthPercentage(100);
			PdfPCell cell1=new PdfPCell(new Paragraph("INVOICE"));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell1.setBorder(Rectangle.NO_BORDER);
			
			heading.addCell(cell1);
		
			PdfPTable customer=new PdfPTable(3);
			customer.setWidthPercentage(100);
			PdfPCell defaultCell=customer.getDefaultCell();
			defaultCell.setBorder(PdfPCell.NO_BORDER);
			PdfPCell ccell1=new PdfPCell(new Paragraph(ind.getName()));
			ccell1.setBorder(Rectangle.NO_BORDER);
			ccell1.setColspan(2);
			PdfPCell ccell2=new PdfPCell(new Paragraph("Invoice Id:"+ind.getIdinvoice()));
			ccell2.setBorder(Rectangle.NO_BORDER);
			PdfPCell ccell3=new PdfPCell(new Paragraph("Customer Id:"+ind.getCid()));
			ccell3.setBorder(Rectangle.NO_BORDER);
			ccell3.setColspan(2);
			PdfPCell ccell4=new PdfPCell(new Paragraph("Order Id:"+o.getIdorder()));
			ccell4.setBorder(Rectangle.NO_BORDER);
			PdfPCell ccell5=new PdfPCell(new Paragraph(ind.getAddress1()+",\n"+ind.getAddress2()+",\n"+ind.getCity()));
			ccell5.setBorder(Rectangle.NO_BORDER);
			ccell5.setColspan(2);
			PdfPCell ccell6=new PdfPCell(new Paragraph(""));
			ccell6.setBorder(Rectangle.NO_BORDER);
			PdfPCell ccell7=new PdfPCell(new Paragraph(ind.getAddress2()));
			ccell7.setBorder(Rectangle.NO_BORDER);
			ccell7.setColspan(2);
			customer.addCell(ccell1);
			customer.addCell(ccell2);
			customer.addCell(ccell3);
			customer.addCell(ccell4);
			customer.addCell(ccell5);
			customer.addCell(ccell6);
			customer.addCell(ccell7);
			heading.setSpacingAfter(40f);
			customer.setSpacingAfter(60f);
			
			PdfPTable bill=new PdfPTable(2);
			bill.setWidthPercentage(100);
			
			PdfPCell bcell1=new PdfPCell(new Paragraph("Product:"));
			bcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell bcell2=new PdfPCell(new Paragraph(ind.getProductname()));
			bcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell bcell3=new PdfPCell(new Paragraph("Amount:"));
			bcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell bcell4=new PdfPCell(new Paragraph(String.valueOf(ind.getAmount())));
			bcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell bcell5=new PdfPCell(new Paragraph("Tax %:"));
			bcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell bcell6=new PdfPCell(new Paragraph(String.valueOf(ind.getTax())));
			bcell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell bcell7=new PdfPCell(new Paragraph("Total:"));
			bcell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell bcell8=new PdfPCell(new Paragraph(String.valueOf(ind.getTotal())));
			bcell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			bill.addCell(bcell1);
			bill.addCell(bcell2);
			bill.addCell(bcell3);
			bill.addCell(bcell4);
			bill.addCell(bcell5);
			bill.addCell(bcell6);
			bill.addCell(bcell7);
			bill.addCell(bcell8);
			bill.setSpacingAfter(15f);
			d.add(heading);
			d.add(customer);
			d.add(bill);
			d.add(new Paragraph("THE DUE DATE FOR YOUR PAYMENT IS:"+o.getDuedate()));
			Paragraph ps=new Paragraph("After payment send ref number to:"+e.getFrom());
			Font f=new Font(FontFamily.TIMES_ROMAN,10f);
			ps.setFont(f);
		
			d.add(ps);
			d.close();
			writer.close();
		}
		catch(DocumentException ex) {
			ex.printStackTrace();
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
	
	

}
