package com.tap.control;

import java.io.IOException;
import java.util.Properties;
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

import com.tap.food.user1.User;

@WebServlet("/Cancel")
public class Cancel extends HttpServlet {

    // Handle the POST request from the cancel order process
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user data from the form
    	 User u=(User)request.getSession().getAttribute("Person");
    	 String email=u.getEmail();

        // Generate OTP
        String otp = generateOtp();

        // Send OTP via email
        sendOtpEmail(email, otp);

        // Store OTP in session for later validation
        HttpSession session = request.getSession();
        session.setAttribute("generatedOtp", otp);

        // Redirect user to OTP validation page
        response.sendRedirect("otp_validation.jsp");
    }

    // Method to generate a random OTP
    private String generateOtp() {
        return String.valueOf((int) (Math.random() * 900000) + 100000);  // Generates a 6-digit OTP
    }

    // Method to send OTP email
    private void sendOtpEmail(String recipientEmail, String otp) {
        String host = "smtp.gmail.com";
        final String username = "jeevanmm28@gmail.com";  // Use Gmail address
        final String password = "vore ahqo jegj xuvi";       // Use App Password, not your regular Gmail password

        // Set up properties for the session
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create session with authentication
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From, To, Subject, and Content
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Your OTP for Registration");
            message.setText("Your OTP for registration is: " + otp);

            // Send the message
            Transport.send(message);
            System.out.println("OTP sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
