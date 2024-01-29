package com.harshit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.exception.ResourceNotFoundException;
import com.harshit.model.Candidate;
import com.harshit.model.Skills;

import com.harshit.services.CandidateServiceImpl;
import com.harshit.repository.CandidateRespository;

import com.harshit.repository.SkillsRespository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

	//Service repository 
	@Autowired
	CandidateServiceImpl CandidateService;
	
	
	
	
   @GetMapping("/candidate")
    public List<Candidate> getcandidateList(){
		return CandidateService.getcandidateList();
	  
}
   //api call to skill repository for storing in database 
   @PostMapping("/candidate/skills/{id}")
   public Candidate addskills(@RequestBody List<Skills> skill,@PathVariable long id ) {
	   //this will going to pull id from front end api service 
	   return CandidateService.addskills(skill,id);
   } 
   
   //putmapping the ye the ye
   @PutMapping("/candidate/skills/{id}")
   public  Candidate updatecandidatedata(@RequestBody List<Skills> skills,@PathVariable long id ){
	   
	   
	   return CandidateService.updatecandidatedata(skills,id);

   } 
   
   //saving data into jpa
   @PostMapping("/candidate")
   public Candidate createcandidate(@RequestBody Candidate candidate) {
	   return CandidateService.createcandidate(candidate);
   }
   
   //find by id
   @GetMapping("/candidate/{id}")
   public ResponseEntity<Candidate> getcandidatebyId(@PathVariable long id){
   //public void getcandidatebyId(@PathVariable long id){
	  //Candidate candidate =CandidateRespository.findbyassociateid(id).orElseThrow(()-> new ResourceNotFoundException("candidate not exist with id :"+id));
	    //Candidate c=CandidateRespository.findByAssociateId(id).orElseThrow(()-> new ResourceNotFoundException("candidate not exist with id :"+id));
	  
	    return  CandidateService.getcandidatebyId(id);
	   
   }
   
   @PutMapping("/candidate/{id}")
   public  ResponseEntity<Candidate> updatecandidatedata(@PathVariable long id, @RequestBody Candidate   cnew){
	   
	   
	  
	  
	   return  CandidateService.updatecandidatedata1(id,cnew);
   }
   
   
//   @GetMapping("/candidate/{id}")
//   public ResponseEntity<Candidate> searchvalueforadmin(@PathVariable String keyword){
//	   return  CandidateService.searchvalueforadmin(keyword);
//   }
   
//delete mapping and send response back with boolean as true 
 @DeleteMapping("/candidate/{id}")  
 public  ResponseEntity<Map<String,Boolean>> deletecandidatedata(@PathVariable long  id ){
	
	 return  CandidateService.deletecandidatedata(id);
 }

}
