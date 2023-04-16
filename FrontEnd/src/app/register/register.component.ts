import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

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
        console.log(resultData);
        alert("User Registered Successfully");
 
    });
  }

}