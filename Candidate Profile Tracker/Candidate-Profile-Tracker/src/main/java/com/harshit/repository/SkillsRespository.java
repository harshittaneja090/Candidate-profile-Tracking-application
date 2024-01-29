package com.harshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshit.model.Candidate;
import com.harshit.model.Skills;
@Repository
public interface SkillsRespository extends JpaRepository<Skills, Long> {

	
	//public Skills findByCandidate(Candidate candidate);
}
