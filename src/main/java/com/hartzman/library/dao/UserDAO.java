package com.hartzman.library.dao;

import java.io.Serializable;
import java.util.List;

import com.hartzman.library.entity.User;

public interface UserDAO {

	public int addUser(User user);
	public List<User> getAllUsers();
	public User updateUser(User u);
	public User getById(Integer id);
	public void deleteUser(Integer id);
}
