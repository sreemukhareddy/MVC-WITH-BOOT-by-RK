package com.springboot.web.spring_boot_demo_web_application.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean isValidUser(String user,String password) {
		return user.equalsIgnoreCase("in28Minutes") && password.equals("dummy");
	}

}
