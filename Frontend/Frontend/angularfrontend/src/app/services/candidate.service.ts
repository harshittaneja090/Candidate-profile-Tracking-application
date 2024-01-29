import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Candidate } from '../classes/candidate';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

 

  private baseUrl="http://localhost:8080/api/v1/candidate";
  //injecting angular http client in service of file 
  constructor(private httpClient:HttpClient) { 

  }
  //method to get all the candidate details
  getcandidateList():Observable<Candidate[]>{

    //this is will return list of all employee in json from database to service that we pass to component 
    //console.log(this.httpClient.get<Employee[]>('${this.baseUrl}'));
    return this.httpClient.get<Candidate[]>(`${this.baseUrl}`);
}

//method that will send the candidate to database
SetCandidatedata(Candidate:Candidate):Observable<Candidate>{
  return this.httpClient.post<Candidate>(`${this.baseUrl}`,Candidate);
}

//getemploye id for update component
getcandidateById(id:any):Observable<Candidate>{
  return this.httpClient.get<Candidate>(`${this.baseUrl}/${id}`);
}

//update methods for information
  updatecandidatedata(id: number ,Candidate:Candidate):Observable<object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,Candidate);
  }

  //delete method for delete information
  deletecandidate(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);


  }
  //skill service pi data for posting 
  addskills(skill:any,id:any){
    return this.httpClient.post(`${this.baseUrl}/skills/${id}`,skill);
  }

  updateskill(skill:any,id:any){
    return this.httpClient.post(`${this.baseUrl}/skills/${id}`,skill);
  }

}
