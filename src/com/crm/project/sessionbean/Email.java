package com.crm.project.sessionbean;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.crm.project.Emails;
@Component
@Scope(value="session")
@Stateless
public class Email {

public void sendEmail(String mto,String mfrom,String msubject,String mmessage,String musername,String mpassword)  {
	try {
	Properties props=System.getProperties();
	String to=mto;
	String from=mfrom;
	String subject=msubject;
	String message=mmessage;
	String username=musername;
	String password=mpassword;
	/*String to=e1.getTo1();
	String from=e1.getUsername();
	String subject=e1.getSubject();
	String message=e1.getMessage();
	String username=e1.getUsername();
	String password=e1.getPassword(); */
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
	
	
	
}
}
