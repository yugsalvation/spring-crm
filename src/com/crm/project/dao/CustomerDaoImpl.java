package com.crm.project.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.SeReportsCust;
import com.crm.project.entity.Customer;
import com.crm.project.entity.Opportunity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	OpportunityDao opportunitydao;
	
	@Autowired
	TasksDao tasksdao;
	@Override
	@Transactional
	public void addCustomer(Customer c) {
		Session currentSession=sessionFactory.getCurrentSession();
		c.setCid("hello");
		opportunitydao.addCustomer(c.getOppid());
		int taskid=tasksdao.getTaskbyOid(c.getOppid());
		tasksdao.completeTask(taskid);
		currentSession.save(c);
		
		
	}
	@Override
	@Transactional
	public List<Customer> getSalesexCustomers(String seid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Customer c where c.seuserid=\'"+seid+"\' and dropp=0";
		Query <Customer> theQuery=currentSession.createQuery(query,Customer.class);
		List<Customer>c=theQuery.getResultList();
		return c;

	}
	@Override
	@Transactional
	public Customer getCustomer(String cid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Customer c where c.cid=\'"+cid+"\' and dropp=0";
		Query <Customer> theQuery=currentSession.createQuery(query,Customer.class);
		Customer c=theQuery.getSingleResult();
		
		return c;
	}
	
	@Override
	@Transactional
	public SeReportsCust getSeReportsCust(String sexid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Customer o where o.seuserid=\'"+sexid+"\' and signupdate BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Customer> theQuery=currentSession.createQuery(query,Customer.class);
		List<Customer>c=theQuery.getResultList();
		SeReportsCust sec=new SeReportsCust();
		sec.setCust(c);
		sec.setFrom(from);
		sec.setTo(to);
		sec.setDropcount(getDropCount(sexid,from,to));
		return sec;
	}
	
	@Override
	@Transactional
	public String getCustReport(String sexid, Date from, Date to) {
		SeReportsCust sec=getSeReportsCust(sexid,from,to);
		Document d=new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\WebContent\\resources\\reports\\salesexecutive\\"+sexid+"\\CUSTOMER\\"+from+"_"+to+".pdf"));
			d.open();
			d.add(new Paragraph("CRM SYSTEMS"));
			PdfPTable report=new PdfPTable(5);
			report.setSpacingBefore(40f);
			report.setWidthPercentage(100);
			PdfPCell hcell1=new PdfPCell(new Paragraph("CID"));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell2=new PdfPCell(new Paragraph("Fname"));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell3=new PdfPCell(new Paragraph("Lname"));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell4=new PdfPCell(new Paragraph("SignupDate"));
			hcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell5=new PdfPCell(new Paragraph("Drop?"));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
		
			
			report.addCell(hcell1);
			report.addCell(hcell2);
			report.addCell(hcell3);
			report.addCell(hcell4);
			report.addCell(hcell5);

			
			Iterator<Customer> iterator = sec.getCust().iterator();
			while(iterator.hasNext()){
				Customer o=iterator.next();
				
				
				PdfPCell cell1=new PdfPCell(new Paragraph(o.getCid()));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell2=new PdfPCell(new Paragraph(o.getFname()));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell3=new PdfPCell(new Paragraph(o.getLname()));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell4=new PdfPCell(new Paragraph(String.valueOf(o.getSignupdate())));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell5=new PdfPCell(new Paragraph(String.valueOf(o.getDropp())));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
				
				report.addCell(cell1);
				report.addCell(cell2);
				report.addCell(cell3);
				report.addCell(cell4);
				report.addCell(cell5);
				
				
				
			}
			
			
		
			PdfPCell bcell1=new PdfPCell(new Paragraph("Customers' #:"));
			bcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell1.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell2=new PdfPCell(new Paragraph(String.valueOf(sec.getCust().size())));
			bcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell2.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell3=new PdfPCell(new Paragraph("Drop Count:"));
			bcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell3.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell4=new PdfPCell(new Paragraph(String.valueOf(sec.getDropcount())));
			bcell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell4.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell5=new PdfPCell(new Paragraph(""));
			bcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell5.setBorder(Rectangle.NO_BORDER);
			
			
			report.addCell(bcell1);
			report.addCell(bcell2);
			report.addCell(bcell3);
			report.addCell(bcell4);
			report.addCell(bcell5);
		
			d.add(report);
			d.close();
			writer.close();
		}
		catch(DocumentException e) {
			e.printStackTrace();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return "xyz";
		
	}
	@Override
	@Transactional
	public int getDropCount(String sexid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Customer o where dropp=1 and o.seuserid=\'"+sexid+"\' and signupdate BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Customer> theQuery=currentSession.createQuery(query,Customer.class);
		List<Customer>o=theQuery.getResultList();
		int count=o.size();
		return count;
	}

}
