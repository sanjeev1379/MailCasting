package com.mail;
import java.sql.*;
import java.util.Calendar;
public class SendMessage {
//static int d=1;
public static int sendMsg(String sender,String reciever,String msg ){
	int status=0;
	java.util.Date sqdate=Calendar.getInstance().getTime();
	java.sql.Date dat =new java.sql.Date(sqdate.getTime());
	try {
		Connection con=GetCon.getCon();
		PreparedStatement ps=con.prepareStatement("Insert into INBOX6 values(?,?,?,?,?)");
		int	id=GetCon.getPrimaryKey();
		ps.setInt(1,id);
		ps.setString(2,reciever);
		ps.setString(3,sender);
		ps.setString(4,msg);
		ps.setDate(5,dat);
		status=ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return status;
}
}
