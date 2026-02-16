package com.tap.dao;

import java.util.List;

import com.tap.model.Order;

public interface Orderdao {
		  void insert(Order o);
		  List<Order> getAllorder();
		  Order getorder(int id);
}

