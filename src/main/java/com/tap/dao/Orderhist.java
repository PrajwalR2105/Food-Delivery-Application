package com.tap.dao;

import java.util.List;

import com.tap.model.Orderhistory;

public interface Orderhist {

	void insert(Orderhistory oh);
	List<Orderhistory> getAll(int id);
}
