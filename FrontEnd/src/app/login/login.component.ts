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

  email: string ="";
  password: string ="";
 
 
  constructor(private router: Router,private http: HttpClient) {}
 
 
  Login() {
    console.log(this.email);
    console.log(this.password);

    let bodyData = {
      "email": this.email,
      "password": this.password,
    };
        this.http.post("http://localhost:8085/api/v1/auth/authenticate", bodyData).subscribe(  (loginMessage: any) => {
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
