import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FicheService {

  constructor(private http: HttpClient) { }

  getallfiches() {
    return this.http.get(`${environment.baseurl}/users/fiches/all`);
  }

  deletefiche(id: any){
    return this.http.delete(`${environment.baseurl}/users/fiches/delete/${id}`);
  

  }
  getfiche(id: any){
    return this.http.get(`${environment.baseurl}/users/fiches/getone/${id}`);
  }
  createfiche(fiche:any,id:any){
    return this.http.post(`${environment.baseurl}/users/fiches/save/${id}`,fiche);

  }
}
