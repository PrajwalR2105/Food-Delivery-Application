package com.tap.control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimp.Orderhistorydaoimp;
import com.tap.food.rest3.Dbutils;
import com.tap.food.user1.User;
import com.tap.model.Orderhistory;

/**
 * Servlet implementation class Orderhistoryserve
 */
@WebServlet("/Orderhistoryserve")
public class Orderhistoryserve extends HttpServlet {
	List<Orderhistory> orderhistorylist=new ArrayList<Orderhistory>();
	private Connection con;
	
	public void init() throws ServletException {
        try {
        	 con=Dbutils.connect();
           
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();        } 
    }
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Orderhistorydaoimp ordhist=new Orderhistorydaoimp();
		 User u=(User)req.getSession().getAttribute("Person");
		orderhistorylist=ordhist.getAll(u.getUid());
		req.getSession().setAttribute("orderhistory", orderhistorylist);
		resp.sendRedirect("orderhistory.jsp");
		
	}
}
