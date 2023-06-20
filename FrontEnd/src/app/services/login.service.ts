import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, tap } from "rxjs/operators";

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
//---------------------------------------------------------------------------

authenticate(email: string, password: string): Observable<string> {
  return this.http.post("api/v1/auth/authenticate", null, {
    responseType: 'text',
    headers: {
      'Authorization': 'Basic ' + btoa(`${email}:${password}`),
    }
  }).pipe(
    tap((response: any) => {
      localStorage.setItem('jwt_token', response);
    })
  );
}

getToken(): string {
  return localStorage.getItem("jwt_token")!;
}
/*
isLoggedIn(): boolean {
  const token = this.getToken();
  return token != null && !this.isTokenExpired(token);
}*/

logout(): void {
  localStorage.removeItem("jwt_token");
}

}
