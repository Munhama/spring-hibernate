package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add users for in memory authentication
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(userBuilder.username("sam").password("sam").roles("EMPLOYEE"))
				.withUser(userBuilder.username("john").password("john").roles("MANAGER"))
				.withUser(userBuilder.username("bob").password("bob").roles("ADMIN"));

	}

}
