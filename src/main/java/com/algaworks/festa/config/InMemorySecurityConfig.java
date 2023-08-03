package com.algaworks.festa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder buider) 
	throws Exception{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		buider.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
		.withUser("mariana").password(passwordEncoder.encode("123")).roles("USER")
		.and()
		.passwordEncoder(passwordEncoder)
		.withUser("kic").password(passwordEncoder.encode("123")).roles("USER")
		.and()
		.passwordEncoder(passwordEncoder)
		.withUser("a").password(passwordEncoder.encode("123")).roles("USER");
	}

}
