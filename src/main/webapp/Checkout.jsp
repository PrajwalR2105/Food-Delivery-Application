<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Payment Options</title>

    <!-- Adding Font Awesome for the Home icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <!-- Adding CSS for styling -->
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fc;
            color: #333;
            text-align: center;
            padding: 50px;
        }

        /* Heading styling */
        h2 {
            color: #5a2a83;
            font-size: 2em;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
        }

        h3 {
            color: #ff6347;
            font-size: 1.5em;
        }

        /* Form container styling */
        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            margin-top: 20px;
            margin: auto;
            text-align: left;  /* Align form content to the left */
        }

        /* Label and input styling */
        label {
            font-size: 1.1em;
            color: #4CAF50;
            margin-bottom: 10px;
            display: block;  /* Ensure labels are displayed on their own lines */
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 2px solid #4CAF50;
            border-radius: 5px;
            font-size: 1em;
            box-sizing: border-box;
        }

        /* Radio buttons styling */
        .payment-option {
            margin-bottom: 15px;
        }

        input[type="radio"] {
            margin-right: 10px;
        }

        /* Submit button styling */
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 25px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.2em;
            transition: background-color 0.3s ease;
        }

        /* Submit button hover effect */
        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Total price text styling */
        #totalPrice {
            font-weight: bold;
            color: #e74c3c;
        }

        /* Top-right corner Home icon styling */
        .home-icon {
            position: absolute;
            top: 20px;
            right: 20px;
            font-size: 2em;
            color: #4CAF50;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        /* Home icon hover effect */
        .home-icon:hover {
            color: #45a049;
        }

        /* Additional responsive design for mobile screens */
        @media (max-width: 600px) {
            body {
                padding: 20px;
            }
            form {
                width: 100%;
            }
        }
    </style>
</head>
<body>

    <!-- Home Icon -->
    <a href="home.jsp" class="home-icon">
        <i class="fas fa-home"></i>  <!-- Font Awesome Home Icon -->
    </a>

    <h2>Enter Address</h2>
    <form action="Storeserve" method="POST">
        <!-- Address input field -->
        <label for="address">Address:</label>
        <input type="text" name="address" required><br><br>

        <!-- Show the total price on the page -->
        <h3>Total Price: $<span id="totalPrice"><%= request.getParameter("totalPrice") != null ? request.getParameter("totalPrice") : "0.00" %></span></h3>
        
        <h2>Select Payment Mode</h2>
        
        <!-- Payment Mode radio buttons -->
        <div class="payment-option">
            <label>
                <input type="radio" name="paymentMode" value="Upi" required> Upi
            </label>
        </div>

        <div class="payment-option">
            <label>
                <input type="radio" name="paymentMode" value="CashOnDelivery" required> Cash on Delivery
            </label>
        </div>

        <div class="payment-option">
            <label>
                <input type="radio" name="paymentMode" value="DebitCard" required> Debit Card
            </label>
        </div>
        
        <!-- Include the total price as a hidden input -->
        <input type="hidden" name="totalPrice" value="<%= request.getParameter("totalPrice") != null ? request.getParameter("totalPrice") : "0.00" %>">
        
        <br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
