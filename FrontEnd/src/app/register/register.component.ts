import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  employeename: string ="";
  email: string ="";
  password: string ="";
 
 
  constructor(private http: HttpClient )
  {
 
  }
  save()
  {
  
    let bodyData = {
      "employeename" : this.employeename,
      "email" : this.email,
      "password" : this.password
    };
    this.http.post("http://localhost:8085/api/v1/employee/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee Registered Successfully");
 
    });
  }

}
