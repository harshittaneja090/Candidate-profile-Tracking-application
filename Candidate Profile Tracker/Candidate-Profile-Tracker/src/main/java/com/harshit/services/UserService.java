package com.harshit.services;
import com.harshit.model.loginclass.User;

import com.harshit.model.loginclass.UserRole;
import com.harshit.repository.RoleRepository;
import com.harshit.repository.UserRespository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
public interface UserService {

	

public User CreateUser(User user,Set<UserRole> userRoles) throws Exception;
public User getUsername(String username);
public void deleteuser(Long id);



}
