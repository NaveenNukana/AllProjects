package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.demo.filter.SecurityFilter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private InvalidUserAuthEntryPoint authenticationEntryPoint;
	@Autowired
	private SecurityFilter securityfilter;
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
		
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	protected void configure(HttpSecurity http)throws Exception{
		http.csrf().disable().authorizeRequests().antMatchers("/user/save","/user/login").permitAll()
		.anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    .and()
	    //register filter for 2nd request onwards..
	    .addFilterBefore(securityfilter, UsernamePasswordAuthenticationFilter.class)
		;
		
		
		
	}
}