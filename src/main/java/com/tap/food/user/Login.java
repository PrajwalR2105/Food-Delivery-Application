package com.tap.food.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.food.Userdaoimp;
import com.tap.food.user1.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	 
	
	
	 private Connection con;
	 private String username = "root";
	  private String password = "Jeevan@123";
	  private String url="jdbc:mysql://localhost:3306/foodclone";


	public void init() throws ServletException {
	        try {
	            // Load the MySQL driver class
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("MySQL JDBC Driver Registered!");

	            // Establish the connection
	            con = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection established successfully.");
	        } catch (ClassNotFoundException e) {
	            throw new ServletException("MySQL Driver not found.", e);
	        } catch (SQLException e) {
	            throw new ServletException("Unable to establish MySQL connection.", e);
	        }
	    }
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		if (con == null) {
            throw new ServletException("Database connection is not established.");
        }
		
		Userdaoimp udai=new  Userdaoimp();
		User u= udai.fetchuser(email);
		
		req.getSession().setAttribute("Person",u);
		if(u!=null) {
			if(password.equals(u.getPassword())) {
			resp.sendRedirect("GetRestautant");
			}
			else {
				resp.sendRedirect("pswd.jsp");
			}
		}
		else {
			resp.sendRedirect("user.jsp");
		}
		 
	}
}
