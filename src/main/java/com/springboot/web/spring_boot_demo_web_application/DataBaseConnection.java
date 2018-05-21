package com.springboot.web.spring_boot_demo_web_application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DataBaseConnection {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	public DataBaseConnection() {
		System.out.println("DB" + this);
		logger.info("DataBase -> {}" + this);
	}
}
