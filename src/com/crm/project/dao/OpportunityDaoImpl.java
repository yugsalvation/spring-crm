package com.crm.project.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.project.SReportsOpp;
import com.crm.project.SeReportsOpp;
import com.crm.project.entity.Leads;
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
public class OpportunityDaoImpl implements OpportunityDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Opportunity> getOpportunities(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.suserid=\'"+id+"\' and dropp=0 and sexuserid IS NULL";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		return o;
	}

	@Override
	@Transactional
	public List<Opportunity> getSexopportunity(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.sexuserid=\'"+id+"\' and customer=0";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		return o;
	}
	
	@Override
	@Transactional
	public List<Opportunity> getSexDateopportunity(String id, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where customer=0 and o.sexuserid=\'"+id+"\' and doc BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		return o;
	}

	@Override
	@Transactional
	public void addOpportunity(Leads lead,String salesuserid) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Opportunity newOpportunity=new Opportunity();
		
		newOpportunity.setLid(lead.getLeadid());
		newOpportunity.setNames(lead.getNames());
		newOpportunity.setNames2(lead.getNames2());
		newOpportunity.setCity(lead.getCity());
		newOpportunity.setContact_number(lead.getContact_number());
		newOpportunity.setWalking_date(lead.getWalking_date());
		newOpportunity.setEmailid(lead.getEmailid());
		newOpportunity.setSuserid(salesuserid);
		newOpportunity.setOpportunityid("hello");
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
		newOpportunity.setDoc(doc);
		currentSession.save(newOpportunity);

	}

	@Override
	@Transactional
	public Opportunity getOpportunity(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.opportunityid=\'"+id+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		Opportunity o=theQuery.getSingleResult();
		return o;
	}

	@Override
	@Transactional
	public void updateOpportunity(Opportunity o, String opportunityid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set description=\'"+o.getDescription()+"\' where opportunityid=\'"+opportunityid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();

	}
	
	@Override
	@Transactional
	public void updateLeadOpportunity(Opportunity o, String leadid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set names=\'"+o.getNames()+"\',names2=\'"+o.getNames2()+"\',contact_number=\'"+o.getContact_number()+"\',city=\'"+o.getCity()+"\',emailid=\'"+o.getEmailid()+"\',walking_date=\'"+o.getWalking_date()+"\' where lid=\'"+leadid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void dropOpportunity(Opportunity o, String opportunityid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set dropp=1,description=\'"+o.getDescription()+"\' where opportunityid=\'"+opportunityid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void addSexeuser(String oid, String sexid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set sexuserid=\'"+sexid+"\' where opportunityid=\'"+oid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void addCustomer(String oid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Opportunity set customer=1 where opportunityid=\'"+oid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public int getDropCount(String sexid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where dropp=1 and o.sexuserid=\'"+sexid+"\' and doc BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		int count=o.size();
		return count;
	}

	@Override
	@Transactional
	public int getCustomerCount(String sexid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where customer=1 and o.sexuserid=\'"+sexid+"\' and doc BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		int count=o.size();
		return count;
	}

	@Override
	@Transactional
	public SeReportsOpp getSeReportsOpp(String sexid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.sexuserid=\'"+sexid+"\' and doc BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		SeReportsOpp se=new SeReportsOpp();
		se.setOpp(o);
		se.setCustomercount(getCustomerCount(sexid,from,to));
		se.setDropcount(getDropCount(sexid,from,to));
		se.setFrom(from);
		se.setTo(to);
		
		return se;
	}

	@Override
	@Transactional
	public String getOppReport(String sexid, Date from, Date to) {
		SeReportsOpp se=getSeReportsOpp(sexid,from,to);
		Document d=new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\WebContent\\resources\\reports\\salesexecutive\\"+sexid+"\\OPPORTUNITY\\"+from+"_"+to+".pdf"));
			d.open();
			d.add(new Paragraph("CRM SYSTEMS"));
			PdfPTable report=new PdfPTable(6);
			report.setSpacingBefore(40f);
			report.setWidthPercentage(100);
			PdfPCell hcell1=new PdfPCell(new Paragraph("OID"));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell2=new PdfPCell(new Paragraph("Fname"));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell3=new PdfPCell(new Paragraph("Lname"));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell4=new PdfPCell(new Paragraph("Doc"));
			hcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell5=new PdfPCell(new Paragraph("Drop?"));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell6=new PdfPCell(new Paragraph("Customer?"));
			hcell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			report.addCell(hcell1);
			report.addCell(hcell2);
			report.addCell(hcell3);
			report.addCell(hcell4);
			report.addCell(hcell5);
			report.addCell(hcell6);
			
			Iterator<Opportunity> iterator = se.getOpp().iterator();
			while(iterator.hasNext()){
				Opportunity o=iterator.next();
				
				
				PdfPCell cell1=new PdfPCell(new Paragraph(o.getOpportunityid()));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell2=new PdfPCell(new Paragraph(o.getNames()));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell3=new PdfPCell(new Paragraph(o.getNames2()));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell4=new PdfPCell(new Paragraph(String.valueOf(o.getDoc())));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell5=new PdfPCell(new Paragraph(String.valueOf(o.getDropp())));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell6=new PdfPCell(new Paragraph(String.valueOf(o.getCustomer())));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				report.addCell(cell1);
				report.addCell(cell2);
				report.addCell(cell3);
				report.addCell(cell4);
				report.addCell(cell5);
				report.addCell(cell6);
				
				
			}
			
			
		
			PdfPCell bcell1=new PdfPCell(new Paragraph("Customers' #:"));
			bcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell1.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell2=new PdfPCell(new Paragraph(String.valueOf(se.getCustomercount())));
			bcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell2.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell3=new PdfPCell(new Paragraph("Drop Count:"));
			bcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell3.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell4=new PdfPCell(new Paragraph(String.valueOf(se.getDropcount())));
			bcell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell4.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell5=new PdfPCell(new Paragraph("Total Count:"));
			bcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell5.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell6=new PdfPCell(new Paragraph(String.valueOf(se.getOpp().size())));
			bcell6.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell6.setBorder(Rectangle.NO_BORDER);
			
			report.addCell(bcell1);
			report.addCell(bcell2);
			report.addCell(bcell3);
			report.addCell(bcell4);
			report.addCell(bcell5);
			report.addCell(bcell6);
			
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
	public SReportsOpp getSReportsOpp(String seid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where o.suserid=\'"+seid+"\' and doc BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		SReportsOpp se=new SReportsOpp();
		se.setOpp(o);
		
		se.setDropcount(getSDropCount(seid,from,to));
		se.setFrom(from);
		se.setTo(to);
		
		return se;
	}

	@Override
	@Transactional
	public String getSOppReport(String seid, Date from, Date to) {
		SReportsOpp se=getSReportsOpp(seid,from,to);
		Document d=new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\WebContent\\resources\\reports\\salesemployee\\"+seid+"\\OPPORTUNITY\\"+from+"_"+to+".pdf"));
			d.open();
			d.add(new Paragraph("CRM SYSTEMS"));
			PdfPTable report=new PdfPTable(6);
			report.setSpacingBefore(40f);
			report.setWidthPercentage(100);
			PdfPCell hcell1=new PdfPCell(new Paragraph("OID"));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell2=new PdfPCell(new Paragraph("Fname"));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell3=new PdfPCell(new Paragraph("Lname"));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell4=new PdfPCell(new Paragraph("Doc"));
			hcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell5=new PdfPCell(new Paragraph("Drop?"));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell6=new PdfPCell(new Paragraph("SEuserid"));
			hcell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			report.addCell(hcell1);
			report.addCell(hcell2);
			report.addCell(hcell3);
			report.addCell(hcell4);
			report.addCell(hcell5);
			report.addCell(hcell6);
			
			Iterator<Opportunity> iterator = se.getOpp().iterator();
			while(iterator.hasNext()){
				Opportunity o=iterator.next();
				
				
				PdfPCell cell1=new PdfPCell(new Paragraph(o.getOpportunityid()));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell2=new PdfPCell(new Paragraph(o.getNames()));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell3=new PdfPCell(new Paragraph(o.getNames2()));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell4=new PdfPCell(new Paragraph(String.valueOf(o.getDoc())));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell5=new PdfPCell(new Paragraph(String.valueOf(o.getDropp())));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell6=new PdfPCell(new Paragraph(String.valueOf(o.getSexuserid())));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				report.addCell(cell1);
				report.addCell(cell2);
				report.addCell(cell3);
				report.addCell(cell4);
				report.addCell(cell5);
				report.addCell(cell6);
				
				
			}
			
			
		
			PdfPCell bcell1=new PdfPCell(new Paragraph(""));
			bcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell1.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell2=new PdfPCell(new Paragraph(""));
			bcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell2.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell3=new PdfPCell(new Paragraph("# of opp dropped by you:"));
			bcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell3.setBorder(Rectangle.NO_BORDER);
			bcell3.setColspan(2);
			PdfPCell bcell4=new PdfPCell(new Paragraph(String.valueOf(se.getDropcount())));
			bcell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell4.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell5=new PdfPCell(new Paragraph("Total Count:"));
			bcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell5.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell6=new PdfPCell(new Paragraph(String.valueOf(se.getOpp().size())));
			bcell6.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell6.setBorder(Rectangle.NO_BORDER);
			
			report.addCell(bcell3);
			report.addCell(bcell4);
			
			report.addCell(bcell5);
			report.addCell(bcell6);
			report.addCell(bcell1);
			
			
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
	public int getSDropCount(String seid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Opportunity o where dropp=1 and sexuserid IS NULL and o.suserid=\'"+seid+"\' and doc BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		int count=o.size();
		return count;
	}

	@Override
	@Transactional
	public List<Opportunity> getSearchSexopportunity(String id,String key) {
		Session currentSession=sessionFactory.getCurrentSession();
		key="%"+key+"%";
		String query="from Opportunity o where o.sexuserid=\'"+id+"\' and (opportunityid like \'"+key+"\' or names like \'"+key+"\' or names2 like \'"+key+"\' or emailid like \'"+key+"\' or city like \'"+key+"\') and customer=0 and dropp=0";
		Query <Opportunity> theQuery=currentSession.createQuery(query,Opportunity.class);
		List<Opportunity>o=theQuery.getResultList();
		return o;
	}

	

	

	

}
