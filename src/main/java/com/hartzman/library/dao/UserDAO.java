package com.hartzman.library.dao;

import java.util.List;

import com.hartzman.library.entity.User;

public interface UserDAO {

	public void addUser(User user);
//	public void deleteUser(int it);
//	public User getUserById(int id);
//	public void editUser(int id);
	public List<User> getAllUsers();
	public void updateUser(User u);
	public User getById(Integer id);
	public void deleteUser(Integer id);
}
