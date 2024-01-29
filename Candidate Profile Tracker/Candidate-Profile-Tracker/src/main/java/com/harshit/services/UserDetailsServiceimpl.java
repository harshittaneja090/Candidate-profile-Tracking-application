package com.harshit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harshit.model.loginclass.User;
import com.harshit.repository.UserRespository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//ye userservice class jo implement karte SUerService inteface ko vo hume mtlb spring security ko chahiye hai configuration ke liye 
@Service
public class UserDetailsServiceimpl implements UserDetailsService {

	//
@Autowired
	
    private UserRespository userRespository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user =userRespository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return user;
	}

}
