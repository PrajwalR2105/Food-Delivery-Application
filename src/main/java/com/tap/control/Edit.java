package com.tap.control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.food.Userdaoimp;
import com.tap.food.rest3.Dbutils;
import com.tap.food.user1.User;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
private Connection con;
	

	public void init() throws ServletException {
       try {
       	 con=Dbutils.connect();
          
           System.out.println("Connection established successfully.");
       } catch (Exception e) {
           e.printStackTrace();        } 
   }
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int userid=Integer.parseInt(id);
		String name=req.getParameter("name");
		String Email=req.getParameter("email");
		String address=req.getParameter("address");
		String mob=req.getParameter("mob");
		long phone=Long.parseLong(mob);
		User u=new User(userid,name,Email,phone,address);
		
		Userdaoimp udh=new Userdaoimp();
		udh.update(u);
		req.getSession().setAttribute("Person",u);
		resp.sendRedirect("home.jsp");
	}
       
   

}
