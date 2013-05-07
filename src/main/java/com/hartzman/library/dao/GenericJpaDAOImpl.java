package com.hartzman.library.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericJpaDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> clazz;
	private static final Logger logger = LoggerFactory.getLogger(GenericJpaDAOImpl.class);
		
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public GenericJpaDAOImpl()
	{
		this.clazz = (Class<T>)((ParameterizedType)getClass().
				getGenericSuperclass()).getActualTypeArguments()[0];
		logger.info(">>>>>class name = " + clazz.getSimpleName());
	}
	
	@Override
	public T add(T t) {
		logger.info("DAOImpl:add");
		entityManager.persist(t);
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		logger.info("DAOImpl:getAll");
		// create query
		logger.info("JPQL statement = " + "Select t From " + clazz.getSimpleName() + " t");
		TypedQuery<T> query = entityManager.createQuery("Select t From " +  clazz.getSimpleName() + " t", clazz);
		return (List<T>)query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		logger.info("DAOImpl:getById");
		T t = entityManager.find(clazz, id);
		return t;
	}

	@Override
	public T update(T t) {
		logger.info("DAOImpl:update");
		return entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		logger.info("DAOImpl:delete");
		entityManager.remove(t);
	}

}
