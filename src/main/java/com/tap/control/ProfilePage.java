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
 * Servlet implementation class ProfilePage
 */
@WebServlet("/ProfilePage")
public class ProfilePage extends HttpServlet {
	private Connection con;
	 

	public void init() throws ServletException {
       try {
       	 con=Dbutils.connect();
          
           System.out.println("Connection established successfully.");
       } catch (Exception e) {
           e.printStackTrace();        } 
   }
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Userdaoimp ud=new Userdaoimp();
		
		
	}
}
