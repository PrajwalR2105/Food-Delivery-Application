package com.tap.control;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimp.Orderhistorydaoimp;
import com.tap.daoimp.orderdaoimp;
import com.tap.food.rest1.Restaurant;
import com.tap.food.rest2.RestaurantDaoimp;
import com.tap.food.rest3.Dbutils;
import com.tap.food.user1.User;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.Orderhistory;
import com.tap.model.Orderitem;

/**
 * Servlet implementation class Storeserve
 * @return 
 */
@WebServlet("/Storeserve")
public class Storeserve extends HttpServlet {
	
	private Connection con;
	private final  String  INSERT_QUERY="insert into `order` values(?,?,?,?,?,?,?,?) ";
	private Map<Integer, CartItem> carting;
	private CartItem cartitems;
	private Restaurant restaurant=new Restaurant() ;
	
	public void init() throws ServletException {
        try {
        	 con=Dbutils.connect();
           
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();      
        } 
    }
	
	 protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 carting=(Map<Integer, CartItem>) req.getSession().getAttribute("carttable");
		 for (Map.Entry<Integer, CartItem> entry : carting.entrySet()) {
             cartitems = entry.getValue();
            System.out.println("Item ID: " + cartitems.getItemId() + ", Quantity: " + cartitems.getQuantity() + ", Price: " + cartitems.getPrice());
        }
		 User u=(User)req.getSession().getAttribute("Person");
		 String totalPrice = req.getParameter("totalPrice");
	     String paymentMode = req.getParameter("paymentMode");
	     double Total = Double.parseDouble(totalPrice);
		 Order or=new Order(u.getUid(),cartitems.getRestaurantid(),cartitems.getItemId(),cartitems.getQuantity(),Total,paymentMode,"Delivered");
		 orderdaoimp oda=new orderdaoimp();
		 oda.insert(or);
		
		 Order ord=oda.getmax();
		 int id=ord.getOrderid();
		 req.getSession().setAttribute("order", id);
		 for (Map.Entry<Integer, CartItem> entry : carting.entrySet()) {
             cartitems = entry.getValue();
            System.out.println("Item ID: " + cartitems.getItemId() + ", Quantity: " + cartitems.getQuantity() + ", Price: " + cartitems.getPrice());
            double total=cartitems.getPrice()*cartitems.getQuantity();
           Orderitem oi=new Orderitem(ord.getOrderid(),u.getUid(),cartitems.getRestaurantid(),cartitems.getItemId(),cartitems.getImage(),cartitems.getName(),cartitems.getQuantity(),cartitems.getPrice(),total );
   		 Orderitemdaoimp orddao=new Orderitemdaoimp();
   		 orddao.insert(oi);
   		 
   		}
		 RestaurantDaoimp rs=new RestaurantDaoimp();
		 restaurant= rs.fetchrest(cartitems.getRestaurantid());
		 System.out.println(id);
		 System.out.println(u.getUid());
		 System.out.println(cartitems.getRestaurantid());
		 System.out.println(Total);
		 
		 Orderhistory  oh=new  Orderhistory (id,u.getUid(),cartitems.getRestaurantid(),Total,"Delivered",restaurant.getName());
		 System.out.println("values passed");
		 Orderhistorydaoimp odahist=new Orderhistorydaoimp();
		 odahist.insert(oh);
		 System.out.println("values inserted");
		 Orderhistory orhistory=odahist.getmax();
		 System.out.println("maxvalues got");
		 int historyid=orhistory.getOrderhistoryid();
		 System.out.println(historyid);
		 req.getSession().setAttribute("orderhistory", historyid);
		
		 resp.sendRedirect("Confirmation.jsp");
	 }
       
   

}
