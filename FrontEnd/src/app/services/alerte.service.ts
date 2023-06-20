import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AlerteService {

  constructor(private http: HttpClient) { }

  addAlerte(idReponseReclamation:any){
    return this.http.post(`${environment.baseurl}/users/alertes/save/${idReponseReclamation}`,{});
  }

  getallAlertes() {
    return this.http.get(`${environment.baseurl}/users/alertes/all`);
  }
}
