package com.harshit;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.harshit.model.loginclass.Role;
import com.harshit.model.loginclass.User;
import com.harshit.model.loginclass.UserRole;
import com.harshit.services.UserService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
public class CandidateProfileTrackerApplication implements CommandLineRunner {
	//setting passowrd 
		@Autowired
		private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder BCryptPasswordEncoder ;
	@Autowired	
	private UserService userservice;
	public static void main(String[] args) {
		SpringApplication.run(CandidateProfileTrackerApplication.class, args);
	}
	
	
	
// testing via command line 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
 
//	
//		User user=new User();
//		user.setUsername("Admin");
//		//user.setPassword("Admin@123");
//		user.setPassword(this.BCryptPasswordEncoder.encode("Admin@123"));
//		user.setName("Admin");
//		
//		Role role1 =new Role();
//		role1.setId(1);
//		 role1.setRoleName("Admin");
//	
//		 
//		// Set<UserRole> userRoleSet=new HashSet<>();
//			Set<UserRole> userRoleSet=new HashSet<>();
//		 UserRole userRole =new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);  
//		
//		this.userservice.CreateUser(user,userRoleSet);
//	
	}

}
