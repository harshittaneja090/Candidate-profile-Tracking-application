import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Candidate } from '../classes/candidate';
import { CandidateService } from '../services/candidate.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-candidate-list',
  templateUrl: './candidate-list.component copy.html',
  //templateUrl: './candidate-list.component.html',
  styleUrls: ['./candidate-list.component.css']
})
export class CandidateListComponent implements OnInit {
  [x: string]: any;
  Searchtext: any;
  isLoggedIn = false;

  user = null;

  Candidate: any = [];
  //get employee service inisde our list component 
  constructor(private CandidateService: CandidateService, private router: Router, public loginservice: LoginService) {

  }


  ngOnInit(): void {

    this.loginservice.loginStatusSubject.asObservable().subscribe((data: any) => {
      this.isLoggedIn = this.loginservice.isLoggedIn()

      console.log(this.loginservice.getuser())



    })


    // console.log(this.loginservice.getuser().name)
    this.user = this.loginservice.getuser();






    this.getCandidate();

    //console.log("candidate name :"+ Candidate)
  }

  public getAuthoritycheck() {

    if (this.loginservice.getuserRole() == 'Admin') {

      return true;
    }
    else {

      return false;
    }
  }


  public getAuthoritycheckupdate() {
    //if(this.name==Candidate.name){

    //     return true;
    //   }
    // else{
    //  return  false
    // }
  }

  private getCandidate() {
    //using employeeservice refernce 
    this.CandidateService.getcandidateList().subscribe((data: any) => {
      //console.log("data.name"+data[0].name); 
      // console.log(data[0].skills);
      this.Candidate = data;
      //      this.Candidate.skills=data.skills;
      for (let i = 0; i < data.length; i++) {
      //  console.log("this.Candidate :" + this.Candidate[i]);
     //   console.log("this.Candidate :" + this.Candidate[i].name);
      
}

      // this.Candidate.map(c => {
      //   let skillArray = [];
      //   console.log("c :" + c)
        
      //   c.skills.map(s => {
      //     skillArray.push(s.name)
      //   })
      //   console.log("c.skills :" + c.skills)
      //   console.log("c.skills :" + c.skills)
      //  c.skill = skillArray.toString()
          
      // }) 

 
      let skillArray = [];
 this.Candidate.map(c => {
       
       // console.log("c :" + c)
        
        for (let i = 0; i < c.skills.length; i++) {
       //   console.log("c.skills[i] :" + c.skills[i].name)
  
        //  console.log("c.skills[i] :" + c.skills[i].level)
        }   

        c.skills.map(s => {
          skillArray.push(s.name+":"+s.level)
        })
        
       // console.log("c.skills :" + c.skills)
      
       c.skill = skillArray.toString()

       skillArray=[]
       
     
      }) 

    


      //  console.log(this.Candidate);
    });

  }
  updatecandidate(id: any) {
    this.router.navigate(["update-candidate", id]);
  }






  deletecandidate(id: any) {
    this.CandidateService.deletecandidate(id).subscribe(data => {
      this.getCandidate();
    })
  }

  //view button on click function 
  viewcandidate(id: any) {
    //this is navigating to view component via router 

    // console.log("id::::->",id);

    this.router.navigate(["view-candidate", id]);


  }
  levelcandidate(id: any) {
    this.router.navigate(["level-candidate", id]);
  }
}
