package com.tap.food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.food.user1.User;
import com.tap.food.user2.Userdao;

public class Userdaoimp implements Userdao{

	
	private String url="jdbc:mysql://localhost:3306/foodclone";
	private String username="root";
	private String password="Jeevan@123";
	private final String INSERT_QUERY = "INSERT INTO `user` (uname, email, password, mob, address) VALUES (?, ?, ?, ?, ?)";

	private final String FETCH_ALL_QUERY="select * from user";
	private final String FETCH_QUERY="select * from user where uid=?";
	private final String UPDATE="update user set uname=?,email=?,address=?,mob=? where uid=?";
	private final String FETCH_USER="select * from user where email=?";
	final static String DELETE_QUERY = "DELETE from `user` WHERE `userId` = ?";
	private Connection con;
	private PreparedStatement pstmt;
	private int res;
	
	private List<User> userlist=new ArrayList<User>();
	private User user;
	private PreparedStatement prepareStatement;

	
	public Userdaoimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void insert(User u) {
		
		  try {
			   pstmt=con.prepareStatement(INSERT_QUERY);
			  
			   pstmt.setString(1, u.getUname());
			   pstmt.setString(2,u.getEmail());
			   pstmt.setString(3,u.getPassword());
			   pstmt.setLong(4, u.getMobile());
			  
			   pstmt.setString(5, u.getAddress());
			  
			   res=pstmt.executeUpdate();
			   if(res!=0) {
				   System.out.println("Success");
			   }
			   
			   }
			   catch(Exception e) {
				   e.printStackTrace();
			   }
			   
			
		      }
	

	public List<User> fetchAll() {
	
		try {
		     pstmt=con.prepareStatement(FETCH_ALL_QUERY);
		     ResultSet resultset=pstmt.executeQuery(FETCH_ALL_QUERY);
		     extractAll(resultset);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		     return userlist;
		
	   }
	
	
	public List<User> extractAll(ResultSet resultset) {
	    try {
    	 while(resultset.next()) {
    		 int id=resultset.getInt("uid");
    		 String name=resultset.getString("uname");
    		 String password=resultset.getString("password");
    		 long mob =resultset.getLong("mob");
    		 String address=resultset.getString("address");
    		 LocalDateTime createddate=resultset.getTimestamp("accountcreated").toLocalDateTime();
    		 LocalDateTime lastlogin=resultset.getTimestamp("lastlogin").toLocalDateTime();
    		 String email =resultset.getString("email");
    		 
    		 userlist.add(new User(id,name,email,password,mob,createddate,lastlogin,address));
    		 
	    }
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return userlist;
	
      }


	
	public User getuser(int id) {
		 try {
			   pstmt=con.prepareStatement(FETCH_QUERY);
			   pstmt.setInt(1, id);
			   ResultSet res=pstmt.executeQuery();
			   List<User> lu= new ArrayList<User>();
			   while(res.next()) {
				   int id1=res.getInt("uid");
		  		 String uname=res.getString("uname");
		  		 String upassword=res.getString("password");
		  		 long umob =res.getLong("mob");
		  		 String uaddress=res.getString("address");
		  		 LocalDateTime ucreateddate=res.getTimestamp("accountcreated").toLocalDateTime();
		  		 LocalDateTime ulastlogin=res.getTimestamp("lastlogin").toLocalDateTime();
		  		 String uemail =res.getString("email");
		  		 
		  		 lu.add(new User(id1,uname,uemail,upassword,umob,ucreateddate,ulastlogin,uaddress));
		  		 
			 }
			   
			   if(!lu.isEmpty()) {
				   user=lu.get(0);
			   }
			   else {
				   System.out.println("user with id not found");
				   System.exit(0);
			   }
		 }
			  
			  catch(Exception e) {
				  e.printStackTrace();
			  }
			  return user;
			   
			   
		   }
	

	
	public void deleteUser(int userId) {
		
		
		try {
			prepareStatement = con.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, userId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public User fetchuser(String email) {
	    try {
	        pstmt = con.prepareStatement(FETCH_USER);
	        pstmt.setString(1, email);
	        ResultSet res = pstmt.executeQuery();
	        List<User> lu1 = new ArrayList<User>();
	        while (res.next()) {
	            int id1 = res.getInt("uid");
	            String uname = res.getString("uname");
	            String upassword = res.getString("password");
	            long umob = res.getLong("mob");
	            String uaddress = res.getString("address");
	            LocalDateTime ucreateddate = res.getTimestamp("accountcreated").toLocalDateTime();
	            LocalDateTime ulastlogin = res.getTimestamp("lastlogin").toLocalDateTime();
	            String uemail = res.getString("email");

	            lu1.add(new User(id1, uname, uemail, upassword, umob, ucreateddate, ulastlogin, uaddress));
	        }
	        if (!lu1.isEmpty()) {
	            user = lu1.get(0);
	        } else {
	            System.out.println("User not found for email: " + email);
	            user = null;  // This should return null if the user is not found
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return user;
	}


	public int update(User u) {
		int Status=0;
		try {
		pstmt=con.prepareStatement(UPDATE);
		pstmt.setString(1, u.getUname());
	    pstmt.setString(2, u.getEmail());
	    pstmt.setString(3, u.getAddress());
		pstmt.setLong(4, u.getMobile());
		pstmt.setInt(5, u.getUid());
		
		
		Status=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Status;
	}

}
