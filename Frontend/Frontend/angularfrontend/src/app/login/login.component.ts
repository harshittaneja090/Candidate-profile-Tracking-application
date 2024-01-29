import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import {FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import swal from 'SweetAlert';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  submitted: boolean=true;

  constructor(private router: Router,private loginservice:LoginService) { }
  registerform= new FormGroup({
    username:new FormControl("",[Validators.required,Validators.minLength(3),Validators.maxLength(30)]),
    password:new FormControl("",[Validators.required,Validators.minLength(3),Validators.maxLength(15)]),
    
  });
  

  public logindata={
    username:'',
    password:''

  }
  ngOnInit(): void {
  }

  get  username(): FormControl{

    return this.registerform.get('username') as FormControl
    }
   

    get  password(): FormControl{

      return this.registerform.get('password') as FormControl
      }
//
     

    onSubmit(){
      
  
      this.submitted=false;
  this.loginservice.generateToken(this.logindata).subscribe((data:any)=>{
//console.log("sucess")
console.log(data.token)
//localStorage.setItem("Anshu","kailash")
//localStorage.setItem("token",data.token)

this.loginservice.loginUser(data.token)
swal("Success Done!!", " ", "success");




this.loginservice.getCurrentUser().subscribe((user:any)=>{
this.loginservice.setUser(user);
//console.log(user);


if(this.loginservice.getuserRole()=='Admin'){
  //admin dashboards
  this.router.navigate(['/admin-dashboard'])
  this.loginservice.loginStatusSubject.next(true);
}
else if(this.loginservice.getuserRole()=='Normal'){
  //normal user
  this.router.navigate(['/user-dashboard'])
  this.loginservice.loginStatusSubject.next(true);
}
else{
  this.loginservice.logout();
}
})
  },(error)=>{
    console.log(error)
    swal({title:"Error!!",
    text:"Invalid credentials ",
    icon:"error",
    buttons: {
     roll: {
       text: "try again",
       value: "Confirm",
     },
   },
 
 });
  })
      //alert("login is pressed")
   //   console.log(this.logindata.username,this.logindata.password)
    
  
  
  }

  
  

}
