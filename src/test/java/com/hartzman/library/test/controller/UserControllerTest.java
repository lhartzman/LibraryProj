package com.hartzman.library.test.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.RequestBuilder;
import org.springframework.test.web.server.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.server.request.MockMvcRequestBuilders;
import org.springframework.test.web.server.result.MockMvcResultMatchers;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hartzman.library.controller.UserController;
import com.hartzman.library.entity.User;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
//@ContextConfiguration(locations = {"classpath:test-context.xml", 
//"file:src/main/webapp/WEB-INF/web.xml"})
public class UserControllerTest {
	
	private MockMvc mockMvc;
	private UserController controller;
//	private MockHttpServletRequest request;
	private RequestBuilder mockHttpRequest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		controller = new UserController();
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//		this.request = mockHttpRequest.buildRequest(wac.getServletContext());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserAdd() {
		User user = new User();
		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/library/users/adduser, null").
					param("firstname", "Joe").param("lastname", "Blow").param("email", "jblow@blow.net")).
//					andExpect(content().mimeType(MediaType.TEXT_HTML)).
					andExpect(status().isOk()).andExpect(model().attributeExists("newuser"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
