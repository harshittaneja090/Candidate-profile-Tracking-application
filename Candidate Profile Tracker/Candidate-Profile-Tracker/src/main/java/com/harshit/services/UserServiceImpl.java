package com.harshit.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.model.loginclass.User;
import com.harshit.model.loginclass.UserRole;
import com.harshit.repository.RoleRepository;
import com.harshit.repository.UserRespository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RoleRepository  roleRepository;
	@Autowired
	private UserRespository userRepository;
	
	@Override
	public User CreateUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.print("User is already there ");
			throw new Exception("User already present ");
		}
		else {
			//create user
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			
			}
			user.getUserRoles().addAll(userRoles);
		local= this.userRepository.save(user);	
		}
		return local;
		}
	
	//getting user name from JPA
	public User getUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteuser(Long Userid) {
	
		this.userRepository.deleteById(Userid);
		}
		
	}
	
	


	
	

	


