package com.harshit.model.loginclass;

import org.springframework.security.core.GrantedAuthority;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {

	private String authority ; 
		@Override 
	public String getAuthority() {
		// TODO Auto-generated method stub
	
		return this.authority;
	}

}
