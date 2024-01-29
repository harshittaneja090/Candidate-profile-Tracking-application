import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-adminprofile',
  templateUrl: './adminprofile.component.html',
  styleUrls: ['./adminprofile.component.css']
})
export class AdminprofileComponent implements OnInit {
  isLoggedIn=false;
  user;
  routerpath;
  constructor(public loginservice:LoginService,private router:Router) { }
Authority;
  ngOnInit(): void {
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
  }

}
