package com.harshit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.Security.JwtUtil;
import com.harshit.model.JwtRequest;
import com.harshit.model.JwtResponse;
import com.harshit.model.loginclass.User;
import com.harshit.services.UserDetailsServiceimpl;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticateController {
	
	@Autowired
	private UserDetailsServiceimpl userDetailsServiceImpl ;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	//generate token api controller
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest JwtRequest) throws Exception{
	//System.out.print("hello token ");
	//System.out.print(JwtRequest);
		try {
			System.out.println("JwtRequest.getUsername :"+JwtRequest.getUsername());
			Authenticate(JwtRequest.getUsername(),JwtRequest.getPassword());
		}
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User Not found");
		}
////
	UserDetails userDetail=	userDetailsServiceImpl.loadUserByUsername(JwtRequest.getUsername());
	String token=this.jwtUtil.generateToken(userDetail);
	return ResponseEntity.ok(new JwtResponse(token));
	
	}
	
	//to get the details from current user 
	@CrossOrigin("*")
	@GetMapping("/current-user")
	public User getCurrentuser(Principal principal) {
		
	return ((User)this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
	} 
	
	

	
	private void Authenticate(String Username,String Password) throws Exception {
	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Username,Password));
					} 
					
		
				
		catch(DisabledException e) {
			e.printStackTrace();
			throw new  Exception("User disabled"+e.getMessage());
		}
		catch (BadCredentialsException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new  Exception("Invalid credential"+e.getMessage());
		}
	}

}
