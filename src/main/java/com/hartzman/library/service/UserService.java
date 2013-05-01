package com.hartzman.library.service;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hartzman.library.dao.UserDAO;
import com.hartzman.library.entity.User;
import com.hartzman.library.entity.LibraryCard;

public interface UserService {

	public User addUser(User u);
	List<User> getAllUsers();
	User getById(Long id);
	User updateUser(User u);
	void deleteUser(Long id);
	
}
