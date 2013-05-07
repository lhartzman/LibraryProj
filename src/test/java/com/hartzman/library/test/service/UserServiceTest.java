package com.hartzman.library.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hartzman.library.dao.GenericHibernateDAOImpl;
import com.hartzman.library.dao.UserDAO;
import com.hartzman.library.entity.User;
import com.hartzman.library.service.UserService;
import com.hartzman.library.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class UserServiceTest
{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;
    private List<User> users = new ArrayList<User>();
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    	for (User u : users)
    	{
    		userService.deleteUser(u.getId());
    	}
    }

    @Test
    public void testAddUser()
    {
    	User user = new User("Fred", "Farkel", "ffarkel@farkel.net");
    	userService.addUser(user);
    	users.add(user);
    	logger.debug("(testAddUser):  just added user");
    	User insertedUser = userService.getById(user.getId());
    	assertNotNull("Returned user is null", insertedUser);
    	assertEquals("Users not equal", user, insertedUser);
    }
    
    @Test
    public void testUpdteUser()
    {
    	User u = new User("Fred", "Farkel", "ffarkel@farkel.net");
    	
    	// add the user
    	userService.addUser(u);
    	
    	users.add(u);
    	
    	// modify a field and update the record
    	u.setEmail("fred@farkel.net");
    	userService.updateUser(u);
    	
    	User updatedUser = userService.getById(u.getId());
    	assertEquals("Update of user did not work", u, updatedUser);
    }
    
    @Test
    public void testGetAllUsers()
    {
    	// create array of users to be inserted
    	
    	User u1 = new User("Fred", "Farkel", "ffarkel@farkel.net");
    	User u2 = new User("Jane", "Doe", "janedoe@does.net");
    	User u3 = new User("John", "Doe", "johndoe@does.net");
    	
    	userService.addUser(u1);
    	userService.addUser(u2);
    	userService.addUser(u3);

    	users.add(u1);
    	users.add(u2);
    	users.add(u3);
    	
    	List<User> insertedUsers = new ArrayList<User>();
    	insertedUsers.add(u1);
    	insertedUsers.add(u2);
    	insertedUsers.add(u3);
    	
    	// retrieve all inserted users
    	List<User> returnedUsers = userService.getAllUsers();
     	assertEquals("Returned list doesn't match inserted", returnedUsers, insertedUsers);
    }
}
