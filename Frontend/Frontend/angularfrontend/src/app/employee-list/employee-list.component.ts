import { Component, OnInit } from '@angular/core';
import { Employee } from '../classes/employee';


import { EmployeeService } from '../services/employee.service';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[]=[];
  //get employee service inisde our list component 
  constructor(private employeeService: EmployeeService) { 

  }

  ngOnInit(): void {
//create methid for getiing that data 
this.getEmployees();


    /*putting static data 
    this.employees=[{
"id":1,
 "firstName":"ramesh",
 "lastName":"fadrate",
 "emailID":"cena@gmail.com"
    ,
    }
    ,{
      "id":1,
       "firstName":"ramesh",
       "lastName":"fadrate",
       "emailID":"cena@gmail.com"
          ,
          }
  ];*/
  }
  //above method we are using  to get data from service made by us 
  private getEmployees(){
//using employeeservice refernce 
    this.employeeService.getEmployeeList().subscribe(data=>{
      //console.log(data);
   
      this.employees=data;
      console.log(this.employees);
    });
  }


}
