package com.example.demo.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.demo.util.JwtUtil;
@Component
public class SecurityFilter extends OncePerRequestFilter{
	@Autowired
	private JwtUtil util;
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void doFilterInternal
	(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException
	{
		//1.read token from auth head
		 String token=request.getHeader("Authorization");
		 //username should not be empty,context authentication must be empty
		 if(token!=null) {
			 //do validation
			String username= util.getUsername(token);
			if(username!=null &&
					SecurityContextHolder.getContext()
					.getAuthentication()==null)
			{
				UserDetails usr=userDetailsService.loadUserByUsername(username);
				//validate token
				boolean isValid=util.validateToken(token, usr.getUsername());
				if(isValid) {
					UsernamePasswordAuthenticationToken authToken=
							new UsernamePasswordAuthenticationToken(
									username,usr.getPassword());
					
					authToken.setDetails(new WebAuthenticationDetailsSource() .buildDetails(request));
					//final object stored in securityContext with user details(un/pwd)
					
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		 }
		 filterChain.doFilter(request,response);
	}
		
	
	}