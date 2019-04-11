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

import com.crm.project.LAReports;
import com.crm.project.SReportsLeads;
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
public class LeadsDaoImpl implements LeadsDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional

	public List<Leads> getLeads(String id) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads l where agentid=\'"+id+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		List<Leads>l=theQuery.getResultList();
		return l;
	}
	
	@Override
	@Transactional
	public List<Leads> getSalesLeads(String id) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads l where opp=0 and leadsuserid=\'"+id+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		List<Leads>l=theQuery.getResultList();
		return l;
	}

	@Override
	@Transactional
	public void addLead(Leads newLead) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		newLead.setLeadid("hello");
		currentSession.save(newLead);

	}

	@Override
	@Transactional
	public Leads getLead(String id) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads l where leadid=\'"+id+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		Leads l=theQuery.getSingleResult();
		return l;
		
	}
	
	@Override
	@Transactional
	public void updateLead(Leads l,String leadid)
	{
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Leads set names=\'"+l.getNames()+"\',names2=\'"+l.getNames2()+"\',walking_date=\'"+l.getWalking_date()+"\',emailid=\'"+l.getEmailid()+"\',contact_number="+l.getContact_number()+",city=\'"+l.getCity()+"\' where leadid=\'"+leadid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public void updateLead(String leadid) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="update Leads set opp=1 where leadid=\'"+leadid+"\'";
		Query theQuery=currentSession.createQuery(query);
		int result=theQuery.executeUpdate();
		
	}


	@Override
	@Transactional
	public int getOppCount(String sid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads o where opp=1 and o.leadsuserid=\'"+sid+"\' and o.walking_date BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		List<Leads>o=theQuery.getResultList();
		int count=o.size();
		return count;
	}

	@Override
	@Transactional
	public SReportsLeads getSReportsLeads(String sid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads o where o.leadsuserid=\'"+sid+"\' and o.walking_date BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		List<Leads>o=theQuery.getResultList();
		SReportsLeads se=new SReportsLeads();
		se.setLeads(o);
		se.setOppcount(getOppCount(sid,from,to));
		se.setFrom(from);
		se.setTo(to);
		return se;
	}

	@Override
	@Transactional
	public String getSLeadsReport(String sid, Date from, Date to) {
		SReportsLeads se=getSReportsLeads(sid,from,to);
		Document d=new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\WebContent\\resources\\reports\\salesemployee\\"+sid+"\\LEADS\\"+from+"_"+to+".pdf"));
			d.open();
			d.add(new Paragraph("CRM SYSTEMS"));
			PdfPTable report=new PdfPTable(5);
			report.setSpacingBefore(40f);
			report.setWidthPercentage(100);
			PdfPCell hcell1=new PdfPCell(new Paragraph("LeadId"));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell2=new PdfPCell(new Paragraph("Fname"));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell3=new PdfPCell(new Paragraph("Lname"));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell4=new PdfPCell(new Paragraph("WalkingDate"));
			hcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell5=new PdfPCell(new Paragraph("Opp?"));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			report.addCell(hcell1);
			report.addCell(hcell2);
			report.addCell(hcell3);
			report.addCell(hcell4);
			report.addCell(hcell5);
		
			
			Iterator<Leads> iterator = se.getLeads().iterator();
			while(iterator.hasNext()){
				Leads o=iterator.next();
				
				
				PdfPCell cell1=new PdfPCell(new Paragraph(o.getLeadid()));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell2=new PdfPCell(new Paragraph(o.getNames()));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell3=new PdfPCell(new Paragraph(o.getNames2()));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell4=new PdfPCell(new Paragraph(String.valueOf(o.getWalking_date())));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell5=new PdfPCell(new Paragraph(String.valueOf(o.getOpp())));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				
		
				
				report.addCell(cell1);
				report.addCell(cell2);
				report.addCell(cell3);
				report.addCell(cell4);
				report.addCell(cell5);
			
				
				
			}
			
			
		
			PdfPCell bcell1=new PdfPCell(new Paragraph("Opportunity' #:"));
			bcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell1.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell2=new PdfPCell(new Paragraph(String.valueOf(se.getOppcount())));
			bcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell2.setBorder(Rectangle.NO_BORDER);
			
			
			
			PdfPCell bcell5=new PdfPCell(new Paragraph("Total Count:"));
			bcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell5.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell6=new PdfPCell(new Paragraph(String.valueOf(se.getLeads().size())));
			bcell6.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell6.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell7=new PdfPCell(new Paragraph(""));
			bcell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell7.setBorder(Rectangle.NO_BORDER);
			
			
			report.addCell(bcell1);
			report.addCell(bcell2);
	
			report.addCell(bcell5);
			report.addCell(bcell6);
			report.addCell(bcell7);
			
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
	public LAReports getLAReports(String luserid, Date from, Date to) {
		Session currentSession=sessionFactory.getCurrentSession();
		String query="from Leads o where o.agentid=\'"+luserid+"\' and o.walking_date BETWEEN \'"+from+"\' and \'"+to+"\'";
		Query <Leads> theQuery=currentSession.createQuery(query,Leads.class);
		List<Leads>o=theQuery.getResultList();
		LAReports se=new LAReports();
		se.setLeads(o);
		
		se.setFrom(from);
		se.setTo(to);
		return se;
	}

	@Override
	@Transactional
	public String getLAReport(String luserid, Date from, Date to) {
		LAReports se=getLAReports(luserid,from,to);
		Document d=new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(d,new FileOutputStream("C:\\Users\\charm\\eclipse-workspace\\spring-crm\\WebContent\\resources\\reports\\leadagent\\"+luserid+"\\"+from+"_"+to+".pdf"));
			d.open();
			d.add(new Paragraph("CRM SYSTEMS"));
			PdfPTable report=new PdfPTable(5);
			report.setSpacingBefore(40f);
			report.setWidthPercentage(100);
			PdfPCell hcell1=new PdfPCell(new Paragraph("LeadId"));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell2=new PdfPCell(new Paragraph("Fname"));
			hcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell3=new PdfPCell(new Paragraph("Lname"));
			hcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell4=new PdfPCell(new Paragraph("WalkingDate"));
			hcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell hcell5=new PdfPCell(new Paragraph("Contact"));
			hcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			report.addCell(hcell1);
			report.addCell(hcell2);
			report.addCell(hcell3);
			report.addCell(hcell4);
			report.addCell(hcell5);
		
			
			Iterator<Leads> iterator = se.getLeads().iterator();
			while(iterator.hasNext()){
				Leads o=iterator.next();
				
				
				PdfPCell cell1=new PdfPCell(new Paragraph(o.getLeadid()));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell2=new PdfPCell(new Paragraph(o.getNames()));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell3=new PdfPCell(new Paragraph(o.getNames2()));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell4=new PdfPCell(new Paragraph(String.valueOf(o.getWalking_date())));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell5=new PdfPCell(new Paragraph(String.valueOf(o.getContact_number())));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				
		
				
				report.addCell(cell1);
				report.addCell(cell2);
				report.addCell(cell3);
				report.addCell(cell4);
				report.addCell(cell5);
			
				
				
			}
			
			
		
			PdfPCell bcell1=new PdfPCell(new Paragraph(""));
			bcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell1.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell2=new PdfPCell(new Paragraph(String.valueOf("")));
			bcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell2.setBorder(Rectangle.NO_BORDER);
			
			
			
			PdfPCell bcell5=new PdfPCell(new Paragraph("Total Count:"));
			bcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell5.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell6=new PdfPCell(new Paragraph(String.valueOf(se.getLeads().size())));
			bcell6.setHorizontalAlignment(Element.ALIGN_LEFT);
			bcell6.setBorder(Rectangle.NO_BORDER);
			
			PdfPCell bcell7=new PdfPCell(new Paragraph(""));
			bcell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			bcell7.setBorder(Rectangle.NO_BORDER);
			
			
			report.addCell(bcell5);
			report.addCell(bcell6);
			report.addCell(bcell1);
			report.addCell(bcell2);
	
			
			report.addCell(bcell7);
			
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

	
}
