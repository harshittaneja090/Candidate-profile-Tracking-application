package com.harshit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="CandidateProfile")


public class Candidate {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@NotBlank(message="AssociateId can't be empty")
	//@Column(name="AssociateId" ,unique = true ,nullable = false)
	private String associateId;
	
	/*
	 @Column(name="AssociateId")
	private String associateId;
	 */
	
	
//	@NotBlank(message="Name can't be empty")
	@Size(min=3,max=30,message="user name must be between 3-30 character")
	@Column(name="name" ,unique = true,nullable = false)
	private String Name;
	@NotBlank(message="mobile can't be empty")
	@Column(name="mobile",unique = true,nullable = false)
	private String mobile;
	@NotBlank(message="emailid can't be empty")
	@Column(name="emailid",unique = true,nullable = false)
	private String emailid;
	//one to mapping uni directional 
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="skillid",referencedColumnName = "id")
//	private Skills Skill;
		
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Skills> skills = new ArrayList<>();
	/*
	 * 
	 public Candidate(){}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getAssociateId() {
		return associateId;
	}
	public void setAssociateId(long associateId) {
		this.associateId = associateId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	public Candidate(long associateId, String name, String mobile, String emailid, Skills skill) {
		super();
		this.associateId = associateId;
		Name = name;
		this.mobile = mobile;
		this.emailid = emailid;
		Skill = skill;
	}
	@Override
	public String toString() {
		return "Candidate [associateId=" + associateId + ", Name=" + Name + ", mobile=" + mobile + ", emailid="
				+ emailid + "]";
	}
	
	
	
	
	public Skills getSkill() {
		return Skill;
	}
	public void setSkill(Skills skill) {
		Skill = skill;
	} 
	
	
	
	*/
	
}