package com.tap.food.rest;

import java.util.List;

import com.tap.food.rest1.Restaurant;

public interface Restaurantdao {
	void insert(Restaurant r);
	List<Restaurant> fetchAll();
	Restaurant fetchrest(int id);
	int update(int id,String place);
}
