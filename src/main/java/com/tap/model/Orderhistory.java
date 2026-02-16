package com.tap.model;

public class Orderhistory {
	private int orderhistoryid;
	private int oid;
	private int userid;
	private int restid;
	private double total;
	private String status;
	private String restname;
	public int getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRestid() {
		return restid;
	}
	public void setRestid(int restid) {
		this.restid = restid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRestname() {
		return restname;
	}
	public void setRestname(String restname) {
		this.restname = restname;
	}
	public Orderhistory(int oid, int userid, int restid, double total, String status, String restname) {
		super();
		this.oid = oid;
		this.userid = userid;
		this.restid = restid;
		this.total = total;
		this.status = status;
		this.restname = restname;
	}
	public Orderhistory(int orderhistoryid, int oid, int userid, int restid, double total, String status,
			String restname) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.oid = oid;
		this.userid = userid;
		this.restid = restid;
		this.total = total;
		this.status = status;
		this.restname = restname;
	}
	@Override
	public String toString() {
		return "Orderhistory [orderhistoryid=" + orderhistoryid + ", oid=" + oid + ", userid=" + userid + ", restid="
				+ restid + ", total=" + total + ", status=" + status + ", restname=" + restname + "]";
	}
	
}