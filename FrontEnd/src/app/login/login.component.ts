import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  hide = true;

  loginDtoEmail: string ="";
  loginDtoPassword: string ="";
 
 
  constructor(private router: Router,private http: HttpClient) {}
 
 
  Login() {
    console.log(this.loginDtoEmail);
    console.log(this.loginDtoPassword);

    let bodyData = {
      loginDtoEmail: this.loginDtoEmail,
      loginDtoPassword: this.loginDtoPassword,
    };
        this.http.post("http://localhost:8085/api/v1/user/login", bodyData).subscribe(  (loginMessage: any) => {
        console.log(loginMessage);
        console.log(loginMessage.message);

        if (loginMessage.loginMessage == "Email not exits")
        {
      
          alert("Email not exits");
    
        }
        else if(loginMessage.loginMessage == "Login Success")
    
        {
          this.router.navigateByUrl('/home');
        }
        else
        {
          alert("Incorrect Email and Password not match");
        }
 
      });
    }
}
