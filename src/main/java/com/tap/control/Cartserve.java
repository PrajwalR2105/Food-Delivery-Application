package com.tap.control;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.food.menu.Menuclass;
import com.tap.food.menu2.Menudaoimp;
import com.tap.food.rest3.Dbutils;
import com.tap.model.Cart;
import com.tap.model.CartItem;

/**
 * Servlet implementation class Cartserve
 */
@WebServlet("/Cartserve")
public class Cartserve extends HttpServlet {
	
	
	private Map<Integer, CartItem> carttable;
	private Connection con;
	private Cart cart;




	public void init() throws ServletException {
        try {
        	 con=Dbutils.connect();
           
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();        } 
    }
	
	
	
	
	 protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 carttable = (Map<Integer, CartItem>) req.getSession().getAttribute("carttable");
		   if(carttable==null) {
			   this.carttable=new HashMap<Integer,CartItem>();
		   }
		   if (cart == null) {
	            cart = new Cart();
	            req.getSession().setAttribute("carttable", cart);
	        }
		 
	        int id = Integer.parseInt(req.getParameter("menuid"));
	        int quantity=Integer.parseInt(req.getParameter("Quantity"));

	       
	        Menudaoimp mdao = new Menudaoimp();
	        Menuclass m = mdao.fetchspecific(id);
	        if (m == null) {
	            System.out.println("Menu item not found for id: " + id);
	        } else {
	            System.out.println("Menu item found: " + m.getName());
	        }

	       
	        CartItem ci = new CartItem(m.getMenuId(), m.getRestaurantId(),m.getImagePath(), m.getName(),quantity, m.getPrice());

	       
	       
	        System.out.println("hello");

	       
	       
	      
	        carttable = cart.addItem(ci);
	        for (Map.Entry<Integer, CartItem> entry : carttable.entrySet()) {
	        	System.out.println(entry.getValue());
	        }
	        req.getSession().setAttribute("carttable", carttable);

	       
	        resp.sendRedirect("cart.jsp"); 
	}
   
}
