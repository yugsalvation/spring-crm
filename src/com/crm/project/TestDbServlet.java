package com.crm.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="hbstudent";
		String password="hbstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		PrintWriter out=response.getWriter();
		try {
			out.println("connecting db:"+jdbcUrl);
			Class.forName(driver);
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,password);
			out.println("success");
			myConn.close();
		}
		catch(Exception e) {
		
			out.println(e);	
			
			
		}
	}

}
