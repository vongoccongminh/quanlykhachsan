package com.httt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf().disable().
		authorizeRequests().antMatchers("/login").permitAll();
		
		httpSecurity.authorizeRequests().antMatchers("/login").permitAll();
		
		//httpSecurity.authorizeRequests().antMatchers("/employee/**").access("hasAnyRole('ROLE_ADMIN')");
		httpSecurity.authorizeRequests().antMatchers("/employee/**").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/department/**").access("hasAnyRole('ROLE_ADMIN')");
		httpSecurity.authorizeRequests().antMatchers("/","/index", "/home","/report").access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_ADMIN' )");
		// Cấu hình cho Login Form.
		httpSecurity.authorizeRequests()
		 		.and().formLogin()//
				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/index")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")
				
				
				// Cấu hình cho Logout Page.
				.and().exceptionHandling().accessDeniedPage("/403")
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");
		
	}

}
