package com.tap.food.user2;

import java.util.List;

import com.tap.food.user1.User;

public interface Userdao {
	 void insert(User u);
	  List<User> fetchAll();
	  User getuser(int id);
	  void deleteUser(int userId);
	  User fetchuser(String email);
	  int update(User u);
}
