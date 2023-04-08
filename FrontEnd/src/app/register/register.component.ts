import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  userDtoName: string ="";
  userDtoEmail: string ="";
  userDtoPassword: string ="";
  signupForm?: FormGroup;
 
 
  constructor(private http: HttpClient )
  {
 
  }


  save()
  {
  
    let bodyData = {
      "userDtoName" : this.userDtoName,
      "userDtoEmail" : this.userDtoEmail,
      "userDtoPassword" : this.userDtoPassword
    };
    this.http.post("http://localhost:8085/api/v1/user/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("User Registered Successfully");
 
    });
  }

}
