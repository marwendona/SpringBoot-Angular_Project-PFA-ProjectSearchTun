import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ConfirmEmailComponent } from './components/confirm-email/confirm-email.component';
import { DetailIngenieurComponent } from './components/detail-ingenieur/detail-ingenieur.component';
import { ForgetPasswordComponent } from './components/forget-password/forget-password.component';
import { HomeComponent } from './components/home/home.component';
import { LayoutComponent } from './components/layout/layout.component';
import { ListeFicheIngComponent } from './components/liste-fiche-ing/liste-fiche-ing.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegistreUserComponent } from './components/registre-user/registre-user.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { TasksComponent } from './components/tasks/tasks.component';
import { AuthGuard } from './guards/auth.guard';
import { FilterProjectComponent } from './filter-project/filter-project.component';
import { ChartIngComponent } from './components/chart-ing/chart-ing.component';
import { ProjectsRequestsListComponent } from './components/projects-requests-list/projects-requests-list.component';
import { UpdatProfileComponent } from './components/updat-profile/updat-profile.component';



const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'registreUser',component:RegistreUserComponent},
  {path:'forgetPassword',component:ForgetPasswordComponent},
  {path:'confirmEmail',component:ConfirmEmailComponent},
  {path:'resetPassword/:resetLink',component:ResetPasswordComponent},
  {path:'chart',component:ChartIngComponent},
  {path:'filterProject',component:FilterProjectComponent},

  {path:"home",component: HomeComponent ,children:[
    {path:'',component:LayoutComponent},
    {path:'profileIng',component:ProfileComponent},
    {path:'tasks',component:TasksComponent},
    {path:'detailIngenieur/:id',component:DetailIngenieurComponent},
    {path:'layout',component:LayoutComponent},
    {path:'listeficheIng',component:ListeFicheIngComponent},
    {path:'projects_requests_list',component:ProjectsRequestsListComponent},
    {path:'UpdatProfile',component:UpdatProfileComponent},


    
    

 ]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
