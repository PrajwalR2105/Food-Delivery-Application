<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Thanks for Confirmation</title>

    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #ff7e5f, #feb47b); /* Gradient background */
            color: #fff;
            padding: 40px;
            text-align: center;
        }

        h1 {
            font-size: 3em;
            color: #fff;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
        }

        h2 {
            font-size: 2em;
            color: #ffeb3b;
            margin-bottom: 30px;
            font-weight: bold;
        }

        /* Button styling */
        button {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 15px 30px;
            border-radius: 5px;
            font-size: 1.2em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #2980b9;
        }

        /* Hover effect for the button */
        a {
            text-decoration: none; /* Remove underline from link */
        }

        /* Styling for the message */
        .message-container {
            background-color: rgba(0, 0, 0, 0.4);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            max-width: 600px;
            margin: 0 auto;
        }

    </style>
</head>
<body>

    <div class="message-container">
        <h1>Thanks for Confirmation</h1><br>
        <h2>You will receive your order soon!</h2>
        <a href="home.jsp"><button>Go to Home</button></a>
    </div>

</body>
</html>
