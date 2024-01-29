import { Component, OnInit } from '@angular/core';
import { Candidate } from '../classes/candidate';
import { ActivatedRoute, Router } from '@angular/router';
import { CandidateService } from '../services/candidate.service';
import {FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { Skill } from '../classes/skill';
import swal from 'SweetAlert';
import { skip } from 'rxjs';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-update-candidate',
  templateUrl: './update-candidate.component.html',
  styleUrls: ['./update-candidate.component.css']
})
export class UpdateCandidateComponent implements OnInit {


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



  constructor(private CandidateService : CandidateService,private route:ActivatedRoute,private router:Router,public loginservice:LoginService) { }

  registerform= new FormGroup({
    name1:new FormControl("",[Validators.required,Validators.minLength(2),Validators.pattern("[a-zA-Z'].*")]),
    associateId1:new FormControl("",[Validators.required,Validators.minLength(3),Validators.maxLength(30)]),
    emailid1:new FormControl("",[Validators.required,Validators.email]),
    mobile1:new FormControl("",[Validators.required,Validators.minLength(10),Validators.maxLength(10),Validators.pattern("[0-9]*")]),
  });
  
  
  get  name1(): FormControl{
  
  return this.registerform.get('name1') as FormControl
  }
  
  
  get  associateId1(): FormControl{
  
    return this.registerform.get('associateId1') as FormControl
    }
    
  
    get  emailid1(): FormControl{
  
      return this.registerform.get('emailid1') as FormControl
      }
      get  mobile1(): FormControl{
  
        return this.registerform.get('mobile1') as FormControl
        }
        
        public getAuthoritycheck(){
  
          if(this.loginservice.getuserRole()=='Admin'){
          //  console.log("Admin")
          this.truevalue=false;
                }
                else{
              //    console.log("normal")
              this.truevalue=true;
                }
        }




  ngOnInit(): void {
    this.getAuthoritycheck();
this.id=this.route.snapshot.params['id'];
//console.log("this.id",this.id)
this.CandidateService.getcandidateById(this.id).subscribe(data =>{
//this.candidate=this.candidate.associateId;
this.candidate=data;
//console.log(this.candidate.skillsArray[0].level)
//this.Skill=this.candidate.skill;

//console.log("this.candidate.skills :"+this.candidate.skills[0].level)
this.Skill.technicalskillslevel=this.candidate.skillsArray[0].level;
this.rangevalue1=this.candidate.skillsArray[0].level;





// console.log(this.candidate.skill)
    },error => console.log(error))
  }

 
  key: any;
  value: any;
  vaueofskill: Boolean = false;
  Listofskillsarray = [];

  String1: any = ""
  addskillvaluefeature() {

    // //     //logic to add the array 
    
    
    // alert("Skill button is pressed!!!")
    
        //new modification
        this.key = this.Skill.technicalskills;
        this.value = this.Skill.technicalskillslevel;
        this.String1 = "\n" + this.String1 + "\n" + this.key + ":" + this.value + "\n";
    
    
    //     ///my custom logic
    this.Listofskillsarray.push({name:this.key,level:this.Skill.technicalskillslevel})
    console.log(this.Listofskillsarray)
    this.vaueofskill = true;
    
    
    
    
      }

      clearfunctionality() {

        this.vaueofskill = false;
    
    
        //this.Listofskillsarray=this.Listofskillsarray.splice(0,this.Listofskillsarray.length)
        while (this.Listofskillsarray.length > 0) {
          this.Listofskillsarray.pop();
        }
        this.String1 = ""
      }
    
      valuedfunction() {
        return this.vaueofskill;
      }


  //redirectfunctiontolistofcandidate using routing
  redirectfunction(){
    this.router.navigate(['/candidate']);
  }
  
  onSubmit(){
    this.submitted=false;

//     let skillsarray=[];
//     this.Skill.technicalskills.map(s=>{
//       skillsarray.push({name:s,level:this.Skill.technicalskillslevel})
//     })
// this.Skill.skillsArray=skillsarray

this.Skill.skillsArray=this.Listofskillsarray;




    //console.log(this.candidate)
    //here we are calling above method
    this.CandidateService.updatecandidatedata(this.id,this.candidate).subscribe((data:any) =>{
    //this.CandidateService.updateskill(Skill);
    this.cid=data.id;


    console.log( this.cid)
  console.log(this.Skill.skillsArray)
    this.CandidateService.updateskill(this.Skill.skillsArray,this.cid).subscribe(data=>{
      swal("Success Done!!", "Record updated ", "success");
      this.redirectfunction();
      
     },error => console.log(error))

     swal("Failed!!!",  "error");
    
     },error => console.log(error))
     
  };
  
  

 

  
  }

