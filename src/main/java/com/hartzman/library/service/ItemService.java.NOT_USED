/**
 * 
 */
package com.hartzman.library.service;

/**
 * @author les
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hartzman.library.dao.ItemDAO;
import com.hartzman.library.dao.ItemDAOImpl;
import com.hartzman.library.entity.LibraryItem;


@Service("itemService")
public class ItemService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void addLibraryItem(LibraryItem li)
	{
		itemDAO.addLibraryItem(li);
	}
}
