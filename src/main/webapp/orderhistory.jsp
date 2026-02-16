<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.model.Orderhistory" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Order History</title>

    <!-- Adding CSS for card layout and styling -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #f6d365, #fda085);
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
        
        .home-icon {
            position: absolute;
            top: 20px;
            right: 20px;
            font-size: 2em;
            color: #4CAF50;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .home-icon:hover {
            color: #2ecc71;
        }

        /* Message for no orders */
        .no-orders-message {
            text-align: center;
            font-size: 1.5em;
            color: #e74c3c;
            padding: 20px;
            background-color: #f2d7d5;
            border-radius: 10px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <a href="home.jsp" class="home-icon">
        <i class="fas fa-home"></i>  <!-- Font Awesome Home Icon -->
    </a>

    <h1>Order History</h1>

    <% 
        ArrayList<Orderhistory> RS = (ArrayList<Orderhistory>) session.getAttribute("orderhistory");

        // Check if order history is null or empty
        if (RS == null || RS.isEmpty()) {
    %>
        <!-- Message when there are no orders -->
        <div class="no-orders-message">
            Oops, you didn't order anything yet!
        </div>
    <% } else { %>

        <!-- Card container -->
        <div class="card-container">
            <% 
                for (Orderhistory oh : RS) { 
            %>
            <!-- Card for each order -->
            <div class="card">
                <h3>Order #<%= oh.getOid() %></h3>

                <div class="card-details">
                    <p><span>Order History ID:</span> <%= oh.getOrderhistoryid() %></p>
                    <p><span>Restaurant:</span> <%= oh.getRestname() %></p>
                    <p><span>Customer ID:</span> <%= oh.getUserid() %></p>
                    <p><span>Total:</span> $<%= oh.getTotal() %></p>
                    <p><span>Status:</span> <%= oh.getStatus() %></p>
                </div>

                <!-- View details button -->
                <a href="Details?id=<%= oh.getOid() %>">
                    <button>View Details</button>
                </a>
            </div>
            <% } %>
        </div>

    <% } %>

</body>
</html>
