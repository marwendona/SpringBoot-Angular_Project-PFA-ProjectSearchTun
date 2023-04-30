import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IngenieurService {

  constructor(private http: HttpClient) { }
  getallingenieurs() {
    return this.http.get(`${environment.baseurl}/users/ingenieurs/all`);
  }

  deleteingenieur(id: any){
    return this.http.delete(`${environment.baseurl}/users/ingenieurs/delete/${id}`);

  }

  updateingenieur(id: any, data: any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/update/${id}`,data);
  }

  getingenieur(id: any) {
    return this.http.get(`${environment.baseurl}/users/ingenieurs/getone/${id}`)
  }

  registerIngenieur(newIngenieur: any) {    
    return this.http.post(`${environment.baseurl}/users/ingenieurs/register`,newIngenieur);
  }
  validerIngenieur(id:any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/validerIngenieur/${id}`,{});

  }
  desactiverIngenieur(id:any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/desactiverIngenieur/${id}`,{});

  }
  activerIngenieur(id:any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/activerIngenieur/${id}`,{});

  }
  sendEmail(email: any){
    return this.http.post(`${environment.baseurl}/users/emails/sendMail/${email}`,{});

  }
 
  modifierImage(image:any,id:any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/modifimage/${id}`,image)
  }

 modifierPassword(newpassword:any,id:any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/updatepassword/${id}?newpassword=${newpassword}`,{})
  }
  changeToDispo(id:any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/changeToDispo/${id}`,{})
  }

  changeToIndispo(id:any){
    return this.http.put(`${environment.baseurl}/users/ingenieurs/changeToIndispo/${id}`,{})
  }
}
