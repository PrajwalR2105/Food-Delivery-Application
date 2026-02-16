package com.tap.foodapp;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.food.rest1.Restaurant;
import com.tap.food.rest2.RestaurantDaoimp;
import com.tap.food.rest3.Dbutils;

/**
 * Servlet implementation class GetRestautant
 */
@WebServlet("/GetRestautant")
public class GetRestautant extends HttpServlet {
	
	
	private Connection con;
	 private List<Restaurant> list;

	public void init() throws ServletException {
        try {
        	 con=Dbutils.connect();
           
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();        } 
    }
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RestaurantDaoimp rdao=new RestaurantDaoimp();
		list=rdao.fetchAll();
		req.getSession().setAttribute("Restaurantlist",list);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}

	

}
