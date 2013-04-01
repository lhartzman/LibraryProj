package com.hartzman.library.service;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hartzman.library.dao.UserDAO;
import com.hartzman.library.entity.User;
import com.hartzman.library.entity.LibraryCard;


@Service("userService")
@Transactional(readOnly=false)
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(User user)
	{
		LibraryCard lc = new LibraryCard();
		DateTime startDate = new DateTime();
		DateTime expiration = new DateTime(startDate).plusYears(1);
		lc.setExpirationDate(expiration);
		lc.setStartDate(startDate);
		user.setLibraryCard(lc);
		userDAO.addUser(user);
	}
	
	public List<User> getAllUsers()
	{
		return userDAO.getAllUsers();
	}
	
	public void updateUser(User user)
	{
		logger.info("updating user");
		userDAO.updateUser(user);
	}
	
	public User getById(Integer id)
	{
		return userDAO.getById(id);
	}
	
	public void deleteUser(Integer id)
	{
		userDAO.deleteUser(id);
	}
}
