package com.tap.food.menu1;

import java.util.List;

import com.tap.food.menu.Menuclass;

public interface Menudao {

	void insert(Menuclass m);
	List<Menuclass> fetchAll();
	List<Menuclass> fetchone(int id);
	Menuclass fetchspecific(int mid);
	
}
