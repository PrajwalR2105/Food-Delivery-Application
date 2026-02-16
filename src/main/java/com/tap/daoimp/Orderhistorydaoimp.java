package com.tap.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Orderhist;
import com.tap.model.Order;
import com.tap.model.Orderhistory;


public class Orderhistorydaoimp  implements Orderhist {

	
	private Connection con;
	private String url="jdbc:mysql://localhost:3306/foodclone";
	private String username="root";
	private String password="Jeevan@123";
	private String Insert="insert into orderhistory(orid,custid,Eateryid,total,status,restname) values(?,?,?,?,?,?)";
	private final String FETCH_ALL_QUERY1="SELECT * FROM `orderhistory` WHERE orderhistoryid = (SELECT MAX(orderhistoryid) FROM `orderhistory`)";
	private final String FETCH_ALL="SELECT * from `orderhistory` WHERE `custid`=?";
	private final String UPDATE="UPDATE `orderhistory` SET status = ? WHERE `orderhistoryid` = ?";
	
	private PreparedStatement pstmt;
	List<Orderhistory> orderhistorylist=new ArrayList<Orderhistory>();
	private List<Orderhistory> orderlist=new ArrayList<Orderhistory>();
	private Orderhistory order1;





	public Orderhistorydaoimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void insert(Orderhistory oh) {
	    try {
	        // First check if the customerid exists in the user table
	        pstmt = con.prepareStatement("SELECT 1 FROM user WHERE uid = ?");
	        pstmt.setInt(1, oh.getUserid());
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (!rs.next()) {
	            // If customer does not exist, print a message and return
	            System.out.println("Customer ID does not exist in the user table.");
	            return;  // Exit early if customer ID is not valid
	        }
	        
	        // If customer exists, proceed with insertion into orderhistory
	        pstmt = con.prepareStatement(Insert);
	        pstmt.setInt(1, oh.getOid());       // Set order history ID
	        pstmt.setInt(2, oh.getUserid());    // Set customer ID (foreign key)
	        pstmt.setInt(3, oh.getRestid());    // Set Eatery ID
	        pstmt.setDouble(4, oh.getTotal());  // Set total price
	        pstmt.setString(5, oh.getStatus()); // Set order status
	        pstmt.setString(6, oh.getRestname());// Set restaurant name
	        
	        int res = pstmt.executeUpdate();
	        if (res != 0) {
	            System.out.println("Orderhistory inserted successfully.");
	        } else {
	            System.out.println("Failed to insert orderhistory.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error during orderhistory insert: " + e.getMessage());
	    }
	}






	public List<Orderhistory> getAll(int id) {
		
		try {
			pstmt=con.prepareStatement(FETCH_ALL);
			pstmt.setInt(1, id);
			ResultSet resultset=pstmt.executeQuery();
			extractAll(resultset);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return orderhistorylist;
			
		}





	public List<Orderhistory> extractAll(ResultSet resultset) {
		try {
			while(resultset.next()) {
				int id=resultset.getInt("orderhistoryid");
				int uid=resultset.getInt("orid");
				int restid=resultset.getInt("custid");
				int user=resultset.getInt("Eateryid");
				Double price=resultset.getDouble("total");
				String status=resultset.getString("status");
				String rest=resultset.getString("restname");
				
				orderhistorylist.add(new Orderhistory(id,uid,restid,user,price,status,rest)); 
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return orderhistorylist;
		}
		
	
public Orderhistory getmax() {
		
		try {
		pstmt=con.prepareStatement(FETCH_ALL_QUERY1);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int oid=rs.getInt("orderhistoryid");
			int ouid=rs.getInt("custid");
			int orid=rs.getInt("orid");
			int orestid=rs.getInt("Eateryid");
			
		
			Double oprice=rs.getDouble("total");
			
			String ostatus=rs.getString("status");
			String rest=rs.getString("restname");
			
			orderlist.add(new Orderhistory(oid,orid,ouid,orestid,oprice,ostatus,rest)); 
			 if(!orderlist.isEmpty()) {
				   order1=orderlist.get(0);
			   }
			   else {
				   System.out.println("user with id not found");
				   System.exit(0);
			   }
		}
		}
		catch(Exception e) {
		
		e.printStackTrace();
		
		}
		return order1;
	}
public void update(int id, String status) {
	int Status=0;
	try {
	System.out.println(id);
	pstmt=con.prepareStatement(UPDATE);
	pstmt.setString(1, status);
	pstmt.setInt(2, id);
	
	
	Status=pstmt.executeUpdate();
	if(Status!=0) {
		System.out.println("updated");
	}
	else {
		System.out.println("not updated");
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	

	
	
}
}
