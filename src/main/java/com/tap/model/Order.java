package com.tap.model;

import java.time.LocalDateTime;

public class Order {

	private int orderid;
	private int userid;
	private int restaurantid;
	private int menuid;
	private int quantity;
	private Double totalprice;
	private String modeofpayment;
	private String status;
	private LocalDateTime orderdatetime;
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
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public String getModeofpayment() {
		return modeofpayment;
	}
	public void setModeofpayment(String modeofpayment) {
		this.modeofpayment = modeofpayment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getOrderdatetime() {
		return orderdatetime;
	}
	public void setOrderdatetime(LocalDateTime orderdatetime) {
		this.orderdatetime = orderdatetime;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "order [orderid=" + orderid + ", userid=" + userid + ", restaurantid=" + restaurantid + ", menuid="
				+ menuid + ", quantity=" + quantity + ", totalprice=" + totalprice + ", modeofpayment=" + modeofpayment
				+ ", status=" + status + ", orderdatetime=" + orderdatetime + "]";
	}
	public Order(int orderid, int userid, int restaurantid, int menuid, int quantity, Double totalprice,
			String modeofpayment, String status, LocalDateTime orderdatetime) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.restaurantid = restaurantid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.modeofpayment = modeofpayment;
		this.status = status;
		this.orderdatetime = orderdatetime;
	}
	public Order(int userid, int restaurantid, int menuid, int quantity, Double totalprice, String modeofpayment) {
		super();
		this.userid = userid;
		this.restaurantid = restaurantid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.modeofpayment = modeofpayment;
	}
	public Order( int userid, int restaurantid, int menuid, int quantity, Double totalprice,
			String modeofpayment, String status) {
		super();
		
		this.userid = userid;
		this.restaurantid = restaurantid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.modeofpayment = modeofpayment;
		this.status = status;
	}
	
	

}
