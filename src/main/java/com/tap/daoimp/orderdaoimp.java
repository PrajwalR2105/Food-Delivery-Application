package com.tap.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Orderdao;
import com.tap.model.Order;

public class orderdaoimp implements Orderdao{

	private String url="jdbc:mysql://localhost:3306/foodclone";
	private String username="root";
	private String password="Jeevan@123";
	private final  String  INSERT_QUERY="insert into `order`(uid, restid, menuid, quantity, totalprice,status, paymentmode) values(?,?,?,?,?,?,?) ";
	private final String FETCH_ALL_QUERY1="SELECT * FROM `order` WHERE orderid = (SELECT MAX(orderid) FROM `order`)";
	private final String FETCH_ALL_QUERY="select * from `order`";
	private final String FETCHH_SPECIFIC="SELECT * from `order` WHERE `orderid` = ?";
	private final String UPDATE="UPDATE `order` SET status = ? WHERE orderid = ?";
			
	private Connection con;
	private PreparedStatement pstmt;
	List<Order> orderlist=new ArrayList<Order>();
	private Order order;
	private Order order1;
	public orderdaoimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Order o) {
		try {
		pstmt=con.prepareStatement(INSERT_QUERY);
		
		pstmt.setInt(1, o.getUserid());
		pstmt.setInt(2, o.getRestaurantid());
		pstmt.setInt(3,o.getMenuid());
		pstmt.setInt(4, o.getQuantity());
		pstmt.setDouble(5, o.getTotalprice());
	    pstmt.setString(6, o.getStatus());
	    pstmt.setString(7,o.getModeofpayment());
	    
		 
		int res=pstmt.executeUpdate();
		if(res!=0) {
			System.out.println("Success");
			
		}
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public List<Order> getAllorder() {
		// TODO Auto-generated method stub
		try {
		pstmt=con.prepareStatement(FETCH_ALL_QUERY);
		ResultSet resultset=pstmt.executeQuery();
		extractAll(resultset);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return orderlist;
		
	}

	public List<Order> extractAll(ResultSet resultset) {
		// TODO Auto-generated method stub
		try {
		while(resultset.next()) {
			int id=resultset.getInt("orderid");
			int uid=resultset.getInt("uid");
			int restid=resultset.getInt("restid");
			int menuid=resultset.getInt("menuid");
			int quant=resultset.getInt("quantity");
			Double price=resultset.getDouble("totalprice");
			LocalDateTime date=resultset.getTimestamp("orderdatetime").toLocalDateTime();
			String status=resultset.getString("status");
			String paymentmode=resultset.getString("paymentmode");
			orderlist.add(new Order(id,uid,restid,menuid,quant,price,paymentmode,status,date)); 
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return orderlist;
	}

	
	public Order getorder(int id) {
		try {
		pstmt=con.prepareStatement(FETCHH_SPECIFIC);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int oid=rs.getInt("orderid");
			int ouid=rs.getInt("uid");
			int orestid=rs.getInt("restid");
			int omenuid=rs.getInt("menuid");
			int oquant=rs.getInt("quantity");
			Double oprice=rs.getDouble("totalprice");
			LocalDateTime odate=rs.getTimestamp("orderdatetime").toLocalDateTime();
			String ostatus=rs.getString("status");
			String opaymentmode=rs.getString("paymentmode");
			orderlist.add(new Order(oid,ouid,orestid,omenuid,oquant,oprice,opaymentmode,ostatus,odate)); 
			 if(!orderlist.isEmpty()) {
				   order=orderlist.get(0);
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
		return order;
	}
public Order getmax() {
		
		try {
		pstmt=con.prepareStatement(FETCH_ALL_QUERY1);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int oid=rs.getInt("orderid");
			int ouid=rs.getInt("uid");
			int orestid=rs.getInt("restid");
			int omenuid=rs.getInt("menuid");
			int oquant=rs.getInt("quantity");
			Double oprice=rs.getDouble("totalprice");
			LocalDateTime odate=rs.getTimestamp("orderdatetime").toLocalDateTime();
			String ostatus=rs.getString("status");
			String opaymentmode=rs.getString("paymentmode");
			orderlist.add(new Order(oid,ouid,orestid,omenuid,oquant,oprice,opaymentmode,ostatus,odate)); 
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
