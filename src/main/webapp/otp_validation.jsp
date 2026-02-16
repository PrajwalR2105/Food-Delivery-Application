<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>OTP Validation</title>

    <!-- Adding CSS for styling -->
    <style>
        /* General body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            color: #333;
            text-align: center;
            padding: 50px;
        }

        /* Heading style */
        h2 {
            color: #ff6347;
            font-size: 2em;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
        }

        /* Form styling */
        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            display: inline-block;
            width: 300px;
            margin-top: 20px;
        }

        /* Label styling */
        label {
            font-size: 1.2em;
            color: #4CAF50;
            margin-bottom: 10px;
            display: block;
        }

        /* Input field styling */
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 2px solid #4CAF50;
            border-radius: 5px;
            font-size: 1em;
            box-sizing: border-box;
        }

        /* Submit button styling */
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.2em;
            transition: background-color 0.3s ease;
        }

        /* Submit button hover effect */
        input[type="submit"]:hover {
            background-color: #45a049;
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

    <h2>Enter OTP</h2>

    <form action="OtpValidationServlet" method="post">
        <!-- OTP Field -->
        <label for="otp">OTP:</label>
        <input type="text" id="otp" name="otp" required><br><br>

        <!-- Submit Button -->
        <input type="submit" value="Validate OTP">
    </form>

</body>
</html>
