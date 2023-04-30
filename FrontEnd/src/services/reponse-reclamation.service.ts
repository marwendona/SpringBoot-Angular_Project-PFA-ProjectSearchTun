import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ReponseReclamationService {

  constructor(private http: HttpClient) { }
  getallReponseReclamations() {
    return this.http.get(`${environment.baseurl}/users/reponseReclamations/all`);
  }
  addReponseReclamation(reponse:any,idreclamation:any){
    return this.http.post(`${environment.baseurl}/users/reponseReclamations/save/${idreclamation}`,reponse);
  }

}
