import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/internal/Subject';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject =new Subject<boolean>();

  constructor(private http:HttpClient) { }
  private baseUrl="http://localhost:8080/api/v1";
//generate token

public generateToken(logindata:any)
{
return this.http.post(`${this.baseUrl}/generate-token`,logindata)
}



//getting the current user details and storaged in session storage  
public getCurrentUser(){
//console.log("login mai arah hai ")
  return this.http.get(`${this.baseUrl}/current-user`)
}




//login user :set token in localStorage
public loginUser(token){
  localStorage.setItem('token',token);
  return true;
}

//isloin :use is logged in or not 
public isLoggedIn(){
let tokenStr=localStorage.getItem("token")

if(tokenStr==undefined || tokenStr==''|| tokenStr==null){
//means person is not login
return false;
}
else{
return true;
} 

}

//logout : remove token fron local storage
public logout(){

localStorage.removeItem("token")
//also removing user details when we logout 
localStorage.removeItem("user")
return true;
} 

//getting token from local storage 
public getToken(){
return localStorage.getItem("token")

}

//setting user details in local storage 
public setUser(user){
localStorage.setItem("user",JSON.stringify(user))


}
//getting user details 
public getuser(){
let userstr=localStorage.getItem("user")
if(userstr!=null){
return JSON.parse(userstr)
}
else{
this.logout()
return null;
}
}

//get user role 

public getuserRole(){
  let user =this.getuser()
  return user.authorities[0].authority;
}




}
