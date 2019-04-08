package com.crm.project;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.crm.project.dao.AccountuserDao;
import com.crm.project.dao.CustomerDao;
import com.crm.project.dao.InvoiceDao;
import com.crm.project.dao.LeadAgentUserDao;

import com.crm.project.dao.LeadsDao;
import com.crm.project.dao.OpportunityDao;
import com.crm.project.dao.OrderDao;
import com.crm.project.dao.ProductDao;
import com.crm.project.dao.SalesExecutiveuserDao;
import com.crm.project.dao.SalesuserDao;
import com.crm.project.dao.TasksDao;
import com.crm.project.entity.Accountuser;
import com.crm.project.entity.Customer;
import com.crm.project.entity.Lead;
import com.crm.project.entity.LeadAgentUser;
import com.crm.project.entity.Leads;
import com.crm.project.entity.Opportunity;
import com.crm.project.entity.Order;
import com.crm.project.entity.Product;
import com.crm.project.entity.SalesExecutiveuser;
import com.crm.project.entity.Salesuser;
import com.crm.project.entity.Tasks;
import com.crm.project.sessionbean.Email;


@Controller
@SessionAttributes("id")
public class HomeController {
	@RequestMapping("/")
	public String ShowIndexPage() {
		
		return "index";
	}
	
	@RequestMapping("/logout")
	public String ShowLogoutPage(HttpServletRequest request) {
		 HttpSession httpSession = request.getSession();
         httpSession.invalidate();
         return "index";
		
	}
	
@Autowired
private SalesuserDao salesuserdao;
@RequestMapping("/saleslogin")
public String ShowSalesLoginPage(Model theModel) {
	Salesuser su=new Salesuser();
	
	theModel.addAttribute("salesusers",su);
	String m="";
	theModel.addAttribute("message",m);
	return "saleslogin";
}


@RequestMapping("/SalesPage")

public String SalesPage(@ModelAttribute("salesusers") Salesuser su, ModelMap theModel) {

	String idsalesuser=salesuserdao.getSalesuser(su.getUsername(), su.getPassword());
	
	if(idsalesuser.equals("")) {
		String m="incorrect username/password";
		theModel.addAttribute("message",m);
		return "saleslogin";
		}
	else {
	
		theModel.put("id",idsalesuser);
		
		
		
		return "salesuserhome";
	}
}


@RequestMapping("/salesForgotPassword")
public String ShowSalesForgotPasswordPage(Model theModel) throws Exception {
	Emails e=new Emails();
	theModel.addAttribute("emails",e);
	
	return "forgotSalesPassword";
}
@RequestMapping("/processsalesForgotPassword")
public String ShowProcessSalesForgotPasswordPage(Model theModel,@ModelAttribute("emails") Emails e) throws Exception {
	String passwords=salesuserdao.forgotPassword(e.getTo1(),e.getSuserid());
	if(!passwords.equals("")) {
	try {
		Properties props=System.getProperties();
		String to=e.getTo1();
		String subject="forgot password";
		String message="your password is: \n"+passwords;
		message = message.replace("\n", "<br/>");
			
			e.setFrom("crmsystemspvtltd@gmail.com");
			
			e.setUsername("crmsystemspvtltd");
			e.setPassword("Dada@3232");
			String username=e.getUsername();
			String password=e.getPassword();
			String from=e.getFrom();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.fallback","false");
		Session mailSession=Session.getDefaultInstance(props,null);
		mailSession.setDebug(true);
		Message mailMessage=new MimeMessage(mailSession);
		mailMessage.setFrom(new InternetAddress(from));
		mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mailMessage.setContent(message,"text/html");
		mailMessage.setSubject(subject);
		Transport transport=mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com",username,password);
		transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
		
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
Salesuser su=new Salesuser();
	
	theModel.addAttribute("salesusers",su);
	String m="";
	theModel.addAttribute("message",m);
	return "saleslogin";
}

@RequestMapping("/SalesLeadPage")
public String ShowSalesLeadPage(Model theModel,@ModelAttribute("id") String id) {
	List<Leads>l=leadsdao.getSalesLeads(id); 
	theModel.addAttribute("salesleads",l);
	return "leadsales";
}

@Autowired
private OpportunityDao opportunitydao;
@RequestMapping("/salesTakeOpportunity")
public String ShowOpportunityPage(Model theModel,@ModelAttribute("leadid") String id,@ModelAttribute("id") String sid) throws Exception {
	Leads l=leadsdao.getLead(id);
	leadsdao.updateLead(id);
	opportunitydao.addOpportunity(l,sid);
	List<Opportunity> opp=opportunitydao.getOpportunities(sid);
	theModel.addAttribute("myopp",opp);
	
	return "myOpportunities";
}

@RequestMapping("/salesMyOpportunities")
public String ShowOpportunityPage(Model theModel,@ModelAttribute("id") String sid) throws Exception {

	List<Opportunity> opp=opportunitydao.getOpportunities(sid);
	theModel.addAttribute("myopp",opp);
	
	return "myOpportunities";
}

@RequestMapping("/updateopportunity")
public String ShowUpdateOpportunityPage(Model theModel,@RequestParam("opportunityid")String id) {
	
	Opportunity o=opportunitydao.getOpportunity(id);
	theModel.addAttribute("newopportunity",o);
	return "updateopportunity";
}

@RequestMapping("/processupdateopportunity")
public String ProcessUpdateOpportunityPage(@ModelAttribute("newopportunity") Opportunity o,Model theModel,@ModelAttribute("id") String sid) {
	
	String oid=o.getOpportunityid();

	opportunitydao.updateOpportunity(o,oid);
	List<Opportunity> opp=opportunitydao.getOpportunities(sid);
	theModel.addAttribute("myopp",opp);
	
	return "myOpportunities";
}

@RequestMapping("/dropopportunity")
public String ShowDropOpportunityPage(Model theModel,@RequestParam("opportunityid")String id) {
	
	Opportunity o=opportunitydao.getOpportunity(id);
	theModel.addAttribute("newopportunity",o);
	return "dropopportunity";
}

@RequestMapping("/processdropopportunity")
public String ProcessDropOpportunityPage(@ModelAttribute("newopportunity") Opportunity o,Model theModel,@ModelAttribute("id") String sid) {
	
	String oid=o.getOpportunityid();

	opportunitydao.dropOpportunity(o,oid);
	List<Opportunity> opp=opportunitydao.getOpportunities(sid);
	theModel.addAttribute("myopp",opp);
	
	return "myOpportunities";
}

@RequestMapping("/sendopportunity")
public String ShowSendOpportunityPage(Model theModel,@ModelAttribute("id") String sid,@RequestParam("opportunityid")String id) throws Exception {
	
	String seu=salesexecutiveuserdao.lessOppSalesExecutiveuser();
	opportunitydao.addSexeuser(id,seu);
	salesexecutiveuserdao.incrementoppnumber(seu);
	List<Opportunity> opp=opportunitydao.getOpportunities(sid);
	theModel.addAttribute("myopp",opp);
	
	return "myOpportunities";
}


@Autowired
private SalesExecutiveuserDao salesexecutiveuserdao;
@RequestMapping("/salesexecutivelogin")
public String ShowSalesExecutiveLoginPage(Model theModel) {
	SalesExecutiveuser u=new SalesExecutiveuser();
	theModel.addAttribute("salesexeuser",u);
	String m="";
	theModel.addAttribute("message",m);
	return "salesexecutivelogin";
}

@RequestMapping("/SalesExecutivePage")

public String SalesExecutivePage(@ModelAttribute("salesexeuser") SalesExecutiveuser seu, ModelMap theModel) {

	String idseuser=salesexecutiveuserdao.getSalesExecutiveuser(seu.getUsername(), seu.getPassword());
	
	if(idseuser.equals("")) {
		String m="incorrect username/password";
		theModel.addAttribute("message",m);
		return "salesexecutivelogin";
		}
	else {
	
		theModel.put("id",idseuser);
		
		
		
		return "salesexecutivehome";
	}
}

@RequestMapping("/salesexForgotPassword")
public String ShowSalesexForgotPasswordPage(Model theModel) throws Exception {
	Emails e=new Emails();
	theModel.addAttribute("emails",e);
	
	return "forgotSalesexPassword";
}
@RequestMapping("/processsalesexForgotPassword")
public String ShowProcessSalesexForgotPasswordPage(Model theModel,@ModelAttribute("emails") Emails e) throws Exception {
	String passwords=salesexecutiveuserdao.forgotPassword(e.getTo1(),e.getSeuserid());
	if(!passwords.equals("")) {
	try {
		Properties props=System.getProperties();
		String to=e.getTo1();
		String subject="forgot password";
		String message="your password is: \n"+passwords;
		message = message.replace("\n", "<br/>");
			
			e.setFrom("crmsystemspvtltd@gmail.com");
			
			e.setUsername("crmsystemspvtltd");
			e.setPassword("Dada@3232");
			String username=e.getUsername();
			String password=e.getPassword();
			String from=e.getFrom();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.fallback","false");
		Session mailSession=Session.getDefaultInstance(props,null);
		mailSession.setDebug(true);
		Message mailMessage=new MimeMessage(mailSession);
		mailMessage.setFrom(new InternetAddress(from));
		mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mailMessage.setContent(message,"text/html");
		mailMessage.setSubject(subject);
		Transport transport=mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com",username,password);
		transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
		
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	SalesExecutiveuser u=new SalesExecutiveuser();
	theModel.addAttribute("salesexeuser",u);
	String m="";
	theModel.addAttribute("message",m);
	return "salesexecutivelogin";
}

@RequestMapping("/salesexMyOpportunities")
public String ShowSalesexOpportunityPage(Model theModel,@ModelAttribute("id") String seid) throws Exception {

	List<Opportunity> opp=opportunitydao.getSexopportunity(seid);
	theModel.addAttribute("myopp",opp);
	
	return "salesexopportunities";
}

@RequestMapping("/dropsalesexopportunity")
public String ShowSalesexDropOpportunityPage(Model theModel,@RequestParam("opportunityid")String id) {
	
	Opportunity o=opportunitydao.getOpportunity(id);
	theModel.addAttribute("newopportunity",o);
	return "dropopportunity";
}

@RequestMapping("/processsalesexdropopportunity")
public String ProcessSalesexDropOpportunityPage(@ModelAttribute("newopportunity") Opportunity o,Model theModel,@ModelAttribute("id") String seid) {
	
	String oid=o.getOpportunityid();

	opportunitydao.dropOpportunity(o,oid);
	List<Opportunity> opp=opportunitydao.getOpportunities(seid);
	theModel.addAttribute("myopp",opp);
	
	return "salesexopportunities";
}

@RequestMapping("/salesexSearchOpportunity")
public String ShowSalesexSearchOpportunityPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("oid")String id) throws Exception {

	Opportunity o=opportunitydao.getOpportunity(id);
	theModel.addAttribute("newopportunity",o);
	
	return "viewopportunity";
}

@Autowired
private TasksDao tasksdao;
@RequestMapping("/addsalesextask")
public String ShowAddSalesexTaskPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("opportunityid")String id) throws Exception {

	Tasks t=new Tasks();
	theModel.addAttribute("tasks",t);
	Opportunity opp=opportunitydao.getOpportunity(id);
	theModel.addAttribute("opp",opp);
	return "addSalesexTask";
}

@RequestMapping("/processaddtask")
public String ShowProcessAddTaskPage(Model theModel,@ModelAttribute("id") String seid,@ModelAttribute("tasks") Tasks t) throws Exception {

	tasksdao.addSalesexTask(t);
	List<Tasks> tasks=tasksdao.getSalesexTasks(seid);
	theModel.addAttribute("tasks",tasks);
	return "salesextasks";
}

@RequestMapping("/salesexTasks")
public String ShowSalesexTasksPage(Model theModel,@ModelAttribute("id") String seid) throws Exception {
	
	List<Tasks> tasks=tasksdao.getSalesexTasks(seid);
	theModel.addAttribute("tasks",tasks);
	
	return "salesextasks";
}
@RequestMapping("/dropSalesexTasks")
public String ShowDropSalesexTasksPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("taskid")int tid) throws Exception {
	
	tasksdao.dropTask(tid);
	List<Tasks> tasks=tasksdao.getSalesexTasks(seid);
	theModel.addAttribute("tasks",tasks);
	
	return "salesextasks";
}

@RequestMapping("/updatetask")
public String ShowUpdateTaskPage(Model theModel,@RequestParam("taskid")int tid) {
	
	
	Tasks t=tasksdao.getTask(tid);
	theModel.addAttribute("newtask",t);
	return "updatetask";
}

@RequestMapping("/processupdatetask")
public String ProcessUpdateTaskPage(@ModelAttribute("newtask") Tasks t,Model theModel,@ModelAttribute("id") String seid) {
	
	int tid=t.getIdtasks();
	tasksdao.updateTask(tid, t);
	List<Tasks> tasks=tasksdao.getSalesexTasks(seid);
	theModel.addAttribute("tasks",tasks);

	
	return "salesextasks";
}



@RequestMapping("/salesexMyTasks")
public String ShowSalesexMyTasksPage(Model theModel,@ModelAttribute("id") String seid) throws Exception {
	
	List<Tasks> tasks=tasksdao.getSalesexmyTasks(seid);
	theModel.addAttribute("tasks",tasks);
	
	return "mytasks";
}

@RequestMapping("/dropSalesexMyTasks")
public String ShowDropSalesexMyTasksPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("taskid")int tid) throws Exception {
	
	tasksdao.dropTask(tid);
	List<Tasks> tasks=tasksdao.getSalesexmyTasks(seid);
	theModel.addAttribute("tasks",tasks);
	
	return "mytasks";
}



@RequestMapping("/sendEmail")
public String ShowSendEmailPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("taskid")int tid) {
	
	Tasks t=tasksdao.getTask(tid);
	Opportunity o=opportunitydao.getOpportunity(t.getOid());
	String to=o.getEmailid();
	
	Emails e1=new Emails();
	e1.setTo1(to);
	e1.setTaskid(tid);
	theModel.addAttribute("emails",e1);
	
	return "email";
}


@RequestMapping("/processemail")
public String ShowProcessEmailPage(Model theModel,@ModelAttribute("id") String seid,@ModelAttribute("emails") Emails e1) {
	
	try {
		Properties props=System.getProperties();
		String to=e1.getTo1();
		String subject=e1.getSubject();
		String message=e1.getMessage();
		message = message.replace("\n", "<br/>");
			
			Emails e2=salesexecutiveuserdao.getEmailsid(seid);
			e1.setFrom(e2.getFrom());
			e1.setUsername(e2.getUsername());
			e1.setPassword(e2.getPassword());
			String username=e1.getUsername();
			String password=e1.getPassword();
			String from=e1.getFrom();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.fallback","false");
		Session mailSession=Session.getDefaultInstance(props,null);
		mailSession.setDebug(true);
		Message mailMessage=new MimeMessage(mailSession);
		mailMessage.setFrom(new InternetAddress(from));
		mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mailMessage.setContent(message,"text/html");
		mailMessage.setSubject(subject);
		Transport transport=mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com",username,password);
		transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		tasksdao.sendReminderTask(e1.getTaskid());
		List<Tasks> tasks=tasksdao.getSalesexmyTasks(seid);
		theModel.addAttribute("tasks",tasks);
		
		return "mytasks";
}

@RequestMapping("/salesexReminders")
public String ShowSalesexRemindersPage(Model theModel,@ModelAttribute("id") String seid) throws Exception {
	
	List<Tasks> tasks=tasksdao.getSalesexTodayTasks(seid);
	theModel.addAttribute("reminders",tasks);
	
	return "salesexreminders";
}
@RequestMapping("/dropRemindersalesexTasks")
public String ShowDropReminderSalesexTasksPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("taskid")int tid) throws Exception {
	
	tasksdao.dropTask(tid);
	List<Tasks> tasks=tasksdao.getSalesexTodayTasks(seid);
	theModel.addAttribute("reminders",tasks);
	
	return "salesexreminders";
}
@RequestMapping("/addCustomer")
public String ShowAddCustomerPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("oppid")String oppid,@RequestParam("taskid")int tid) throws Exception {
	
	Opportunity o=opportunitydao.getOpportunity(oppid);
	Customer c=new Customer();
	c.setSeuserid(seid);
	c.setCity(o.getCity());
	c.setContact_number(o.getContact_number());
	c.setFname(o.getNames());
	c.setLname(o.getNames2());
	c.setEmailid(o.getEmailid());
	c.setSalesuserid(o.getSuserid());
	c.setOppid(o.getOpportunityid());
	java.util.Date date=new java.util.Date();
	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
	java.sql.Date doc=java.sql.Date.valueOf(formatter.format(date));
	c.setSignupdate(doc);
	theModel.addAttribute("newcustomer",c);
	theModel.addAttribute("tid",tid);
	return "addcustomer";
}

@Autowired
CustomerDao customerdao;
@RequestMapping("/processAddCustomer")
public String ShowProcessAddCustomerPage(Model theModel,@ModelAttribute("id") String seid,@ModelAttribute("newcustomer") Customer c,@RequestParam("tid")int tid) throws Exception {
	
	customerdao.addCustomer(c);
	tasksdao.completeTask(tid);
	
	return "salesexecutivehome";
}

@RequestMapping("/mySalesexCustomers")
public String ShowMySalesexCustomersPage(Model theModel,@ModelAttribute("id") String seid) throws Exception {

	List<Customer> mycustomers=customerdao.getSalesexCustomers(seid);
	theModel.addAttribute("mycustomers",mycustomers);
	
	
	return "mycustomers";
}

@RequestMapping("/uploadFile")
public String ShowUploadFilePage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("cid")String cid) throws Exception {
	Customer c=customerdao.getCustomer(cid);
	theModel.addAttribute("cid",cid);
	
	
	return "uploadFile";
}

@RequestMapping("/processUploadFile")
public String ShowProcessUploadFilePage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("cid")String cid,@RequestParam("idproof")MultipartFile file) throws Exception {
	if(!file.isEmpty()) {
		try {
			byte[]bytes=file.getBytes();
			File serverFile=new File("C:/Users/charm/eclipse-workspace/spring-crm/WebContent/resources/customeridproof/"+cid+".pdf");
			BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		}
		catch(Exception e) {
			
		}
	}
	
	List<Customer> mycustomers=customerdao.getSalesexCustomers(seid);
	theModel.addAttribute("mycustomers",mycustomers);
	
	
	return "mycustomers";
}


@Autowired
OrderDao orderdao;

@Autowired
ProductDao productdao;

@Autowired
InvoiceDao invoicedao;

@RequestMapping("/addOrder")
public String ShowAddOrderPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("cid")String cid) throws Exception {

	Order o=new Order();
	o.setCustoid(cid);
	List<Product> p=productdao.getProducts();
	theModel.addAttribute("neworder",o);
	theModel.addAttribute("products",p);
	
	
	
	return "addOrder";
}

@Autowired
AccountuserDao accountuserdao;
@RequestMapping("/processAddOrder")
public String ShowProcessAddOrderPage(Model theModel,@ModelAttribute("id") String seid,@ModelAttribute("neworder")Order o) throws Exception {

	Product p=productdao.getProduct(o.getPid());
	o.setAmount(p.getAmount());
	String ac=accountuserdao.lessOrderAccountuser();
	o.setAccountusers(ac);
	
	orderdao.addOrder(o);
	
	accountuserdao.incrementordernumber(ac);
	
	List<Customer> mycustomers=customerdao.getSalesexCustomers(seid);
	theModel.addAttribute("mycustomers",mycustomers);
	return "mycustomers";
}

@RequestMapping("/viewOrders")
public String ShowViewOrdersPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("cid")String cid) throws Exception {

	List<Order> orders=orderdao.getCustomerOrders(cid);
	theModel.addAttribute("orders",orders);
	return "viewOrders";
}
@RequestMapping("/getInvoice")
public void ShowGetInvoicePage(HttpServletRequest request,Model theModel,@ModelAttribute("id") String seid,@RequestParam("ordid")String ordid, HttpServletResponse response) throws Exception {

	Order o=orderdao.getOrder(ordid);
	if(o.getInvoices()==0) {
		invoicedao.addInvoice(ordid);
	}
	
	String invoiceid=invoicedao.getInvoiceid(ordid);
	invoicedao.getInvoiceItext(invoiceid);
	response.setContentType("application/pdf");
	response.addHeader("content-disposition", "attachment; filename="+invoiceid+".pdf");
	String dataDirectory = request.getServletContext().getRealPath("/WebContent/resources/");
	Path file = Paths.get("C:/Users/charm/eclipse-workspace/spring-crm/WebContent/resources/", invoiceid+".pdf");
	try
    {
        Files.copy(file, response.getOutputStream());
        response.getOutputStream().flush();
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
	
	
}

@RequestMapping("/getReports")
public String ShowGetReportsPage(Model theModel,@ModelAttribute("id") String seid) throws Exception {
	
	
	return "getReports";
}

@RequestMapping("/getOppReports")
public void ShowGetOppReportsPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("from")java.sql.Date from,@RequestParam("to")java.sql.Date to,HttpServletRequest request,HttpServletResponse response) throws Exception {
	String x=opportunitydao.getOppReport(seid, from, to);response.setContentType("application/pdf");
	response.addHeader("content-disposition", "attachment; filename="+from+"_"+to+".pdf");
	String dataDirectory = request.getServletContext().getRealPath("/WebContent/resources/");
	Path file = Paths.get("C:/Users/charm/eclipse-workspace/spring-crm/WebContent/resources/reports/salesexecutive/"+seid+"/OPPORTUNITY/", from+"_"+to+".pdf");
	try
    {
        Files.copy(file, response.getOutputStream());
        response.getOutputStream().flush();
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
	

}

@RequestMapping("/getCustReports")
public void ShowGetCustReportsPage(Model theModel,@ModelAttribute("id") String seid,@RequestParam("from")java.sql.Date from,@RequestParam("to")java.sql.Date to,HttpServletRequest request,HttpServletResponse response) throws Exception {
	String x=customerdao.getCustReport(seid, from, to);response.setContentType("application/pdf");
	response.addHeader("content-disposition", "attachment; filename="+from+"_"+to+".pdf");
	String dataDirectory = request.getServletContext().getRealPath("/WebContent/resources/");
	Path file = Paths.get("C:/Users/charm/eclipse-workspace/spring-crm/WebContent/resources/reports/salesexecutive/"+seid+"/CUSTOMER/", from+"_"+to+".pdf");
	try
    {
        Files.copy(file, response.getOutputStream());
        response.getOutputStream().flush();
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
	

}

@RequestMapping("/leadagentlogin")
public String ShowLeadAgentLoginPage(Model theModel) {
	//List<LeadAgentUser> theusers=leadagentdao.getLeadAgentUser();
	LeadAgentUser leadagentusers=new LeadAgentUser();
	/*	LeadAgentLogin u=new LeadAgentLogin();
	theModel.addAttribute("leadagentuser",u); */
	theModel.addAttribute("leadagentusers",leadagentusers);
	String m="";
	theModel.addAttribute("message",m);
	return "leadagentlogin";
}

@Autowired
private LeadAgentUserDao leadagentdao;

@RequestMapping("/leadAgentPage")

public String leadAgentPage(@ModelAttribute("leadagentusers") LeadAgentUser u, ModelMap theModel) {

	String agentid=leadagentdao.getLeadAgentUser(u.getUname(), u.getPassword());
	String minlead=new String("hello");
	if(agentid.equals("")) {
		String m="incorrect username/password";
		theModel.addAttribute("message",m);
		return "leadagentlogin";
		}
	else {
	
		theModel.put("id",agentid);
		
		
		theModel.addAttribute("sales",minlead);
		return "leadagentuserhome";
	}
}
@RequestMapping("/leadAgentForgotPassword")
public String ShowLeadAgentForgotPasswordPage(Model theModel) throws Exception {
	Emails e=new Emails();
	theModel.addAttribute("emails",e);
	
	return "forgotLeadAgentPassword";
}
@RequestMapping("/processLeadAgentForgotPassword")
public String ShowProcessLeadAgentForgotPasswordPage(Model theModel,@ModelAttribute("emails") Emails e) throws Exception {
	String passwords=leadagentdao.forgotPassword(e.getTo1(),e.getLeaduserid());
	if(!passwords.equals("")) {
	try {
		Properties props=System.getProperties();
		String to=e.getTo1();
		String subject="forgot password";
		String message="your password is: \n"+passwords;
		message = message.replace("\n", "<br/>");
			
			e.setFrom("crmsystemspvtltd@gmail.com");
			
			e.setUsername("crmsystemspvtltd");
			e.setPassword("Dada@3232");
			String username=e.getUsername();
			String password=e.getPassword();
			String from=e.getFrom();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.fallback","false");
		Session mailSession=Session.getDefaultInstance(props,null);
		mailSession.setDebug(true);
		Message mailMessage=new MimeMessage(mailSession);
		mailMessage.setFrom(new InternetAddress(from));
		mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mailMessage.setContent(message,"text/html");
		mailMessage.setSubject(subject);
		Transport transport=mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com",username,password);
		transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
		
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	LeadAgentUser leadagentusers=new LeadAgentUser();
	theModel.addAttribute("leadagentusers",leadagentusers);
	String m="";
	theModel.addAttribute("message",m);
	return "leadagentlogin";

}

@RequestMapping("/example")
public String examplePage(ModelMap theModel) {
	String minlead=salesuserdao.lessLeadSalesuser();
	theModel.addAttribute("sales",minlead);
	salesuserdao.incrementleadnumber(minlead);
	return "example";
	}

@RequestMapping("/processPage")
public String processPage(@ModelAttribute("salesuser") SalesLogin u) {
	if(u.getUsername().equals("yug")) {return "salesuserhome";}
	else {
		u.setMessage("invalid");
		return "saleslogin";
	}
}



@RequestMapping("/addlead")
public String ShowAddLeadPage(Model theModel) {

	Leads nl=new Leads();
	theModel.addAttribute("newlead",nl);
	return "addlead";
}
@Autowired
private LeadsDao leadsdao;
@RequestMapping("/processlead")
public String ProcessLeadPage(@ModelAttribute("newlead") Leads u,Model theModel,@ModelAttribute("id") String id) throws Exception {
	String minlead=salesuserdao.lessLeadSalesuser();
	u.setLeadsuserid(minlead);
	salesuserdao.incrementleadnumber(minlead);
	leadsdao.addLead(u);
	List<Leads>l=leadsdao.getLeads(id); 
	theModel.addAttribute("leads",l);
	return "lead";
}

@RequestMapping("/lead")
public String ShowLeadPage(Model theModel,@ModelAttribute("id") String id) {
	List<Leads>l=leadsdao.getLeads(id); 
	theModel.addAttribute("leads",l);
	return "lead";
}

@RequestMapping("/updatelead")
public String ShowUpdateLeadPage(Model theModel,@RequestParam("leadid")String id) {
	Leads l=leadsdao.getLead(id);
	theModel.addAttribute("newlead",l);
	return "updatelead";
}
@RequestMapping("/processupdatelead")
public String ProcessUpdateLeadPage(@ModelAttribute("newlead") Leads lead,Model theModel) {
	String leadid=lead.getLeadid();
	String agentid=lead.getAgentid();
	theModel.addAttribute("id",agentid);
	leadsdao.updateLead(lead,leadid);
	//theModel.addAttribute("id",lead.getAgentid());
	List<Leads>l=leadsdao.getLeads(lead.getAgentid()); 
	theModel.addAttribute("leads",l);
	return "lead";
}


@RequestMapping("/accountuserlogin")
public String ShowAccountUserLoginPage(Model theModel) {
	//Accountuser au=new Accountuser();
	
	theModel.addAttribute("accountusers",new Accountuser());
	String m="";
	theModel.addAttribute("message",m);
	return "accountuserlogin";
}


@RequestMapping("/AccountUserPage")

public String ShowAccountUserPage(@ModelAttribute("accountusers") Accountuser au, ModelMap theModel) {

	String idacuser=accountuserdao.getAccountuser(au.getUsername(), au.getPassword());
	
	if(idacuser.equals("")) {
		String m="incorrect username/password";
		theModel.addAttribute("message",m);
		return "accountuserlogin";
		}
	else {
	
		theModel.put("id",idacuser);
		
		
		
		return "accountuserhome";
	}
}

@RequestMapping("/pendingPayments")
public String ShowPendingPaymentsPage(Model theModel,@ModelAttribute("id") String idacuser) throws Exception {

	List<Order> orders=orderdao.getPending(idacuser);
	theModel.addAttribute("orders",orders);
	return "pendingPayments";
}
@RequestMapping("/overduePayments")
public String ShowOverduePaymentsPage(Model theModel,@ModelAttribute("id") String idacuser) throws Exception {

	List<Order> orders=orderdao.getOverdue(idacuser);
	theModel.addAttribute("orders",orders);
	return "overduePayments";
}
@RequestMapping("/viewCustomer")
public String ShowViewCustomerPage(Model theModel,@ModelAttribute("id") String idacuser,@RequestParam("cid")String cid) throws Exception {

	Customer c=customerdao.getCustomer(cid);
	theModel.addAttribute("customer",c);
	return "viewCustomer";
}

@RequestMapping("/addPayment")
public String ShowAddPaymentPage(Model theModel,@ModelAttribute("id") String idacuser,@RequestParam("ordid")String ordid) throws Exception {

	Order o=orderdao.getOrder(ordid);
	theModel.addAttribute("order",o);
	return "addPayment";
}
@RequestMapping("/processAddPayment")
public String ShowProcessAddPaymentPage(Model theModel,@ModelAttribute("id") String idacuser,@ModelAttribute("order") Order order) throws Exception {

	orderdao.addPayment(order.getIdorder(), order);
	List<Order> orders=orderdao.getPending(idacuser);
	theModel.addAttribute("orders",orders);
	return "pendingPayments";
}


}
