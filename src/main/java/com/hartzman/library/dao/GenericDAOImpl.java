package com.hartzman.library.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> clazz;
	private static final Logger logger = LoggerFactory.getLogger(GenericDAOImpl.class);
		
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl()
	{
		this.clazz = (Class<T>)((ParameterizedType)getClass().
				getGenericSuperclass()).getActualTypeArguments()[0];
		logger.info(">>>>>class name = " + clazz.getSimpleName());
	}
	
	@Override
	public T add(T t) {
		Session session = sessionFactory.getCurrentSession();
		logger.info("DAOImpl:add");
		session.save(t);
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = sessionFactory.getCurrentSession();
		logger.info("DAOImpl:getAll");
		// create query
		Query query = session.createQuery("FROM " + clazz.getSimpleName());
		return (List<T>)query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		Session session = sessionFactory.getCurrentSession();
		logger.info("DAOImpl:getById");
		T t = (T)session.get(clazz, id);
		return t;
	}

	@Override
	public T update(T t) {
		Session session = sessionFactory.getCurrentSession();
		logger.info("DAOImpl:update");
		session.saveOrUpdate(t);
		return t;
	}

	@Override
	public void delete(T t) {
		Session session = sessionFactory.getCurrentSession();
		logger.info("DAOImpl:delete");
		session.delete(t);

	}

}
