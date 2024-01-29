import { Component, OnInit } from '@angular/core';
import { Candidate } from 'src/app/classes/candidate';
import { Skill } from 'src/app/classes/skill';

@Component({
  selector: 'app-skillspage',
  templateUrl: './skillspage.component.html',
  styleUrls: ['./skillspage.component.css']
})
export class SkillspageComponent implements OnInit {
  submitted: boolean=true;
 
  id:number;
  cid:any;

  rangevalue1:any;


 
truevalue:boolean;

  valueChanged1(e) {
    //console.log("this.rangevalue1"+this.rangevalue1);

    this.rangevalue1 = e.target.value;
  }
 

  candidate: Candidate=new Candidate();

  Skill: Skill=new  Skill();
  constructor() { }

  ngOnInit(): void {
  }

}
