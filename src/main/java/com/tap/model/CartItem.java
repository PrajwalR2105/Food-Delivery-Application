package com.tap.model;

public class CartItem {
  private int itemId;
  private int restaurantid;
  private String image;
  private String name;
  private int quantity;
  private float price;
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public int getRestaurantid() {
	return restaurantid;
}
public void setRestaurantid(int restaurantid) {
	this.restaurantid = restaurantid;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public CartItem() {
	super();
}
public CartItem(int itemId, int restaurantid, String image, String name, int quantity, float price) {
	super();
	this.itemId = itemId;
	this.restaurantid = restaurantid;
	this.image = image;
	this.name = name;
	this.quantity = quantity;
	this.price = price;
}
@Override
public String toString() {
	return "CartItem [itemId=" + itemId + ", restaurantid=" + restaurantid + ", image=" + image + ", name=" + name
			+ ", quantity=" + quantity + ", price=" + price + "]";
}

  
  
}
