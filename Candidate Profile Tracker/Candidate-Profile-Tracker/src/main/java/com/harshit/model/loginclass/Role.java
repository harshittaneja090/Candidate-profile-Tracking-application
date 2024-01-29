package com.harshit.model.loginclass;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


@Entity
public class Role {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="roleid")
//@Column(name="roleid" ,unique = true ,nullable = false)
	private long id;
	

@Column(name="roleName" ,nullable = false)
private String roleName;

//userrole ka set hai mapping ke liye set of object hai ye
@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
@JsonIgnore
private Set<UserRole> userRoles=new HashSet<>();
}
