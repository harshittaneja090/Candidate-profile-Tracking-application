package com.harshit.model.loginclass;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "user")
// ye user class mai hume spring Security ke methods ke liye UserrDetails interface ko implement kardiya hai
public class User   implements  UserDetails{
	//we are getting auto generated id of user 
		
		//@Column(name="userid" ,unique = true ,nullable = false)
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="userid",unique = true,nullable = false)
	     private Long id;
		@Column(name="Name",nullable = false)
		//@Column(name="Name" ,unique = true ,nullable = false)
		private String name;
		
		//user name 
		//@Column(name="username")
		@Column(name="username" ,unique = true ,nullable = false)
		private String username;
		
		//password

		@Column(name="password" ,nullable = false)
		//@Column(name="password")
		private String password;
		
		
		//password

		@Column(name="email" ,unique = true ,nullable = true)
		private String email;

			
		//enable  means user is active or not 
		//@Column(name="enable" ,unique = true ,nullable = false)
		private boolean enable=true;
					
		
		@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
		@JsonIgnore
		private Set<UserRole> userRoles=new HashSet<>();

		
		//ye methods

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			Set<Authority> set =new HashSet<>();
			this.userRoles.forEach(userRole ->{
				set.add(new Authority(userRole.getRole().getRoleName()));
			} );
			return set;
		}

//userDetails unimplemented methods 
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
	
}
