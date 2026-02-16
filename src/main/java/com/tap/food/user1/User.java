package com.tap.food.user1;

import java.time.LocalDateTime;

public class User {
private int uid;
private String uname;
private String email;
private String password;
private long mobile;
private LocalDateTime createdDate;
private LocalDateTime lastlogin;
private String address;

public User() {
	super();
}
public User(int uid, String uname, String email, String password, long mobile,
		LocalDateTime createdDate, LocalDateTime lastlogin, String address) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.createdDate = createdDate;
	this.lastlogin = lastlogin;
	this.address = address;
}

public User(String uname, String email, String password, long mobile, String address) {
	super();
	this.uname = uname;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.address = address;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getUid() {
	return uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public LocalDateTime getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDateTime createdDate) {
	this.createdDate = createdDate;
}
public LocalDateTime getLastlogin() {
	return lastlogin;
}
public void setLastlogin(LocalDateTime lastlogin) {
	this.lastlogin = lastlogin;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return   uid + " " + uname + " " + email + " " +
			password + " " + mobile + " " + createdDate + " " + lastlogin
			+ " " + address ;
	
}
public User(int uid, String uname, String email, long mobile, String address) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.email = email;
	this.mobile = mobile;
	this.address = address;
}



}

