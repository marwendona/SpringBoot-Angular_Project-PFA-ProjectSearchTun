import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  registerAdmin(newAdmin: any) {    
    return this.http.post(`${environment.baseurl}/users/admins/register`,newAdmin);
  }
}
