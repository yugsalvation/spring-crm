package com.crm.project;

public class Emails {
	private String to1;
	private String from;
	private String message;
	private String username;
	private String password;
	private String subject;
	private String seuserid;
	private String suserid;
	private String leaduserid;
	private String acuserid;
	public String getAcuserid() {
		return acuserid;
	}
	public void setAcuserid(String acuserid) {
		this.acuserid = acuserid;
	}
	public String getSeuserid() {
		return seuserid;
	}
	public void setSeuserid(String seuserid) {
		this.seuserid = seuserid;
	}
	public String getSuserid() {
		return suserid;
	}
	public void setSuserid(String suserid) {
		this.suserid = suserid;
	}
	public String getLeaduserid() {
		return leaduserid;
	}
	public void setLeaduserid(String leaduserid) {
		this.leaduserid = leaduserid;
	}
	private int taskid;

	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTo1() {
		return to1;
	}
	public void setTo1(String to1) {
		this.to1 = to1;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
