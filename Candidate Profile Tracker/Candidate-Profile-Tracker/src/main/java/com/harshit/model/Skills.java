package com.harshit.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Skills")
public class Skills {
//ye auto increment value lega  0 to jha tk hoga 	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Long level;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Candidate candidate;
	
	
	
	/*

	
	
	
	@Override
	public String toString() {
		return "Skills [id=" + id + ", candidate=" + candidate +  ", NonTechnicalskills="
				+ NonTechnicalskills + ", Technicalskills=" + Technicalskills + "]";
	}

	public Skills(long id, Candidate candidate,  String nonTechnicalskills, String technicalskills) {
		super();
		this.id = id;
		this.candidate = candidate;
	
		NonTechnicalskills = nonTechnicalskills;
		Technicalskills = technicalskills;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}


	

	public String getNonTechnicalskills() {
		return NonTechnicalskills;
	}

	public void setNonTechnicalskills(String nonTechnicalskills) {
		NonTechnicalskills = nonTechnicalskills;
	}

	public String getTechnicalskills() {
		return Technicalskills;
	}

	public void setTechnicalskills(String technicalskills) {
		Technicalskills = technicalskills;
	}


	
	
	
	*/
}
