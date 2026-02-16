<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.food.rest1.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <title>Restaurant Listings</title>
 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding-top: 100px;
      background: linear-gradient(to right, #f6d365, #fda085); 
      position: relative;
    }

 
    .header {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      background-color: rgba(255, 255, 255, 0.9); 
      padding: 10px 20px;
      z-index: 1000;
      display: flex;
      justify-content: space-between;
      align-items: center;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .header .logo {
      font-size: 32px;
      font-weight: bold;
      color: #333;
      text-transform: uppercase;
      text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
    }

    .header .buttons {
      display: flex;
      align-items: center;
    }

    .header button {
      font-size: 16px;
      padding: 12px 20px;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s ease;
      margin: 0 10px; 
    }

    .order-history-btn {
      background-color: #4CAF50; 
      color: white;
    }

    .order-history-btn:hover {
      background-color: #45a049; 
    }

    .profile-btn {
      background-color: #2196F3;
      color: white;
    }

    .profile-btn:hover {
      background-color: #1976D2;
    }

    .cart-btn {
      background-color: #ff9800;
      color: white;
      font-size: 20px;
      text-align: center;
      border-radius: 50%;
      padding: 12px;
    }

    .cart-btn:hover {
      background-color: #f57c00;
    }

   
    .home-foods {
      font-size: 48px;
      color: #fff;
      text-shadow: 4px 4px 10px rgba(0, 0, 0, 0.3); 
      background: linear-gradient(to right, #ff7e5f, #feb47b); 
      padding: 20px 0;
      z-index: 999; 
      font-family: 'Arial', sans-serif;
      font-weight: bold;
      text-align: center;
      margin-left: auto;
      margin-right: auto;
    }

   
    .card-container {
      display: grid;
      grid-template-columns: repeat(3, 1fr); 
      gap: 20px;
      margin-top: 120px;
      padding: 0 20px; 
    }

    .card {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      text-align: center;
      padding: 15px;
      transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
    }

    .card:hover {
      transform: scale(1.05);
      box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
    }

    .card img {
      width: 100%;
      height: 200px;
      object-fit: cover;
      border-radius: 8px;
    }

    .card h3 {
      font-size: 18px;
      color: #333;
      margin-top: 10px;
    }

    .card p {
      font-size: 14px;
      color: #555;
      margin: 5px 0;
    }

    .card .active {
      color: green;
      font-weight: bold;
    }

    .card .inactive {
      color: red;
      font-weight: bold;
    }

    .card .rating {
      font-size: 16px;
      color: #f39c12;
      font-weight: bold;
    }

    .actions button {
      background-color: #f39c12;
      color: white;
      border: none;
      padding: 8px 15px;
      font-size: 14px;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .actions button:hover {
      background-color: #e67e22; 
    }

    @media (max-width: 1024px) {
      .card-container {
        grid-template-columns: repeat(2, 1fr); 
      }
    }

    @media (max-width: 768px) {
      .card-container {
        grid-template-columns: 1fr; 
      }

      .card {
        width: 100%;
        margin-bottom: 20px;
      }
    }

  </style>
</head>
<body>
  
  <div class="header">
    <div class="logo">Home Foods</div>
    <div class="buttons">
      
      <a href="Orderhistoryserve?"><button class="order-history-btn">Order History</button></a>

      
      <a href="Profilepage.jsp"><button class="profile-btn">Profile</button></a>

     
      <a href="cart.jsp"><button class="cart-btn"><i class="fas fa-shopping-cart"></i></button></a>
    </div>
  </div>



  <div class="card-container">
    <% 
      ArrayList<Restaurant> RS = (ArrayList<Restaurant>) session.getAttribute("Restaurantlist");
      if (RS != null && !RS.isEmpty()) {
        for(Restaurant res : RS) {
    %>
      <div class="card">
        <img src="<%= res.getImagePath() %>" alt="<%= res.getName() %>">
        <h3><%= res.getName() %></h3>
        <p><strong>Restaurant id:</strong> <%= res.getRid() %></p>
        <p><strong>Cuisine Type:</strong> <%= res.getCusineType() %></p>
        <p><strong>Address:</strong> <%= res.getAddress() %></p>
        <p><strong>Owner ID:</strong> <%= res.getRestaurantOwnerId() %></p>
        <p><strong>Estimated Time:</strong> <%= res.getEta() %> mins</p>
        <p class="rating"><strong>Ratings:</strong> <%= res.getRatings() %></p>
        <p class="<%= res.getIsActive().equals("active") ? "active" : "inactive" %>">
          <strong>Active:</strong> <%= res.getIsActive() %>
        </p>
        <div class="actions">
          <a href="Fetchone?id=<%= res.getRid() %>"><button>Menu</button></a>
        </div>
      </div>
    <% 
        }
      } else {
    %>
      <p>No restaurants available at the moment.</p>
    <% } %>
  </div>
</body>
</html>
