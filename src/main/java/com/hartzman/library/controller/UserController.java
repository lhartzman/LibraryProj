package com.hartzman.library.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.hartzman.library.entity.User;
import com.hartzman.library.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * object for interacting with user service layer
	 */
	@Autowired
	private UserService userService;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		logger.info("in admin\n");
		return "admin";
	}
	
	/**
	 * preps for a new user
	 * 
	 * @param user
	 * @return ModelAndView object
	 */
	@RequestMapping("adduser")
	public ModelAndView addUser(@ModelAttribute("user") User user)
	{
		logger.info(">>>> in 'users'\n");
		return new ModelAndView("newuser", "model", user);
	}
	
	@RequestMapping(value="/newuser", method=RequestMethod.POST)
	public String addNewUser(Locale locale, Model model, @ModelAttribute("user") User user, SessionStatus status)
	{
		logger.info("In 'addNewUser'");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		userService.addUser(user);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name", user.getFirstname());

		// mark 'conversation' complete to clear session attributes
		status.setComplete();
		
		return "adduser";
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String getAllUsers(Model model)
	{
		logger.info("getting all users");
	
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "allusers";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editUser(@RequestParam(value="id", required=true) Integer id, Model model)
	{
		logger.info("editing user");
		model.addAttribute("user", userService.getById(id));
	
		return "edituser";
	}
	
	/**
	 * Initialize a new user so object exists before first call
	 * @return user
	 */
	@ModelAttribute("user")
	public User initUser()
	{
		User user = new User();
		user.setEmail("");
		user.setFirstname("");
		user.setLastname("");
		return user;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(Model model, @ModelAttribute("user") User user, SessionStatus status)
	{
		logger.info("updating user");
		
		userService.updateUser(user);
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		// mark 'conversation' complete to clear session attributes
		status.setComplete();
		return "redirect:all";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value="id", required=true) Integer id, Model model)
	{
		logger.info("deleting user");
		userService.deleteUser(id);
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "redirect:all";
	}
}
