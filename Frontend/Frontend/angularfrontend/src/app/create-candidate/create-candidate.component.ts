import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Candidate } from '../classes/candidate';
import swal from 'SweetAlert';
import { Skill } from '../classes/skill';

import { CandidateService } from '../services/candidate.service';
import { FormControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-create-candidate',
  templateUrl: './create-candidate.component.html',
  styleUrls: ['./create-candidate.component.css']
})
export class CreateCandidateComponent implements OnInit {
  submitted: boolean = true;

  rangevalue1 = 0;
  valueChanged1(e) {


    this.rangevalue1 = e.target.value;
  }


  registerform = new FormGroup({
    name1: new FormControl("", [Validators.required, Validators.minLength(2), Validators.pattern("[a-zA-Z'].*")]),
    associateId1: new FormControl("", [Validators.required, Validators.minLength(3), Validators.maxLength(30)]),
    emailid1: new FormControl("", [Validators.required, Validators.email]),
    mobile1: new FormControl("", [Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern("[0-9]*")]),
  });


  get name1(): FormControl {

    return this.registerform.get('name1') as FormControl
  }


  get associateId1(): FormControl {

    return this.registerform.get('associateId1') as FormControl
  }


  get emailid1(): FormControl {

    return this.registerform.get('emailid1') as FormControl
  }
  get mobile1(): FormControl {

    return this.registerform.get('mobile1') as FormControl
  }


  status: boolean = false;

  Skill: Skill = new Skill();


 // Skill2: Skill = new Skill();
  candidate: Candidate = new Candidate();
  //both intialize router and candidate service 
  constructor(private CandidateService: CandidateService, private router: Router, private formbuilder: FormBuilder) {


  }

  ngOnInit(): void {
  this.Listofskillsarray=[]

  }

  //In this function we are going to service class to save data in dataabase using this SetCandidatedata()
  
  setskill(cid: any) {
    this.CandidateService.addskills(this.Skill.skillsArray, cid).subscribe(data => {
      //console.log(data)




      this.redirectfunction();



    })
  }
  //redirectfunctiontolistofcandidate using routing
  redirectfunction() {
    this.router.navigate(['/candidate']);
  }
  key: any;
  value: any;
  vaueofskill: Boolean = false;
  Listofskillsarray = [];

  String1: any = ""+"\n";


  savecandidate() {
    this.CandidateService.SetCandidatedata(this.candidate).subscribe((data: any) => {
      //console.log(data);
      // console.log("data.id:>",data.id);
      this.setskill(data.id);
      swal("Success Done!!", "Record saved ", "success");

      //alert("record save successfully ")
    }, (error) => {
      // alert("something went wrong");
      swal("Failed!!!", 'Candidate exist with these Details:\n\n' + "Associate-ID:" + this.candidate.associateId + "\n" + "Name:" + this.candidate.name + "\n" + "Mobile No:" + this.candidate.associateId + "\n" + "Email:" + this.candidate.emailid, "error");
      console.log(error)
    }
    );
  }



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



  //when we hit submit button this function will execute 
  onSubmit() {

    this.submitted = false;
    //console.log(this.Skill)
    //console.log("this.Listofskillsarray :" + this.Listofskillsarray)



    //     console.log(this.candidate)
    //     let skillsarray=[];
    //     this.Skill.technicalskills.map(s=>{
    //       skillsarray.push({name:s,level:this.Skill.technicalskillslevel})
    //     })
    // this.Skill.skillsArray=skillsarray

    this.Skill.skillsArray=this.Listofskillsarray;
    
 this.Listofskillsarray=[]

    

    


    if (this.candidate.emailid == null && this.candidate.associateId == null && this.candidate.mobile == null && this.candidate.name == null && this.candidate.skill == null && this.Skill.technicalskills == null  ) {
      //  alert("!!! Please add valid value before submit  !!!")
      swal("Warning!!!", 'Please fill all the required Inputs ', "warning");
    }

    else {



      //here we are calling above method
    this.savecandidate();
    }




  }
  



}
