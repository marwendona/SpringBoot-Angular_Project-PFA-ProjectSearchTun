import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }
  getallclients() {
    return this.http.get(`${environment.baseurl}/users/clients/all`);
  }

  deleteclient(id: any){
    return this.http.delete(`${environment.baseurl}/users/clients/delete/${id}`);
  

  }
  modifierImage(image:any,id:any){
    return this.http.put(`${environment.baseurl}/users/clients/modifimage/${id}`,image)
  }

 modifierPassword(newpassword:any,id:any){
    return this.http.put(`${environment.baseurl}/users/clients/updatepassword/${id}?newpassword=${newpassword}`,{})
  }
  updateclient(id: number, data: any){
    return this.http.put(`${environment.baseurl}/users/clients/update/${id}`,data);
  }

  getclient(id: any){
    return this.http.get(`${environment.baseurl}/users/clients/getone/${id}`)
  }

  registerClient(newClient: any) {    
    return this.http.post(`${environment.baseurl}/users/clients/register`,newClient);
  }
  validerClient(id:any){
    return this.http.put(`${environment.baseurl}/users/clients/validerClient/${id}`,{});

  }
  desactiverClient(id:any){
    return this.http.put(`${environment.baseurl}/users/clients/desactiverClient/${id}`,{});

  }
  activerClient(id:any){
    return this.http.put(`${environment.baseurl}/users/clients/activerClient/${id}`,{});

  }
  sendEmail(email: any){
    return this.http.post(`${environment.baseurl}/users/emails/sendMail/${email}`,{});

  }

  
}
