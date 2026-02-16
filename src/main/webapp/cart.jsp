<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.model.Cart" %>
<%@ page import="com.tap.model.CartItem" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Shopping Cart</title>

    <!-- Font Awesome CDN for the home icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #333;
        }

        h3 {
            color: #007BFF;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
        }

        /* Home Icon */
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

        /* Table Style */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table th, table td {
            padding: 12px;
            text-align: left;
        }

        table th {
            background-color: #007BFF;
            color: white;
        }

        table td {
            background-color: #fff;
            border-bottom: 1px solid #ddd;
        }

        /* Card Styling for each row */
        .cart-item-row {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-bottom: 20px;
            background-color: #fff;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 8px;
            transition: transform 0.3s;
        }

        .cart-item-row:hover {
            transform: translateY(-5px);
        }

        .cart-item-row img {
            width: 120px;
            height: 120px;
            object-fit: cover;
            border-radius: 8px;
            margin-right: 20px;
        }

        .item-details {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .item-name {
            font-size: 18px;
            color: #333;
            font-weight: bold;
        }

        .item-price, .item-total {
            font-size: 16px;
            color: #555;
        }

        .item-quantity {
            width: 60px;
            padding: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .delete-button {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 8px 12px;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete-button:hover {
            background-color: #d32f2f;
        }

        .action-buttons {
            text-align: center;
            margin-top: 20px;
        }

        .action-buttons button {
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
        }

        .action-buttons .add-more-btn {
            background-color: #28a745;
            color: white;
            border: none;
        }

        .action-buttons .checkout-btn {
            background-color: #007BFF;
            color: white;
            border: none;
        }

        .empty-cart-message {
            text-align: center;
            color: #f44336;
            font-size: 18px;
        }
    </style>

    <script type="text/javascript">
        // This function updates the total price when quantity changes
        function updateTotalPrice() {
            let total = 0.0;
            var rows = document.getElementsByClassName('cart-item-row');
            
            // Loop through each item row and calculate the total price
            for (var i = 0; i < rows.length; i++) {
                var row = rows[i];
                var price = parseFloat(row.querySelector('.item-price').innerText.replace('$', '')); // Remove $ sign for calculation
                var quantity = parseInt(row.querySelector('.item-quantity').value);
                var itemTotal = price * quantity;

                // Update the total price of the individual item
                row.querySelector('.item-total').innerText = "$" + itemTotal.toFixed(2);
                
                // Add to the overall total
                total += itemTotal;
            }

            // Update the total price displayed on the page
            document.getElementById('totalPrice').innerText = "$" + total.toFixed(2);

            // Update the hidden input for checkout with the total price
            document.getElementById('hiddenTotalPrice').value = total.toFixed(2);
        }

        // Ensure total is updated when quantity changes
        function quantityChanged() {
            updateTotalPrice();
        }

        // Call this function when the page loads to set the initial total price
        window.onload = updateTotalPrice;
    </script>
</head>
<body>
    <div class="container">
        <!-- Home icon linking to the home page -->
        <a href="home.jsp" class="home-icon">
            <i class="fas fa-home"></i>
        </a>

        <h2>Your Shopping Cart</h2>

        <% 
            Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("carttable");
            double total = 0.0; 
        %>

        <form action="Checkout.jsp" method="POST">
            <% 
            if (cartItems != null && !cartItems.isEmpty()) {
                for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                    CartItem item = entry.getValue();
                    double itemTotal = item.getPrice() * item.getQuantity();
                    total += itemTotal; 
            %>

            <div class="cart-item-row">
                <img src="<%= item.getImage() %>" alt="<%= item.getName() %>">
                <div class="item-details">
                    <div class="item-name"><%= item.getName() %></div>
                    <div class="item-price">$<%= item.getPrice() %></div>
                    <div class="item-total">$<%= itemTotal %></div>
                    <input type="number" class="item-quantity" name="Quantity" min="1" value="<%= item.getQuantity() %>" onchange="quantityChanged()" data-item-id="<%= item.getItemId() %>">
                </div>
                <div>
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <a href="Updatecart?itemId=<%= item.getItemId() %>&action=remove">
                        <button type="button" class="delete-button">Delete</button>
                    </a>
                </div>
            </div>

            <% }
               } else { 
            %>
            <div class="empty-cart-message">
                Your cart is empty.
            </div>
            <% } %>

            <hr>

            <h3>Total: $<span id="totalPrice"><%= total %></span></h3>

            <!-- Hidden input for total price that will be sent on checkout -->
            <input type="hidden" id="hiddenTotalPrice" name="totalPrice" value="<%= total %>">

            <div class="action-buttons">
                <a href="menu.jsp?restaurantId=<%= session.getAttribute("restaurantId") %>">
                    <button type="button" class="add-more-btn">Add More</button>
                </a><br><br>
                <button type="submit" class="checkout-btn">CHECKOUT</button>
            </div>
        </form>
    </div>
</body>
</html>
