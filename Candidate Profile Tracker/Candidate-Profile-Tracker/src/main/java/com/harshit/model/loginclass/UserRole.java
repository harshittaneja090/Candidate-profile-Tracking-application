package com.harshit.model.loginclass;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter



@Entity
@Table(name="UserRole")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long UserRoleId;
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;

	@ManyToOne
	private Role role;
}

