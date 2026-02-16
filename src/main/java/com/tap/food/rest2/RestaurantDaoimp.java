package com.tap.food.rest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.food.rest1.Restaurant;

public class RestaurantDaoimp {
	private String url="jdbc:mysql://localhost:3306/foodclone";
	private String username="root";
	private String password="Jeevan@123";
	private final String INSERT_QUERY="insert into restaurant values(?,?,?,?,?,?,?,?,?)";
	private final String FETCH_ALL_QUERY="select * from restaurant";
	private final String FETCH_ONE="select * from restaurant where restaurantid=?";
	private final String UPDATE="update restaurant set address=? where restaurantid=?";
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultset;
	List<Restaurant> RS=new ArrayList<Restaurant>();
	private Restaurant restaurant;

	public RestaurantDaoimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
   public void insert(Restaurant r) {
	   int res;
	try {
	   pstmt=con.prepareStatement(INSERT_QUERY);
	   pstmt.setInt(1, r.getRid());
	   pstmt.setString(2, r.getName());
	   pstmt.setString(3, r.getCusineType());
	   pstmt.setString(4,r.getAddress());
	   pstmt.setFloat(5, r.getRatings());
	   pstmt.setString(6, r.getIsActive());
	   pstmt.setString(7, r.getImagePath());
	   pstmt.setString(8,r.getEta());
	   pstmt.setInt(9, r.getRestaurantOwnerId());
	   res=pstmt.executeUpdate();
	   if(res!=0) {
	   System.out.println("Success");
	   }
	   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   
	   
   }

   public List<Restaurant> fetchAll() {
	try {
	pstmt=con.prepareStatement(FETCH_ALL_QUERY);
	resultset=pstmt.executeQuery();
	extractAll(resultset);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return RS;
   }
public List<Restaurant> extractAll(ResultSet resultset) {
	try {
	while(resultset.next()) {
		int id=resultset.getInt("restaurantid");
		String name=resultset.getString("name");
		String cusin=resultset.getString("cusintype");
		String place=resultset.getString("address");
		String image=resultset.getString("image");
		System.out.println(image);
		String openorclose=resultset.getString("isActive");
		String estimate=resultset.getString("eta");
		int ownerid=resultset.getInt("ownerid");
		float review=resultset.getFloat("ratings");
		
		RS.add(new Restaurant(id,name,cusin,place,estimate,review,openorclose,image,ownerid));
		
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return RS;
}

public Restaurant fetchrest(int id) {
	
	try {
		List<Restaurant> lr=new ArrayList<Restaurant>();
		pstmt=con.prepareStatement(FETCH_ONE);
		pstmt.setInt(1, id);
		ResultSet res=pstmt.executeQuery();
		while(res.next()) {
			int rid=res.getInt("restaurantid");
			String rname=res.getString("name");
			String rcusin=res.getString("cusintype");
			String rplace=res.getString("address");
			String rimage=res.getString("image");
			String ropenorclose=res.getString("isActive");
			String restimate=res.getString("eta");
			int rownerid=res.getInt("ownerid");
			float rreview=res.getFloat("ratings");
			
			lr.add(new Restaurant(rid,rname,rcusin,rplace,restimate,rreview,ropenorclose,rimage,rownerid));
			}
		if(!lr.isEmpty()) {
			restaurant=lr.get(0);
		}
		else {
			System.out.println("No data");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return restaurant;
}

    public int update(int id, String place) {
	int Status=0;
	try {
	    pstmt=con.prepareStatement(UPDATE);
	    pstmt.setInt(2, id);
	    pstmt.setString(1, place);
	    Status=pstmt.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return Status;
	    
     }
}
