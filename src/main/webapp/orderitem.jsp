<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.model.Orderitem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Order Items</title>

    <!-- Adding CSS for card layout and styling -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fc;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #5a2a83;
        }

        /* Container for the cards */
        .card-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
            padding: 20px;
        }

        /* Individual card styling */
        .card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 280px;
            padding: 20px;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.15);
        }

        .card img {
            width: 100%;
            height: auto;
            border-radius: 5px;
        }

        .card h3 {
            color: #2c3e50;
            font-size: 1.5em;
        }

        .card p {
            color: #7f8c8d;
            font-size: 1.1em;
        }

        .card button {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            font-size: 1em;
            transition: background-color 0.3s ease;
        }

        .card button:hover {
            background-color: #2980b9;
        }

        /* Styling for the card details */
        .card-details {
            margin: 15px 0;
            text-align: left;
        }

        .card-details span {
            font-weight: bold;
            color: #2c3e50;
        }

        /* Centering the Home button */
        .home-button {
            text-align: center;
            margin-top: 20px;
        }

        /* Styling for the button */
        .home-button button {
            background-color: #27ae60;
            color: white;
            padding: 12px 25px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            font-size: 1.1em;
            transition: background-color 0.3s ease;
        }

        .home-button button:hover {
            background-color: #2ecc71;
        }
    </style>
</head>
<body>

<h1>Order Items</h1>

<!-- Card container -->
<div class="card-container">
   <%
       ArrayList<Orderitem> RS = (ArrayList<Orderitem>) session.getAttribute("orderitems");
       for (Orderitem item : RS) { 
   %>
   <!-- Card for each order item -->
   <div class="card">
      <!-- Item Image -->
      <img src="<%= item.getImage() %>" alt="<%= item.getItemname() %>">

      <h3><%= item.getItemname() %></h3>

      <div class="card-details">
         <p><span>Order Item ID:</span> <%= item.getOrderitemid() %></p>
         <p><span>Order ID:</span> <%= item.getOrderid() %></p>
         <p><span>User ID:</span> <%= item.getUserid() %></p>
         <p><span>Menu ID:</span> <%= item.getItemmenuid() %></p>
         <p><span>Hotel ID:</span> <%= item.getHotelid() %></p>
         <p><span>Price:</span> $<%= item.getPrice() %></p>
         <p><span>Total Price:</span> $<%= item.getTotalprice() %></p>
         <p><span>Quantity:</span> <%= item.getQuantity() %></p>
      </div>

      <!-- Action Button (if any action needed) -->
      <a href="Details?id=<%= item.getOrderitemid() %>">
         <button>View Details</button>
      </a>
   </div>
   <% } %>
</div>

<!-- Home Button -->
<div class="home-button">
    <a href="home.jsp"><button>Home</button></a>
</div>

</body>
</html>
