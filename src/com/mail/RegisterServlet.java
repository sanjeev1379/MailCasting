package com.mail;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		
		String num=request.getParameter("mname");
		double mname=Double.parseDouble(num);
		String country=request.getParameter("country");
		
		int status=RegisterUser.register(email, password, name, gender, mname,country);
		if(status>0){
			String register= "You are Successfully registered";
			request.setAttribute("register",register);
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}
		else{
			String registererror="Sorry,Registration failed. please try later";
			request.setAttribute("registererror",registererror);
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);
		}
	out.close();	
	}

}
