package com.harshit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.harshit.model.Candidate;

@Repository
public interface CandidateRespository extends JpaRepository<Candidate, Long> {

	
	//CUSTOM MADE QUERY METHOD
	public Candidate  findByAssociateId(long id);

	
//	@Query("SELECT c from candidate  c where c.Name LIKE %?1%" )//+
//	//"OR c.mobile LIKE %?1%" +
//	//"OR c.email LIKE %?1%")
//	public ResponseEntity<Candidate>  findByAnything(String keyword);

}

