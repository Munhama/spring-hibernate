package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

		auth.inMemoryAuthentication().withUser(userBuilder.username("sam").password("sam").roles("EMPLOYEE"))
				.withUser(userBuilder.username("john").password("john").roles("MANAGER", "EMPLOYEE"))
				.withUser(userBuilder.username("bob").password("bob").roles("EMPLOYEE", "ADMIN"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				.and()
				.formLogin()
					.loginPage("/showLoginPage")
					.loginProcessingUrl("/authenticateUser")
					.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
