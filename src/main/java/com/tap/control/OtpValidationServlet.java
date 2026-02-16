package com.tap.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimp.Orderhistorydaoimp;
import com.tap.daoimp.orderdaoimp;

/**
 * Servlet implementation class OtpValidationServlet
 */
@WebServlet("/OtpValidationServlet")
public class OtpValidationServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the OTP entered by the user
	        String enteredOtp = request.getParameter("otp");

	        // Retrieve the generated OTP from session
	        HttpSession session = request.getSession();
	        String generatedOtp = (String) session.getAttribute("generatedOtp");

	        // Check if the entered OTP matches the generated OTP
	        if (enteredOtp != null && enteredOtp.equals(generatedOtp)) {
	           
	        	 int id=(int) request.getSession().getAttribute("order");
	        	 orderdaoimp ord=new orderdaoimp();
	        	 String st="Cancelled";
	        	 ord.update(id,st);
	        	 Orderhistorydaoimp odah=new Orderhistorydaoimp();
	        	 int histid=(int) request.getSession().getAttribute("orderhistory");
	        	 System.out.println(histid);
	        	 odah.update(histid, st);
	        	 
	        	 response.sendRedirect("cancel.jsp");
	        	
	        	
	        	
	        } else {
	           
	            response.sendRedirect("otp_validation.jsp");
	        }
	    }

}
