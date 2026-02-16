<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter OTP</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2; /* Light gray background color */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: #ffffff; /* White background for the form */
        padding: 30px;
        border-radius: 8px; /* Rounded corners */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Light shadow for the form */
        width: 300px; /* Fixed width for the form */
        text-align: center;
    }

    h2 {
        color: #333333; /* Dark text for the heading */
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 8px;
        font-size: 16px;
        color: #555555;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50; /* Green background for the button */
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049; /* Darker green when hovered */
    }
</style>
</head>
<body>

<div class="container">
    <h2>Enter OTP Sent to Your Mail</h2>

    <form action="Registerotp" method="post">
        <!-- OTP Field -->
        <label for="otp">OTP:</label>
        <input type="text" id="otp" name="otp" required><br><br>

        <!-- Submit Button -->
        <input type="submit" value="Validate OTP">
    </form>
</div>

</body>
</html>
