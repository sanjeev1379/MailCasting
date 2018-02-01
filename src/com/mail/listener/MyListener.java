package com.mail.listener;

import javax.servlet.*;
import java.sql.*;

public class MyListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		
		Connection con=null;
	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","system");
		
		PreparedStatement ps2= con.prepareStatement("CREATE SEQUENCE MAIL_SEQ MINVALUE 101 MAXVALUE 999 INCREMENT BY 1 START WITH 101 NOCACHE NOORDER NOCYCLE");
		ps2.executeUpdate();
		PreparedStatement ps=con.prepareStatement("CREATE TABLE MAILCASTINGUSER(EMAIL VARCHAR2(4000),PASSWORD VARCHAR2(4000),NAME VARCHAR2(4000),GENDER VARCHAR2(4000),MNAME VARCHAR2(4000), COUNTRY VARCHAR2(4000))");
		ps.executeUpdate();
		PreparedStatement ps4=con.prepareStatement("CREATE TABLE INBOX6(ID NUMBER,RECIEVER VARCHAR2(4000),SENDER VARCHAR2(4000),MESSAGE VARCHAR2(4000),DATE_OF_RECEIVING VARCHAR2(4000))");
		ps4.executeUpdate();		
		}	
	
		
	    catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    }
	    
	    public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");
		
	}
}
