package com.harshit.Security;

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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.harshit.services.UserDetailsServiceimpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceimpl userdetailservice;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final  String requestTokenHeader=request.getHeader("Authorization");
		//System.out.println("requestTokenHeader:"+requestTokenHeader);
		String Username=null;
		String JwtToken=null;
		
		//System.out.println("request: "+request);
		//System.out.println("requestTokenHeader: "+requestTokenHeader);
		System.out.println("request.getHeader: "+request.getHeaderNames());
	//	if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {	
			JwtToken=requestTokenHeader.substring(7);
			try {
		Username=this.jwtUtil.extractUsername(JwtToken);
			
		}
			catch(ExpiredJwtException e) {
				e.printStackTrace();
				System.out.print("Token has expired");
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			//Username=this.jwtUtil.extractUsername(JwtToken);
			System.out.println("Invalid token "+"String not start with Bearer");
			//System.out.println(Username);
		}
		
		
		
		//validate token here 
		if(Username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		final	UserDetails userdetails=this.userdetailservice.loadUserByUsername(Username);
		
		if(this.jwtUtil.validateToken(JwtToken, userdetails)) {
			//token is valid
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new 	UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		else {
			System.out.println("Token is not valid");
		}
		
	
		}
		
		filterChain.doFilter(request, response);
	}

}
