package com.hartzman.library.dao;


import org.springframework.stereotype.Repository;

import com.hartzman.library.entity.User;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
	
	// no special implementation currently
	
}
