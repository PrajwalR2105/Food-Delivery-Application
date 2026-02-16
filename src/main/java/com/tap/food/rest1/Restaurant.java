package com.tap.food.rest1;

public class Restaurant {

	
		private int rid;
		private String name;
		private String cusineType;
		private String address;
		private String eta;
		private float ratings;
		private String isActive;
		private String imagePath;
		private int restaurantOwnerId;

		public Restaurant(int rid, String name, String cusineType, String address, String eta, float ratings, String isActive,
				String imagePath, int restaurantOwnerId) {
			super();
			this.rid = rid;
			this.name = name;
			this.cusineType = cusineType;
			this.address = address;
			this.eta = eta;
			this.ratings = ratings;
			this.isActive = isActive;
			this.imagePath = imagePath;
			this.restaurantOwnerId = restaurantOwnerId;
		}
		public int getRid() {
			return rid;
		}
		public void setRid(int rid) {
			this.rid = rid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCusineType() {
			return cusineType;
		}
		public void setCusineType(String cusineType) {
			this.cusineType = cusineType;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEta() {
			return eta;
		}
		public void setEta(String eta) {
			this.eta = eta;
		}
		public float getRatings() {
			return ratings;
		}
		public void setRatings(float ratings) {
			this.ratings = ratings;
		}
		public String getIsActive() {
			return isActive;
		}
		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		public int getRestaurantOwnerId() {
			return restaurantOwnerId;
		}
		public void setRestaurantOwnerId(int restaurantOwnerId) {
			this.restaurantOwnerId = restaurantOwnerId;
		}
		public Restaurant() {
			super();
		}
		@Override
		public String toString() {
			return rid + " " + name + " " + cusineType + " " + address
					+ "  " + eta + " " + ratings + " " + isActive + " " + imagePath
					+ " " + restaurantOwnerId ;
		}


		}


