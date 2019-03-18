package com.crm.project;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crm.project.dao.LeadAgentUserDao;

import com.crm.project.dao.LeadsDao;
import com.crm.project.dao.OpportunityDao;
import com.crm.project.dao.SalesExecutiveuserDao;
import com.crm.project.dao.SalesuserDao;
import com.crm.project.dao.TasksDao;
import com.crm.project.entity.Lead;
import com.crm.project.entity.LeadAgentUser;
import com.crm.project.entity.Leads;
import com.crm.project.entity.Opportunity;
import com.crm.project.entity.SalesExecutiveuser;
import com.crm.project.entity.Salesuser;
import com.crm.project.entity.Tasks;

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
	
	return "saleslogin";
}


@RequestMapping("/SalesPage")

public String SalesPage(@ModelAttribute("salesusers") Salesuser su, ModelMap theModel) {

	String idsalesuser=salesuserdao.getSalesuser(su.getUsername(), su.getPassword());
	
	if(idsalesuser.equals("")) {
		//u.setMessage("invalid");
		return "saleslogin";
		}
	else {
	
		theModel.put("id",idsalesuser);
		
		
		
		return "salesuserhome";
	}
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
	return "salesexecutivelogin";
}

@RequestMapping("/SalesExecutivePage")

public String SalesExecutivePage(@ModelAttribute("salesexeuser") SalesExecutiveuser seu, ModelMap theModel) {

	String idseuser=salesexecutiveuserdao.getSalesExecutiveuser(seu.getUsername(), seu.getPassword());
	
	if(idseuser.equals("")) {
		//u.setMessage("invalid");
		return "salesexecutivelogin";
		}
	else {
	
		theModel.put("id",idseuser);
		
		
		
		return "salesexecutivehome";
	}
}

@RequestMapping("/salesexMyOpportunities")
public String ShowSalesexOpportunityPage(Model theModel,@ModelAttribute("id") String seid) throws Exception {

	List<Opportunity> opp=opportunitydao.getSexopportunity(seid);
	theModel.addAttribute("myopp",opp);
	
	return "salesexopportunities";
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


@RequestMapping("/leadagentlogin")
public String ShowLeadAgentLoginPage(Model theModel) {
	//List<LeadAgentUser> theusers=leadagentdao.getLeadAgentUser();
	LeadAgentUser leadagentusers=new LeadAgentUser();
	/*	LeadAgentLogin u=new LeadAgentLogin();
	theModel.addAttribute("leadagentuser",u); */
	theModel.addAttribute("leadagentusers",leadagentusers);
	return "leadagentlogin";
}

@Autowired
private LeadAgentUserDao leadagentdao;

@RequestMapping("/leadAgentPage")

public String leadAgentPage(@ModelAttribute("leadagentusers") LeadAgentUser u, ModelMap theModel) {

	String agentid=leadagentdao.getLeadAgentUser(u.getUname(), u.getPassword());
	String minlead=new String("hello");
	if(agentid.equals("")) {
		//u.setMessage("invalid");
		return "leadagentlogin";
		}
	else {
	
		theModel.put("id",agentid);
		
		
		theModel.addAttribute("sales",minlead);
		return "leadagentuserhome";
	}
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

@RequestMapping("/addcustomer")
public String ShowAddCustomerPage(Model theModel) {
	NewCustomer nc=new NewCustomer();
	theModel.addAttribute("newcustomer",nc);
	return "addcustomer";
}
@RequestMapping("/customer")
public String ShowCustomerPage(Model theModel) {
	NewCustomer nc=new NewCustomer();
	theModel.addAttribute("newcustomer",nc);
	return "customer";
}
@RequestMapping("/newPayment")
public String ShowNewPaymentPage(Model theModel) {
	NewPayment np=new NewPayment();
	theModel.addAttribute("newpayment",np);
	return "newPayment";
}
}
