import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  login(requestLogin: any) {
    return this.http.post(`${environment.baseurl}/users/login`, requestLogin)
  }
  forgetpassword(email:any){
    return this.http.post(`${environment.baseurl}/users/forgetpassword?email=${email}`,{})
  }
  resetpassword(resetLink:any,newPassword:any){
    return this.http.post(`${environment.baseurl}/users/savePassword/${resetLink}?newPassword=${newPassword}`,{})
  }
}
