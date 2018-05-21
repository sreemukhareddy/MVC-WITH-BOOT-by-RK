package com.springboot.web.spring_boot_demo_web_application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
								.antMatchers("/","/*todo*/**").access("hasRole('USER')")
								.and()
								.formLogin();
	}

	// create in28Minutes/dummy
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("in28Minutes").password("dummy").roles("USER","ADMIN");
	}
	

}
