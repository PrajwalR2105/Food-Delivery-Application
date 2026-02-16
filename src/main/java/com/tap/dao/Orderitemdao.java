package com.tap.dao;

import java.util.List;

import com.tap.model.Orderitem;

public interface Orderitemdao {
	
		void insert(Orderitem o);
		List<Orderitem> fetchAll();
	}


