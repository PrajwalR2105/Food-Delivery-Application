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

import com.tap.food.rest3.Dbutils;
import com.tap.model.Orderitem;


/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private Connection con;
	List<Orderitem> orderitemlists=new ArrayList<Orderitem>();

	public void init() throws ServletException {
        try {
        	 con=Dbutils.connect();
           
            System.out.println("Connection established successfully.");
        }
        catch (Exception e) {
            e.printStackTrace();       
           } 
    }
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		Orderitemdaoimp  orderitemdao=new Orderitemdaoimp ();
		orderitemlists=orderitemdao.getone(id);
		req.getSession().setAttribute("orderitems", orderitemlists);
		resp.sendRedirect("orderitem.jsp");
     }
}
