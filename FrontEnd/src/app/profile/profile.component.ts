import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {



  userDtoFirstName: string ="";
  userDtoLastName: string ="";
  userDtoEmail: string ="";
  userDtoPassword: string ="";
  userDtoSkills: string="";
  userDtoInstitute: string="";
  userDtoGithub: string="";
  userDtoLinekdin: string="";
  userDtoPDP:string="";
  signupForm?: FormGroup;
 
 
  constructor(private http: HttpClient )
  {
 
  }


  save()
  {
  
    let bodyData = {
      "userDtoFirstName" : this.userDtoFirstName,
      "userDtoLastName":this.userDtoLastName,
      "userDtoEmail" : this.userDtoEmail,
      "userDtoPassword" : this.userDtoPassword,
      "userDtoSkills": this.userDtoSkills,
      "userDtoInstitute":this.userDtoInstitute,
      "userDtoGithub":this.userDtoGithub,
      "userDtoLinekdin" : this.userDtoLinekdin,
      "userDtoPDP": this.userDtoPDP,
    };
    this.http.post("http://localhost:8085/api/v1/user/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        
 
    });
  }
  
    }
    


