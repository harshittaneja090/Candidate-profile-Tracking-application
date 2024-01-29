import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../classes/employee';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {



  private baseUrl="http://localhost:8080/api/v1/employee";
  //injecting angular http client in service of file 
  constructor(private httpClient:HttpClient) { 

  }
  //method to get all the employee details
  getEmployeeList():Observable<Employee[]>{

    //this is will return list of all employee in json from database to service that we pass to component 
    //console.log(this.httpClient.get<Employee[]>('${this.baseUrl}'));
    return this.httpClient.get<Employee[]>(`${this.baseUrl}`);

  }
}
