import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  userFirstName: string ="";
  userLastName: string ="";
  email: string ="";
  password: string ="";
  skills: string="";
  institute: string="";
  profession:string="";
  photo:string="";
  cv:string="";
  github: string="";
  linkedin: string="";
  signupForm?: FormGroup;
 
 
  constructor(private http: HttpClient )
  {
 
  }


  save()
  {
  
    let bodyData = {
      "userFirstName" : this.userFirstName,
      "userLastName":this.userLastName,
      "email" : this.email,
      "password" : this.password,
      "institute":this.institute,
      "profession":this.profession,
      "skills": this.skills,
      "photo": this.photo,
      "cv": this.cv,
      "linkedin" : this.linkedin,
      "github":this.github,
    };

    console.log(bodyData);
    this.http.post("http://localhost:8085/api/v1/user/save", bodyData, {responseType: 'text'}).subscribe(
      (resultData: any) => {
          console.log(resultData);
          alert("User Registered Successfully");
      },
      (error) => {
          console.log(error);
          alert("Error occurred while registering user");
      }
  );
    
  }

}