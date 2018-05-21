package com.springboot.web.spring_boot_demo_web_application.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	/*@Autowired
	LoginService loginService;*/
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("name", getLoggedInUserName(model));
		return "welcome";
	}
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	/*@RequestMapping(value="/login",method=RequestMethod.POST)
	public String onceURLoggedIn(@RequestParam String name,@RequestParam String password,ModelMap model) {
		
		boolean valid = loginService.isValidUser(name, password);
		
		if(valid == false) {
			model.put("message", "you have entered wrong credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}*/

}
