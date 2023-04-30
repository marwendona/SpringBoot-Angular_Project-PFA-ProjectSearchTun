import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DemandeClotureService {

  constructor(private http: HttpClient) { }


  getallDemandesCloture() {
    return this.http.get(`${environment.baseurl}/users/demandesCloture/all`);
  }

  createDemandeCloture(id:any){
    return this.http.post(`${environment.baseurl}/users/demandesCloture/save/${id}`,{});

  }
  accepterDemande(Iddemande: any, idtache: any){
    return this.http.put(`${environment.baseurl}/users/demandesCloture/accepterDemande/${Iddemande}/${idtache}`,{});
  }
  
}
