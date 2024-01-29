import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import swal from 'SweetAlert';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

isLoggedIn=false;
user;
routerpath;
  constructor(public loginservice:LoginService,private router:Router) { }

  ngOnInit(): void {
   this.isLoggedIn=this.loginservice.isLoggedIn()
  if(this.isLoggedIn){
   this.user=this.loginservice.getuser();
 // console.log("this.user.authorities[0] :"+this.user.authorities[0])
  this.loginservice.loginStatusSubject.asObservable().subscribe((data:any)=>{
    this.isLoggedIn=this.loginservice.isLoggedIn()
    this.user=this.loginservice.getuser();
    this.navabarhome();
 })

}
  //console.log(this.user)
  }

  public navabarhome(){
if(this.loginservice.getuserRole()=="Admin"){
  this.routerpath=  '/admin-dashboard';
}
else{
  this.routerpath ='/user-dashboard';
}
  }
  
  
  

  public logout(){
    swal("Success Done!!", " ", "success");
this.loginservice.logout();
this.isLoggedIn=false;
this.user=null;

//window.location.href='/login'
this.router.navigate(['/login']); 
}

}


