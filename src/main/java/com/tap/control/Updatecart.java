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

import com.tap.food.rest3.Dbutils;
import com.tap.model.Cart;
import com.tap.model.CartItem;

@WebServlet("/Updatecart")
public class Updatecart extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection con;
    private Map<Integer, CartItem> cart;  // Cart from session
	private CartItem item;

    public void init() throws ServletException {
        try {
            con = Dbutils.connect();
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the cart from the session
        cart = (Map<Integer, CartItem>) req.getSession().getAttribute("carttable");

        // If the cart is null, create a new one
        if (cart == null) {
        	System.out.println("Cart created on update");
            cart = new HashMap<>();
        }

       
        String itemIdParam = req.getParameter("itemId");
        

        if (itemIdParam != null ) {
            int itemId = Integer.parseInt(itemIdParam);  
           
            System.out.println("Received item ID: " + itemId);
          

           
           
            for (Map.Entry<Integer, CartItem> entry : cart.entrySet()) {
                 item = entry.getValue();
                System.out.println("Item ID: " + item.getItemId() + ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice());
            }
            cart = Cart.deleteItem(item,itemId);  

           
            System.out.println("Cart after update:");
            

            System.out.println(cart);
           
            req.getSession().setAttribute("carttable", cart);
        }

       
        resp.sendRedirect("cart.jsp");
    }
}
