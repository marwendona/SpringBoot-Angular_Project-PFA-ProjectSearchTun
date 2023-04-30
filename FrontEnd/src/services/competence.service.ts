import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {

  constructor(private http: HttpClient) { }

  getallcompetences() {
    return this.http.get(`${environment.baseurl}/users/competences/all`);
  }

  createCompetence(newComp: any,id:any) {    
    return this.http.post(`${environment.baseurl}/users/competences/save/${id}`,newComp);
  }
  getcompetence(id: any){
    return this.http.get(`${environment.baseurl}/users/competences/getone/${id}`);
  }

  deletecompetence(id: any){
    return this.http.delete(`${environment.baseurl}/users/competences/delete/${id}`);

  }

}
