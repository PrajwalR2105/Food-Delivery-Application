package com.tap.control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.food.Userdaoimp;
import com.tap.food.rest3.Dbutils;
import com.tap.food.user1.User;

/**
 * Servlet implementation class Registerotp
 */
@WebServlet("/Registerotp")
public class Registerotp extends HttpServlet {
private Connection con;
	

	public void init() throws ServletException {
       try {
       	 con=Dbutils.connect();
          
           System.out.println("Connection established successfully.");
       } catch (Exception e) {
           e.printStackTrace();        } 
   }
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the OTP entered by the user
	        String enteredOtp = request.getParameter("otp");

	        // Retrieve the generated OTP from session
	        HttpSession session = request.getSession();
	        String generatedOtp = (String) session.getAttribute("generate");

	        // Check if the entered OTP matches the generated OTP
	        if (enteredOtp != null && enteredOtp.equals(generatedOtp)) {
	        	System.out.println("success");
	        	User u=(User) session.getAttribute("User");
	        	Userdaoimp userimp=new Userdaoimp();
	        	userimp.insert(u);
	        	 
	        	 response.sendRedirect("Successfull.jsp");
	        	
	        	
	        	
	        } else {
	           System.out.println("failed");
	            response.sendRedirect("otp_validation2.jsp");
	        }
	 }
}
