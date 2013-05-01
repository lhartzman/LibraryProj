package com.hartzman.library.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	T add(T t);
	List<T> getAll();
	T getById(ID id);
	T update(T t);
	void delete(T t);

}
