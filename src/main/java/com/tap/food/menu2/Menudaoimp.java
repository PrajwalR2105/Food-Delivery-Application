package com.tap.food.menu2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.food.menu.Menuclass;
import com.tap.food.menu1.Menudao;

public class Menudaoimp implements Menudao {

    private String url = "jdbc:mysql://localhost:3306/foodclone";
    private String username = "root";
    private String password = "Jeevan@123";
    private Connection con;
    private final String INSERT_QUERY = "insert into menu values(?,?,?,?,?,?,?,?)";
    private final String FETCH_QUERY = "select * from menu";
    private final String FETCH_ONE = "select * from menu where restaurantid=?";
    private final String FETCH_TWO = "select * from menu where menuid=?";
    private PreparedStatement pstmt;
    private ResultSet resultset;
    private List<Menuclass> lm = new ArrayList<Menuclass>();

    
    public Menudaoimp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public void insert(Menuclass m) {
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            pstmt.setInt(1, m.getMenuId());
            pstmt.setInt(3, m.getRestaurantId());
            pstmt.setString(7, m.getName());
            pstmt.setString(8, m.getDescription());
            pstmt.setFloat(4, m.getPrice());
            pstmt.setFloat(5, m.getRating());
            pstmt.setBoolean(6, true); 
            pstmt.setString(2, m.getImagePath());

            int res = pstmt.executeUpdate();
            if (res != 0) {
                System.out.println("Menu item inserted successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public List<Menuclass> fetchAll() {
        try {
            pstmt = con.prepareStatement(FETCH_QUERY);
            resultset = pstmt.executeQuery();
            extractAll(resultset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lm;
    }

    
    private List<Menuclass> extractAll(ResultSet resultset) {
        try {
            while (resultset.next()) {
                int id = resultset.getInt("menuid");
                String name = resultset.getString("name");
                String desc = resultset.getString("description");
                float rate = resultset.getFloat("price");
                float review = resultset.getFloat("ratings");
                boolean available = resultset.getBoolean("isAvailable");
                String image = resultset.getString("image");
                System.out.println(image);
                int restaurant = resultset.getInt("restaurantid");

                lm.add(new Menuclass(id, name, rate, desc, image, available, restaurant, review));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lm;
    }

   
    public List<Menuclass> fetchone(int id) {
        try {
            pstmt = con.prepareStatement(FETCH_ONE);
            pstmt.setInt(1, id);
            resultset = pstmt.executeQuery();
            extractAll(resultset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lm;
    }

    
    @Override
    public Menuclass fetchspecific(int mid) {
        Menuclass menu = null;
        try {
            pstmt = con.prepareStatement(FETCH_TWO); 
            pstmt.setInt(1, mid);
            resultset = pstmt.executeQuery();

            if (resultset.next()) {
                int menid = resultset.getInt("menuid");
                String mname = resultset.getString("name");
                String mdesc = resultset.getString("description");
                float mrate = resultset.getFloat("price");
                float mreview = resultset.getFloat("ratings");
                boolean mavailable = resultset.getBoolean("isAvailable");
                String mimage = resultset.getString("image");
                int mrestaurant = resultset.getInt("restaurantid");

              
                menu = new Menuclass(menid, mname, mrate, mdesc, mimage, mavailable, mrestaurant, mreview);
                System.out.println("Menu item found: " + menu.getName());
            } else {
                System.out.println("No menu item found with ID: " + mid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }
}
