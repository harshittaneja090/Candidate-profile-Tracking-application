package com.harshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.exception.ResourceNotFoundException;
import com.harshit.model.Candidate;
import com.harshit.model.Skills;
import com.harshit.repository.CandidateRespository;
import com.harshit.repository.SkillsRespository;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
//
//	@Autowired
//	CandidateRespository CandidateRespository;
//	
//	@Autowired
//    SkillsRespository SkillsRespository;
//	//saving data into jpa
//	   @PostMapping("/skills/{id}")
//	   public Skills addskills(@RequestBody Skills skill,@PathVariable long id ) {
//		   
//		   Candidate candidate =this.CandidateRespository.findById(id).get();
//		   
//		   return SkillsRespository.save(skill);
//	   }
//	   
//	 /*  
//	   @PutMapping("/candidate/skills/{id}")
//	   public  Candidate updatecandidatedata(@RequestBody Skills skill,@PathVariable long id ){
//		   
//		   Candidate c1= CandidateRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("candidate not exist with id :"+id));
//		  
//		   Candidate candidate =this.CandidateRespository.findById(id).get();
//		   
//		   candidate.setSkill(skill);
//		   return CandidateRespository.save(candidate);
//	
//	   }
//	   */
//}
}
