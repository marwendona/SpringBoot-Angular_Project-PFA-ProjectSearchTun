import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import {DragDropModule} from '@angular/cdk/drag-drop';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HomeComponent } from './components/home/home.component';
import { LayoutComponent } from './components/layout/layout.component';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DetailIngenieurComponent } from './components/detail-ingenieur/detail-ingenieur.component';
import { LoginComponent } from './components/login/login.component';
import { TasksComponent } from './components/tasks/tasks.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RecherchePipe } from './pipes/recherche.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { ToastrModule } from 'ngx-toastr';
import { ListeFicheIngComponent } from './components/liste-fiche-ing/liste-fiche-ing.component';
import { ChartIngComponent } from './components/chart-ing/chart-ing.component';
import { ForgetPasswordComponent } from './components/forget-password/forget-password.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { ConfirmEmailComponent } from './components/confirm-email/confirm-email.component';
import { RegistreUserComponent } from './components/registre-user/registre-user.component';
import { FilterProjectComponent } from './filter-project/filter-project.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import {MatSelectModule} from '@angular/material/select';
import { ModelEditComponent } from './components/model-edit/model-edit.component';
import { ModelViewProjetComponent } from './components/model-view-projet/model-view-projet.component';
//import { ModelComponent } from './model/model.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { ProjectsRequestsListComponent } from './components/projects-requests-list/projects-requests-list.component';
import { UpdatProfileComponent } from './components/updat-profile/updat-profile.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    HomeComponent,
    LayoutComponent,
    DetailIngenieurComponent,
    RegistreUserComponent,
    TasksComponent,
    ProfileComponent,
    RecherchePipe,
    ListeFicheIngComponent,
    ChartIngComponent,
    ForgetPasswordComponent,
    ResetPasswordComponent,
    ConfirmEmailComponent,
    LoginComponent,
    FilterProjectComponent,
    ModelEditComponent,
    ModelViewProjetComponent,
    ProjectsRequestsListComponent,
    UpdatProfileComponent,

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    DragDropModule,
    BrowserAnimationsModule,
    NgxPaginationModule,
    NgMultiSelectDropDownModule.forRoot(),
    MatSelectModule,
    MatDialogModule,
    MatAutocompleteModule

  
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
