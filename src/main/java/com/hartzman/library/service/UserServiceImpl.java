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


@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public int addUser(User user)
	{
		LibraryCard lc = new LibraryCard();
		DateTime startDate = new DateTime();
		DateTime expiration = new DateTime(startDate).plusYears(1);
		lc.setExpirationDate(expiration);
		lc.setStartDate(startDate);
		user.setLibraryCard(lc);
		userDAO.addUser(user);
		return user.getUser_id();
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public List<User> getAllUsers()
	{
		return userDAO.getAllUsers();
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public User updateUser(User user)
	{
		logger.info("updating user");
		userDAO.updateUser(user);
		return user;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public User getById(Integer id)
	{
		return userDAO.getById(id);
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public void deleteUser(Integer id)
	{
		userDAO.deleteUser(id);
	}
}
