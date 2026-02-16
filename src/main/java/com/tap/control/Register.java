package com.tap.control;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.food.rest3.Dbutils;
import com.tap.food.user1.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private Connection con;
	

	public void init() throws ServletException {
       try {
       	 con=Dbutils.connect();
          
           System.out.println("Connection established successfully.");
       } catch (Exception e) {
           e.printStackTrace();        } 
   }
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
        String email = request.getParameter("mail");
        String password = request.getParameter("pswd");
        String confirmPassword = request.getParameter("cpswd");
        String address=request.getParameter("place");
        String mobile=request.getParameter("mobile");
        long mob = Long.parseLong(mobile);
        

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            response.getWriter().println("Passwords do not match!");
            return;
        }
        User u=new User(username,email,password,mob,address);
        request.getSession().setAttribute("User", u);
        System.out.println("otp sent");

        // Generate OTP
        String otp = generateOtp();

        // Send OTP email
        sendOtpEmail(email, otp);

        // Store OTP in session for later validation
        HttpSession session = request.getSession();
        session.setAttribute("generate", otp);

        // Redirect user to OTP validation page
        response.sendRedirect("otp_validation2.jsp");
    }

    // Method to generate a random OTP
    private String generateOtp() {
        return String.valueOf((int) (Math.random() * 900000) + 100000);  // 6-digit OTP
    }

    // Method to send OTP email
    private void sendOtpEmail(String recipientEmail, String otp) {
        String host = "smtp.gmail.com";
        final String username = "jeevanmm28@gmail.com";  // Replace with your email
        final String password = "vore ahqo jegj xuvi";    // Replace with your email password or App password

        // Set up properties for the session
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Get session object
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From, To, Subject, and Content
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Your OTP for Registration");
            message.setText("Your OTP for registration is: " + otp);

            // Send message
            Transport.send(message);
            System.out.println("OTP sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
}
