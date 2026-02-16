package com.tap.food.fetch;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.food.menu.Menuclass;
import com.tap.food.menu2.Menudaoimp;
import com.tap.food.rest3.Dbutils;

/**
 * Servlet implementation class Fetchone
 */
@WebServlet("/Fetchone")
public class Fetchone extends HttpServlet {
	
	private Connection con;
	List<Menuclass> lm=new ArrayList<Menuclass>();

	public void init() throws ServletException {
        try {
        	 con=Dbutils.connect();
           
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();        } 
    }
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		Menudaoimp mdao=new Menudaoimp();
		lm=mdao.fetchone(id);
		req.getSession().setAttribute("menu", lm);
		resp.sendRedirect("menu.jsp");
		
	}

}
