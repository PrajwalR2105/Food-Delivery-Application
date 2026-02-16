package com.tap.model;

public class Orderitem {

private int orderitemid;
private int orderid;
private int userid;
private int hotelid;
private int itemmenuid;
private String image;
private String itemname;
private int quantity;

private double price;
private double totalprice;
		
public int getOrderitemid() {
			return orderitemid;
		}
		
public void setOrderitemid(int orderitemid) {
			this.orderitemid = orderitemid;
		}
		
public int getOrderid() {
			return orderid;
		}
		
public void setOrderid(int orderid) {
			this.orderid = orderid;
		}
		
public int getUserid() {
			return userid;
		}
		
public void setUserid(int userid) {
			this.userid = userid;
		}
		
public int getHotelid() {
			return hotelid;
		}
		
public void setHotelid(int hotelid) {
			this.hotelid = hotelid;
		}
		
public int getItemmenuid() {
			return itemmenuid;
		}
		
public void setItemmenuid(int itemmenuid) {
			this.itemmenuid = itemmenuid;
		}
		
public String getImage() {
			return image;
		}
		
public void setImage(String image) {
			this.image = image;
		}
		
public String getItemname() {
			return itemname;
		}
		
public void setItemname(String itemname) {
			this.itemname = itemname;
		}
		
public int getQuantity() {
			return quantity;
		}
		
public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		

		
public Double getPrice() {
			return price;
		}
		
public void setPrice(double price) {
			this.price = price;
		}
		
public double getTotalprice() {
			return totalprice;
		}
		
public void setTotalprice(float totalprice) {
			this.totalprice = totalprice;
		}
		
public Orderitem(int orderitemid, int orderid, int userid, int hotelid, int itemmenuid, String image,
				String itemname, int quantity,  double price, double totalprice) {
			super();
			this.orderitemid = orderitemid;
			this.orderid = orderid;
			this.userid = userid;
			this.hotelid = hotelid;
			this.itemmenuid = itemmenuid;
			this.image = image;
			this.itemname = itemname;
			this.quantity = quantity;
			this.price = price;
			this.totalprice = totalprice;
		}
		
public Orderitem(int orderid, int userid, int hotelid, int itemmenuid, String image, String itemname, int quantity,
				double price, double totalprice) {
			super();
			this.orderid = orderid;
			this.userid = userid;
			this.hotelid = hotelid;
			this.itemmenuid = itemmenuid;
			this.image = image;
			this.itemname = itemname;
			this.quantity = quantity;
			this.price = price;
			this.totalprice = totalprice;
		}
		@Override
		
		public String toString() {
			return "Orderitemclass [orderitemid=" + orderitemid + ", orderid=" + orderid + ", userid=" + userid + ", hotelid="
					+ hotelid + ", itemmenuid=" + itemmenuid + ", image=" + image + ", itemname=" + itemname + ", quantity="
					+ quantity +  ", price=" + price + ", totalprice=" + totalprice + "]";
		}

		public Orderitem() {
			super();
		}
		  
		  
		  
	}

