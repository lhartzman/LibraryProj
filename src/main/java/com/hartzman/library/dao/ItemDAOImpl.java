package com.hartzman.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hartzman.library.entity.LibraryItem;

@Repository
public class ItemDAOImpl implements ItemDAO {

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	@Autowired
	private SessionFactory sessionFactory;
	
	public ItemDAOImpl()
	{
		System.out.println("created MyDAO object");
	}

	@Transactional(readOnly=false)
	public void addLibraryItem(LibraryItem li)
	{
		Session session = sessionFactory.openSession();
		session.save(li);
		session.close();
	}
}
