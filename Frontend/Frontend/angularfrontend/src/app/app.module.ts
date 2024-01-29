import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CandidateListComponent } from './candidate-list/candidate-list.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CreateCandidateComponent } from './create-candidate/create-candidate.component';
import { LoginComponent } from './login/login.component';
import { UpdateCandidateComponent } from './update-candidate/update-candidate.component';
import { HelloapplicationComponent } from './helloapplication/helloapplication.component';
import { ViewCandidateComponent } from './view-candidate/view-candidate.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { AuthInterceptor } from './services/auth.interceptor';
import { UserdashboardComponent } from './Userpages/normaluser/normaluser/userdashboard/userdashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminprofileComponent } from './Userpages/admin/profile/adminprofile/adminprofile.component';
import { UserprofileComponent } from './Userpages/normaluser/normaluser/userdashboard/profile/userprofile/userprofile.component';
import { SkillspageComponent } from './update-candidate/skillspage/skillspage.component';
import { LevelviewComponent } from './levelview/levelview.component';






@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    CandidateListComponent,
    
    CreateCandidateComponent,
         LoginComponent,
         UpdateCandidateComponent,
         HelloapplicationComponent,
         ViewCandidateComponent,
         SignUpComponent,
         UserdashboardComponent,
         NavbarComponent,
         AdminprofileComponent,
         UserprofileComponent,
         SkillspageComponent,
         LevelviewComponent,

     
     
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule
    
  ],
  //provide rinterceptor here 
  providers: [{
    provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
