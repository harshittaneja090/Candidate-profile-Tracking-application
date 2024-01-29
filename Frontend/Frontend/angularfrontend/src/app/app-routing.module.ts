import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CandidateListComponent } from './candidate-list/candidate-list.component';
import { CreateCandidateComponent } from './create-candidate/create-candidate.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HelloapplicationComponent } from './helloapplication/helloapplication.component';
import { LevelviewComponent } from './levelview/levelview.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { AdminGuard } from './services/admin.guard';
import { NormalGuard } from './services/normal.guard';
import { UpdateCandidateComponent } from './update-candidate/update-candidate.component';
import { AdmindashboardComponent } from './Userpages/admin/admindashboard/admindashboard.component';
import { AdminprofileComponent } from './Userpages/admin/profile/adminprofile/adminprofile.component';
import { UserprofileComponent } from './Userpages/normaluser/normaluser/userdashboard/profile/userprofile/userprofile.component';
import { UserdashboardComponent } from './Userpages/normaluser/normaluser/userdashboard/userdashboard.component';
import { ViewCandidateComponent } from './view-candidate/view-candidate.component';


//routing is going on
const routes: Routes = [

  {path:'employee',component:EmployeeListComponent},
  {path:'candidate',component:CandidateListComponent},
  {path:'create-candidate',component: CreateCandidateComponent},
  {path:'',redirectTo:'helloapplicationComponent',pathMatch: 'full'},
  {path:'helloapplicationComponent',component:HelloapplicationComponent},
  {path:'login',component:LoginComponent},
  {path:'sign-up',component:SignUpComponent},
  {path:'update-candidate/:id',component:UpdateCandidateComponent},
  {path:'view-candidate/:id',component: ViewCandidateComponent},
  {path:'admin-dashboard',component: AdmindashboardComponent,pathMatch: 'full',canActivate:[AdminGuard]},
  {path:'user-dashboard',component:UserdashboardComponent,pathMatch: 'full',canActivate:[NormalGuard]},
  {path:'adminprofile-dashboard',component:AdminprofileComponent,pathMatch: 'full'},
  {path:'normalprofile-dashboard',component:UserprofileComponent,pathMatch: 'full'},
  {path:'level-candidate/:id',component: LevelviewComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
