package com.harshit.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.harshit.exception.ResourceNotFoundException;
import com.harshit.model.Candidate;
import com.harshit.model.Skills;
import com.harshit.repository.CandidateRespository;
import com.harshit.repository.SkillsRespository;

@Service
public class CandidateServiceImpl implements CandidateService {

	// JPA repository
	@Autowired
	CandidateRespository CandidateRespository;

	@Autowired
	SkillsRespository SkillsRespository;

	public List<Candidate> getcandidateList() {
		return CandidateRespository.findAll();

	}

	// api call to skill repository for storing in database

	public Candidate addskills(@RequestBody List<Skills> skills, @PathVariable long id) {
		// this will going to pull id from front end api service
		Candidate candidate = this.CandidateRespository.findById(id).get();
		for (Skills skill : skills) {
			skill.setCandidate(candidate);
		}
		List<Skills> s = this.SkillsRespository.saveAll(skills);
		candidate.setSkills(s);
		return CandidateRespository.save(candidate);
	}

	public Candidate updatecandidatedata(@RequestBody List<Skills> skills, @PathVariable long id) {

		Candidate c1 = CandidateRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("candidate not exist with id :" + id));

		Candidate candidate = this.CandidateRespository.findById(id).get();
		candidate.getSkills().clear();
		System.out.print(candidate);
		System.out.print("hello harshit");

		for (Skills skill : skills) {
			skill.setCandidate(candidate);
		}
		List<Skills> s = this.SkillsRespository.saveAll(skills);
		candidate.setSkills(s);
		// candidate.setSkill(skill);
		return CandidateRespository.save(candidate);

	}

	public Candidate createcandidate(@RequestBody Candidate candidate) {
		return CandidateRespository.save(candidate);
	}

	public ResponseEntity<Candidate> getcandidatebyId(@PathVariable long id) {
		// public void getcandidatebyId(@PathVariable long id){
		// Candidate candidate
		// =CandidateRespository.findbyassociateid(id).orElseThrow(()-> new
		// ResourceNotFoundException("candidate not exist with id :"+id));
		// Candidate c=CandidateRespository.findByAssociateId(id).orElseThrow(()-> new
		// ResourceNotFoundException("candidate not exist with id :"+id));
		Candidate c = CandidateRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("candidate not exist with id :" + id));
		return ResponseEntity.ok(c);

	}

	public ResponseEntity<Candidate> updatecandidatedata1(@PathVariable long id, @RequestBody Candidate cnew) {

		Candidate c1 = CandidateRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("candidate not exist with id :" + id));

		c1.setName(cnew.getName());
		c1.setEmailid(cnew.getEmailid());
		c1.setMobile(cnew.getMobile());
		Candidate c2 = CandidateRespository.save(c1);
		return ResponseEntity.ok(c2);
	}

	public ResponseEntity<Map<String, Boolean>> deletecandidatedata(@PathVariable long id) {
		Candidate c1 = CandidateRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("candidate not exist with id :" + id));
		CandidateRespository.delete(c1);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
