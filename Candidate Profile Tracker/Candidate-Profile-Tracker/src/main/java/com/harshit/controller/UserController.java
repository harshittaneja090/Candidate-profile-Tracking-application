package com.harshit.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.harshit.Security.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.model.Skills;
import com.harshit.model.loginclass.Role;
import com.harshit.model.loginclass.User;
import com.harshit.model.loginclass.UserRole;
import com.harshit.services.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	
	//
@Autowired	
private UserService userservice;	


//setting passowrd 
	@Autowired
	private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder BCryptPasswordEncoder ;

@PostMapping("/user/")
public User createUser(@RequestBody User user) throws Exception {

	//set of UserRole hai jiska name roles hai ye sb role tabe ka hai 
	Set<UserRole> roles =new HashSet<>();
	Role role =new Role();
	role.setId(2);
	role.setRoleName("Normal");
	
	
	// ye userRole table ka hai ek object ir usko user or role ka object mapaing waale pass kar denge hum 
	UserRole userRole =new UserRole();
	userRole.setUser(user);
	userRole.setRole(role);
	user.setPassword(this.BCryptPasswordEncoder.encode(user.getPassword()));
	
	
	roles.add(userRole);

		return this.userservice.CreateUser(user, roles);
	

}

//API call to add the user
@GetMapping("/{username}")
public User getUserName(@PathVariable String username ) {
	return this.userservice.getUsername(username);
}


@DeleteMapping("/{userid}")
public void deleteuser(@PathVariable("userid") Long Userid ) {
	 this.userservice.deleteuser(Userid);
}


}
