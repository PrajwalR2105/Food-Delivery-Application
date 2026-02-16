<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.food.user1.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <title>User Profile</title>
 <style>
  body {
    font-family: Arial, sans-serif;
    background-color: #2c3e50; /* Dark background */
    margin: 0;
    padding: 20px;
  }

  h1 {
    text-align: center;
    color: #ecf0f1; /* Light grey text for the title */
  }

  .card {
    background-color: #34495e; /* Dark card background */
    width: 80%;
    max-width: 600px;
    margin: 20px auto;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    text-align: center;
  }

  table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
  }

  th, td {
    padding: 10px;
    text-align: left;
  }

  th {
    background-color: #2980b9; /* Blue header */
    color: white;
    font-weight: bold;
  }

  td {
    background-color: #2c3e50; /* Dark row background */
    color: #ecf0f1; /* Light grey text */
    border-bottom: 1px solid #34495e;
  }

  button {
    background-color: #f39c12; /* Yellow button */
    color: white;
    padding: 8px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
  }

  button:hover {
    background-color: #e67e22; /* Darker yellow */
  }

  .edit-btn {
    text-align: center;
    margin-top: 20px;
  }
</style>


 
</head>
<body>
  <h1>User Profile</h1>

  <div class="card">
    <% 
      // Retrieving the user object from the session
      User u = (User) session.getAttribute("Person");
    %>
    <table>
      
      <tr>
        <th>Username</th>
        <td><%= u.getUname() %></td>
      </tr>
      <tr>
        <th>Email</th>
        <td><%= u.getEmail() %></td>
      </tr>
      <tr>
        <th>Mobile</th>
        <td><%= u.getMobile() %></td>
      </tr>
      <tr>
        <th>Address</th>
        <td><%= u.getAddress() %></td>
      </tr>
    </table>

    <div class="edit-btn">
      <a href="Editprofile.jsp"><button>Edit Profile</button></a>
       <a href="home.jsp"><button>home</button></a>
    </div>
  </div>

</body>
</html>
