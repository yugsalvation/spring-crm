package com.crm.project.dao;

import java.util.List;

import com.crm.project.entity.Tasks;

public interface TasksDao {
public void addSalesTask(Tasks t);
public void addSalesexTask(Tasks t);
public Tasks getTask(int taskid);
public List<Tasks> getSalesTasks(String suserid);
public List<Tasks> getSalesmyTasks(String suserid);
public List<Tasks> getSalesTodayTasks(String suserid);
public List<Tasks> getSalesexTasks(String seuserid);
public List<Tasks> getSalesexmyTasks(String seuserid);
public List<Tasks> getSalesexTodayTasks(String seuserid);
public void updateTask(int taskid,Tasks t);
public void completeTask(int taskid);
public void sendReminderTask(int taskid);
public void dropTask(int taskid);
public int getTaskbyOid(String oid);
}
