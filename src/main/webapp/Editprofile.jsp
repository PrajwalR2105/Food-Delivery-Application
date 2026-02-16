<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.food.user1.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Profile</title>

    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #ff7e5f, #feb47b); /* Gradient background */
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

        /* Form container */
        form {
            background-color: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.3);
            display: inline-block;
            text-align: left;
        }

        /* Styling for form elements */
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 1.1em;
            background-color: #f4f4f4;
            color: #333;
        }

        input[type="text"]:focus {
            outline: none;
            border-color: #3498db;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 15px 30px;
            font-size: 1.2em;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        /* Label styling */
        label {
            font-size: 1.2em;
            margin-bottom: 10px;
            display: block;
        }

        /* Responsive design */
        @media (max-width: 600px) {
            h1 {
                font-size: 2em;
            }

            form {
                width: 90%;
                padding: 20px;
            }
        }

    </style>
</head>
<body>

    <h1>Edit Your Profile</h1>

    <% 
        // Retrieve the User object from the session
        User u = (User) session.getAttribute("Person"); 
        
        // Check if the user object exists in session, if not, redirect or show error message
        if (u == null) {
    %>
        <p style="color: red;">User session not found. Please log in first.</p>
        <a href="login.jsp" style="color: #3498db; text-decoration: none;">Go to Login</a>
    <% 
        return;
    } 
    %>

    <form action="Edit" method="POST">
        <label for="id">ID</label>
        <input type="text" name="id" value="<%= u.getUid() %>" readonly/>

        <label for="name">Name</label>
        <input type="text" name="name" value="<%= u.getUname() %>"/>

        <label for="email">Email</label>
        <input type="text" name="email" value="<%= u.getEmail() %>" readonly/>

        <label for="address">Address</label>
        <input type="text" name="address" value="<%= u.getAddress() %>" />

        <label for="mob">Mobile</label>
        <input type="text" name="mob" value="<%= u.getMobile() %>"/>

        <input type="submit" value="Update"/>
    </form>

</body>
</html>
