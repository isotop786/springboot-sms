package com.maruf.sms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("myuser")
			.password("pass123")
			.roles("USER")
			.and()
			.withUser("user2")
			.password("pass2")
			.roles("USER")
			.and()
			.withUser("managerUser")
			.password("pass3")
			.roles("ADMIN")
			;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests()
		.antMatchers("/students/new")
		.hasRole("ADMIN")
		.antMatchers("/students/update").hasRole("ADMIN")
		.antMatchers("/courses/new").hasRole("ADMIN")
		.antMatchers("/students/").authenticated()
		.and().formLogin()
		;
	}
}
