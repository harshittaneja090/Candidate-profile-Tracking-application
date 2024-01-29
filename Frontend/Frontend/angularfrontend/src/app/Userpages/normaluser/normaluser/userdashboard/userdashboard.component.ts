import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {


  constructor(private loginservice:LoginService, private router :Router) { }
 Name:any;
User:any;
isLoggedIn=false;
user;
routerpath;
Authority;
  ngOnInit(): void {
  this.User=  this.loginservice.getuser()
  this.Name=this.User.name;

  this.isLoggedIn=this.loginservice.isLoggedIn()
    if(this.isLoggedIn){
     this.user=this.loginservice.getuser();
     this.Authority=this.loginservice.getuserRole()
   // console.log("this.user.authorities[0] :"+this.user.authorities[0])
    this.loginservice.loginStatusSubject.asObservable().subscribe((data:any)=>{
      this.isLoggedIn=this.loginservice.isLoggedIn()
      this.user=this.loginservice.getuser();
     
   })
  
  }
 //console.log( this.User.name);
  }





  Addcandidate(){
    this.router.navigate(['/create-candidate'])
 
   }
   candidatelist(){
     this.router.navigate(['/candidate'])
   }

   userprofile(){
    this.router.navigate(["/normalprofile-dashboard"]);
  }
}
