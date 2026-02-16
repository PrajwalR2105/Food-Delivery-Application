package com.tap.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.Orderitemdao;
import com.tap.model.Orderitem;

public class Orderitemdaoimp implements Orderitemdao {

	private String url="jdbc:mysql://localhost:3306/foodclone";
	private String username="root";
	private String password="Jeevan@123";
	private Connection con;
	private String Insert="insert into `orderitem`(ordid, personid, menid,hotelid,image,price,totalprice,quantity,itemname) values(?,?,?,?,?,?,?,?,?)";
	private final String FETCH_ALL_QUERY="select * from `orderitem`";
	private final String FETCH_ALL1="select * from `orderitem` where `ordid`=?";
	private PreparedStatement pstmt;
	List<Orderitem> orderitemlist=new ArrayList<Orderitem>();
	
	
	public Orderitemdaoimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void insert(Orderitem o) {
		
		try {
			pstmt=con.prepareStatement(Insert);
			
			pstmt.setInt(1, o.getOrderid());
			pstmt.setInt(2, o.getUserid());
			pstmt.setInt(3,o.getItemmenuid());
			pstmt.setInt(4, o.getHotelid());
			pstmt.setString(5, o.getImage());
			pstmt.setDouble(6,o.getPrice());
		    pstmt.setDouble(7,o.getTotalprice());
			
			pstmt.setInt(8, o.getQuantity());
			pstmt.setString(9, o.getItemname());
			
		    
			 
			int res=pstmt.executeUpdate();
			if(res!=0) {
				System.out.println("Success");
				
			}
			
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		}





	public List<Orderitem> fetchAll() {
		try {
		pstmt=con.prepareStatement(FETCH_ALL_QUERY);
		ResultSet resultset=pstmt.executeQuery();
		extractAll(resultset);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return orderitemlist;
	}
	
public List<Orderitem> extractAll(ResultSet resultset) {
	// TODO Auto-generated method stub
	try {
	while(resultset.next()) {
		int id=resultset.getInt("orderitemid");
		int ordid=resultset.getInt("ordid");
		int uid=resultset.getInt("personid");
		int restid=resultset.getInt("hotelid");
		int menuid=resultset.getInt("menid");
		String image=resultset.getString("image");
		String name=resultset.getString("itemname");
		int quant=resultset.getInt("quantity");
		double price=resultset.getDouble("price");
		double total=resultset.getDouble("totalprice");
		
		orderitemlist.add(new Orderitem(id,ordid,uid,restid,menuid,image,name,quant,price,total)); 
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return orderitemlist;
}


     public List<Orderitem> getone(int id) {
	try {
	pstmt=con.prepareStatement(FETCH_ALL1);
	pstmt.setInt(1, id);
	ResultSet resultset=pstmt.executeQuery();
	extractAll(resultset);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return orderitemlist;
 }
	}

