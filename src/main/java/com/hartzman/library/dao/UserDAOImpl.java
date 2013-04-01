package com.hartzman.library.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hartzman.library.controller.UserController;
import com.hartzman.library.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		session = this.sessionFactory.openSession();
	}

	private SessionFactory sessionFactory;
	private Session session;
	
	public UserDAOImpl()
	{
		System.out.println("created UserDAOImpl object");
	}


	public void addUser(User u) {
		logger.info("UserDAOImpl:addUser");
		session.save(u);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		logger.info("UserDAOImpl:getAllUsers");

		// create query
		Query query = session.createQuery("FROM User");
		return (List<User>)query.list();
	}

	public void updateUser(User u)
	{
		logger.info("UserDAOImpl:updateUser");
		session.saveOrUpdate(u);
	}
	
	public User getById(Integer id)
	{
		logger.info("UserDAOImpl:getById");

		// create query to select by id
		Query query = session.createQuery("from User where user_id = :id");
		query.setParameter("id", id);
		User result = (User)query.uniqueResult();
		return result;
	}
	
	public void deleteUser(Integer id)
	{
		logger.info("UserDAOImpl:deleteUser");
		
		// create query to delete user by id
		Query query = session.createQuery("delete from User where user_id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
