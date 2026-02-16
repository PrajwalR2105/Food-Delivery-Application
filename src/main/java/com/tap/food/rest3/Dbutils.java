package com.tap.food.rest3;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutils {
	 private static Connection con;
	 private  static String username = "root";
	  private static  String password = "Jeevan@123";
	  private static String url="jdbc:mysql://localhost:3306/foodclone";

	
	public static Connection connect() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
