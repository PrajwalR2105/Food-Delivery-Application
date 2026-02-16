<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.food.menu.Menuclass" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Items</title>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
           background: linear-gradient(to right, #f6d365, #fda085); 
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin: 20px;
        }

        .card-container {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            padding: 20px;
        }

        .card {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
        }

      
        .card img {
            width: 100%;            
            height: 200px;         
            object-fit: cover;      
            border-bottom: 1px solid #ddd;
        }

        .card-content {
            padding: 15px;
        }

        .card-content h3 {
            font-size: 1.2rem;
            margin: 10px 0;
            color: #333;
        }

        .card-content p {
            font-size: 0.9rem;
            color: #555;
        }

        .card-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            background-color: #f9f9f9;
            border-top: 1px solid #ddd;
        }

        .card-footer .price {
            font-weight: bold;
            color: #2a9d8f;
        }

        .card-footer .rating {
            background-color: #f1faee;
            color: #2a9d8f;
            border-radius: 5px;
            padding: 5px;
            font-size: 0.85rem;
        }

        .add-to-cart-btn {
            padding: 8px 15px;
            background-color: #2a9d8f;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 0.9rem;
            transition: background-color 0.3s ease;
        }

        .add-to-cart-btn:hover {
            background-color: #21867a;
        }

       
        .card-footer input[type="number"] {
            width: 60px; 
            padding: 5px;  
            font-size: 0.9rem;  
            border-radius: 5px; 
            border: 1px solid #ddd; 
            text-align: center; 
        }
         .home-icon {
            position: absolute;
            top: 20px;
            right: 20px;
            font-size: 30px;
            color: #007BFF;
            cursor: pointer;
            text-decoration: none;
        }

        .home-icon:hover {
            color: #0056b3;
        }
        

        @media (max-width: 768px) {
            .card-container {
                grid-template-columns: repeat(2, 1fr);
            }
        }

        @media (max-width: 480px) {
            .card-container {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
 <a href="home.jsp" class="home-icon">
            <i class="fas fa-home"></i>
        </a>

    <h1>Menu Items</h1>

    <div class="card-container">
        <%
        ArrayList<Menuclass> Am = (ArrayList<Menuclass>) session.getAttribute("menu");
        for (Menuclass res : Am) {
        %>
        
        <form action="Cartserve" method="POST">
            <div class="card">
                <img src="<%= res.getImagePath() %>" alt="<%= res.getName() %>">
                <div class="card-content">
                    <h3><%= res.getName() %></h3>
                    <p><%= res.getDescription() %></p>
                    <p><%= res.getMenuId() %></p>
                </div>
                <div class="card-footer">
                    <span class="price">$<%= res.getPrice() %></span>
                    <span class="rating">Rating: <%= res.getRating() %></span>
                    <label for="quantity">Quantity:</label>
                    <input type="number" name="Quantity" min="1" value="1" id="quantity">
                    <input type="hidden" name="menuid" value="<%= res.getMenuId() %>">
                    <button class="add-to-cart-btn" type="submit">Add to Cart</button>
                </div>
            </div>
        </form>
        <% } %>
    </div>

</body>
</html>
