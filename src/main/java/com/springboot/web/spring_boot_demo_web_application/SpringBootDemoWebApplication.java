package com.springboot.web.spring_boot_demo_web_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoWebApplication {

	public static void main(String[] args) {
		/*ApplicationContext context=*/
		SpringApplication.run(SpringBootDemoWebApplication.class, args);
		/*PersonDAO personDAO1=context.getBean(PersonDAO.class);
		
		System.out.println(personDAO1);
		System.out.println(personDAO1.getDataBaseConnection());
		
		PersonDAO personDAO2=context.getBean(PersonDAO.class);
		
		System.out.println(personDAO2);
		System.out.println(personDAO2.getDataBaseConnection());*/
	}
}
