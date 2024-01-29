import { Component, OnInit } from '@angular/core';
import {FormControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import swal from 'SweetAlert';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  submitted: boolean=true;
  registerform= new FormGroup({
    username:new FormControl("",[Validators.required,Validators.minLength(3),Validators.maxLength(30)]),
    password1:new FormControl("",[Validators.required,Validators.minLength(3),Validators.maxLength(15)]),
    name:new FormControl("",[Validators.required,Validators.minLength(3),Validators.maxLength(30)]),
    emailid:new FormControl("",[Validators.required,Validators.email]),
  });


//user binding
public  user={
name:'',
username:'',
password:'',
email:'',
}  








  get  username(): FormControl{

    return this.registerform.get('username') as FormControl
    }
    get  name(): FormControl{

      return this.registerform.get('name') as FormControl
      }

    get  password1(): FormControl{

      return this.registerform.get('password1') as FormControl
      }
      get  emailid(): FormControl{

        return this.registerform.get('emailid') as FormControl
        }
  

    
  constructor(private router: Router,private userservice :UserService) { }

  ngOnInit(): void {
  }
  onSubmit(){
      
    this.submitted=false;
if(this.user.username==''|| this.user.username==null){

  alert("please enter user details ")
}
    console.log(this.user)
   

    this.userservice.adduser(this.user).subscribe((data:any)=>{
console.log(data)
//alert("success")
swal("Success", 'User Registered with Id :'+data.id, "success");
this.router.navigate(['login'])
    },(error)=>{
      swal({title:"Sorry",
       text:"User Already exist ",
       icon:"error",
       buttons: {
        roll: {
          text: "try again",
          value: "Confirm",
        },
      },
    
    });
      //alert("something went wrong");
      console.log(error)   
    } 
    
    );
  }

}
