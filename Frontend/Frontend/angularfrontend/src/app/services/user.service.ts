import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseUrl="http://localhost:8080/api/v1/user/";

  constructor(private http:HttpClient) 
  {

   }

   //methods for implements
  public adduser(user:any){
    return this.http.post(`${this.baseUrl}`,user)
  }

}
