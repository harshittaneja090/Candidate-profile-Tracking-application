import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Candidate } from '../classes/candidate';
import { CandidateService } from '../services/candidate.service';
import {FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
@Component({
  selector: 'app-view-candidate',
  templateUrl: './view-candidate.component.html',
  styleUrls: ['./view-candidate.component.css']
})
export class ViewCandidateComponent implements OnInit {
 id:any;
 candidate :any =[];



  constructor(private router :Router,private route:ActivatedRoute,private candidateService :CandidateService) { }

  ngOnInit(): void {

    this.id=this.route.snapshot.params['id'];

     this.candidate=new Candidate();
    //now we going to call get candidate method
    this.candidateService.getcandidateById(this.id).subscribe(data=>{
this.candidate=data;

//this.Skill=this.candidate.skill
//console.log(this.candidate);




//console.log(this.Skill);

//console.log(this.candidate.skill.skills);
//logic

    })
  }
}
