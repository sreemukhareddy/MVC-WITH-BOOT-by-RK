package com.springboot.web.spring_boot_demo_web_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/*@Scope("prototype")*/
public class PersonDAO {

	@Autowired
	private DataBaseConnection dataBaseConnection;

	public DataBaseConnection getDataBaseConnection() {
		return dataBaseConnection;
	}

	public void setDataBaseConnection(DataBaseConnection dataBaseConnection) {
		this.dataBaseConnection = dataBaseConnection;
	}
	
	
	
	
}
