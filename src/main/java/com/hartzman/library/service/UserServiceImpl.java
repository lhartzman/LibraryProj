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
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public User addUser(User user)
	{
		LibraryCard lc = new LibraryCard();
		DateTime startDate = new DateTime();
		DateTime expiration = new DateTime(startDate).plusYears(1);
		lc.setExpirationDate(expiration);
		lc.setStartDate(startDate);
		user.setLibraryCard(lc);
		userDAO.add(user);
		return user;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public List<User> getAllUsers()
	{
		// return list of all users
		return userDAO.getAll();
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public User updateUser(User user)
	{
		logger.info("updating user");
		return userDAO.update(user);
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public User getById(Long id)
	{
		return userDAO.getById(id);
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public void deleteUser(Long id)
	{
		// removing user
		User u = userDAO.getById(id);
		userDAO.delete(u);
	}
}
