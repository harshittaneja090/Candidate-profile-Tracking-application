import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  Addcandidate(){
   this.router.navigate(['/create-candidate'])

  }
  candidatelist(){
    this.router.navigate(['/candidate'])
  }
 
  adminprofile(){
    this.router.navigate(['/adminprofile-dashboard'])
  }

}
