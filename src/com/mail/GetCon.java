package com.mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GetCon {
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "system");
			
		}catch(Exception e){System.out.println(e);}
		return con;
	}

	public static int getPrimaryKey(){
		int nextvalue=0;
		Connection con=GetCon.getCon();
		PreparedStatement ps2;
		try {
		
		ps2=con.prepareStatement("select MAIL_SEQ.NEXTVAL from DUAL");
		
		ResultSet rs=ps2.executeQuery();
		rs.next();
		nextvalue=rs.getInt(1);

		
		
	} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return nextvalue;

	}

}
