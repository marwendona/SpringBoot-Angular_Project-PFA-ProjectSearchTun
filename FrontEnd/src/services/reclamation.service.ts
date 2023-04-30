import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReclamationService {

  constructor(private http: HttpClient) { }
  getallReclamations() {
    return this.http.get(`${environment.baseurl}/users/reclamations/all`);
  }

  deleteReclamation(id: any){
    return this.http.delete(`${environment.baseurl}/users/reclamations/delete/${id}`);

  }

  updateReclamation(id: number, data: any){
    return this.http.put(`${environment.baseurl}/users/reclamations/update/${id}`,data);
  }
  addReclamation(reclamation:any,idtache:any){
    return this.http.post(`${environment.baseurl}/users/reclamations/save/${idtache}`,reclamation);
  }
}
