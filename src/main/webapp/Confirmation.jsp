<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Cancel Order</title>

    <style>
        /* Body Styling */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #ff8c00, #e52e71); /* Gradient background */
            color: #fff;
            padding: 50px;
            text-align: center;
        }

        h1 {
            font-size: 3em;
            color: #fff;
            text-shadow: 3px 3px 5px rgba(0, 0, 0, 0.4);
            margin-bottom: 40px;
        }

        /* Styling for the form buttons */
        form {
            margin: 20px 0;
        }

        button {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 15px 30px;
            font-size: 1.2em;
            border-radius: 10px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
            margin: 10px;
        }

        button:hover {
            background-color: #2980b9;
            transform: scale(1.1); /* Slightly enlarge the button when hovered */
        }

        /* Styling for button container to align them horizontally */
        .button-container {
            display: flex;
            justify-content: center;
            gap: 30px;
            align-items: center;
        }

        /* Adding some spacing between the buttons */
        .button-container button {
            width: 200px;
        }

        /* Responsive Design */
        @media (max-width: 600px) {
            h1 {
                font-size: 2em; /* Smaller heading for small screens */
            }

            .button-container {
                flex-direction: column;
            }
        }

    </style>
</head>
<body>

    <h1>Do you want to cancel your order?</h1>

    <!-- Button container for alignment -->
    <div class="button-container">
        <!-- Yes button -->
        <form action="Cancel" method="POST">
            <button type="submit" name="cancelOrder" value="yes">Yes</button>
        </form>
        
        <!-- No button -->
        <form action="order.jsp" method="GET">
            <button type="submit" name="cancelOrder" value="no">No</button>
        </form>
    </div>

</body>
</html>
