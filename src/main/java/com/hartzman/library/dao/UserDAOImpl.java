package com.hartzman.library.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hartzman.library.controller.UserController;
import com.hartzman.library.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public UserDAOImpl()
	{
		System.out.println("created UserDAOImpl object");
	}

	public int addUser(User u) {
		Session session = sessionFactory.getCurrentSession();
		logger.info("UserDAOImpl:addUser");
		session.save(u);
		return u.getUser_id();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		Session session = sessionFactory.getCurrentSession();
		logger.info("UserDAOImpl:getAllUsers");

		// TODO put query in file to be referenced
		// create query
		Query query = session.createQuery("FROM User");
		return (List<User>)query.list();
	}

	public User updateUser(User u)
	{
		logger.info("UserDAOImpl:updateUser");
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
		return u;
	}
	
	public User getById(Integer id)
	{
		logger.info("UserDAOImpl:getById");
		Session session = sessionFactory.getCurrentSession();

		// TODO put query in file to be referenced
		// create query to select by id
		Query query = session.createQuery("from User where user_id = :id");
		query.setParameter("id", id);
		User result = (User)query.uniqueResult();
		return result;
	}
	
	public void deleteUser(Integer id)
	{
		logger.info("UserDAOImpl:deleteUser");
		Session session = sessionFactory.getCurrentSession();
		
		// TODO put query in file to be referenced
		// create query to delete user by id
		Query query = session.createQuery("delete from User where user_id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
