package com.harshit.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.harshit.model.Candidate;
import com.harshit.model.Skills;

public interface CandidateService {

	//same name of methods as in controller 
	///
	
	 public List<Candidate> getcandidateList();
	 
	 public Candidate addskills(@RequestBody List<Skills> skill,@PathVariable long id );
	 
public  Candidate updatecandidatedata(@RequestBody List<Skills> skills,@PathVariable long id );
	 
	 
	   public Candidate createcandidate(@RequestBody Candidate candidate);
	   
	   
	   public ResponseEntity<Candidate> getcandidatebyId(@PathVariable long id);
	   
	   
	   public  ResponseEntity<Candidate> updatecandidatedata1(@PathVariable long id, @RequestBody Candidate   cnew);
	   
	   public  ResponseEntity<Map<String,Boolean>> deletecandidatedata(@PathVariable long  id );
}
