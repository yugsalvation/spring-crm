package com.crm.project.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Tasks {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtasks")	
	private int idtasks;
	
	@Column(name="oid")	
	private String oid;
	
	@Column(name="doc")	
	private Date doc;
	
	@Column(name="suser")	
	private String suser;
	
	@Column(name="seuser")	
	private String seuser;
	
	@Column(name="description")	
	private String description;
	
	@Column(name="dor")	
	private Date dor;
	
	@Column(name="dom")	
	private Date dom;
	
	@Column(name="completed")	
	private int completed;
	
	@Column(name="tom")	
	private String tom;
	
	@Column(name="reminder")	
	private int reminder;
	
	@Column(name="dropp")	
	private int dropp;
	
	@Column(name="names")	
	private String names;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public int getIdtasks() {
		return idtasks;
	}

	public void setIdtasks(int idtasks) {
		this.idtasks = idtasks;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}

	public String getSuser() {
		return suser;
	}

	public void setSuser(String suser) {
		this.suser = suser;
	}

	public String getSeuser() {
		return seuser;
	}

	public void setSeuser(String seuser) {
		this.seuser = seuser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDor() {
		return dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	public Date getDom() {
		return dom;
	}

	public void setDom(Date dom) {
		this.dom = dom;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public String getTom() {
		return tom;
	}

	public void setTom(String tom) {
		this.tom = tom;
	}

	public int getReminder() {
		return reminder;
	}

	public void setReminder(int reminder) {
		this.reminder = reminder;
	}

	public int getDropp() {
		return dropp;
	}

	public void setDropp(int dropp) {
		this.dropp = dropp;
	}
	
	
	
}
