import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TacheService {

  constructor(private http: HttpClient) { }

  getalltasks() {
    return this.http.get(`${environment.baseurl}/users/taches/all`);
  }
  ValidateEtatInProgress(id:any){
    return this.http.put(`${environment.baseurl}/users/taches/validateInprogress/${id}`,{});
  }
  ValidateEtatReview(id:any){
    return this.http.put(`${environment.baseurl}/users/taches/validateReview/${id}`,{});
  }
  ValidateEtatDone(id:any){
    return this.http.put(`${environment.baseurl}/users/taches/validateDone/${id}`,{});
  }

  addTache(iding:any,idclient:any,tache:any){
    return this.http.post(`${environment.baseurl}/users/taches/save/${iding}/${idclient}`,tache);
  }
  addTacheByAdmin(iding:any,idclient:any,tache:any){
    return this.http.post(`${environment.baseurl}/users/taches/saveTacheByAdmin/${iding}/${idclient}`,tache);
  }
  deleteTache(id: any){
    return this.http.delete(`${environment.baseurl}/users/taches/delete/${id}`);

  }
  updateTache(Idtache:any,iding:any,idclient:any,tache:any){
    return this.http.put(`${environment.baseurl}/users/taches/update/${Idtache}/${iding}/${idclient}`,tache)
  
  }
  addDemande(tache:any,idclient:any){
    return this.http.post(`${environment.baseurl}/users/taches/saveDemande/${idclient}`,tache);
  }
  affecterIng(Id:any,iding:any){
    return this.http.put(`${environment.baseurl}/users/taches/affecterIng/${Id}/${iding}`,{})
  
  }
  affecterIngForDemande(Id:any,iding:any){
    return this.http.put(`${environment.baseurl}/users/taches/affecterIngDemande/${Id}/${iding}`,{})
  
  }

  getOneTache(id:any){
    return this.http.get(`${environment.baseurl}/users/taches/getone/${id}`);
  }

  AccepterdemandeTacheIng(Id:any){
    return this.http.put(`${environment.baseurl}/users/taches/validateEncours/${Id}`,{})
  }

  RefuserdemandeTacheIng(Id:any){
    return this.http.put(`${environment.baseurl}/users/taches/RefuserEtatEnCours/${Id}`,{})
      
  }
sendmail(id:any){
  return this.http.post(`${environment.baseurl}/users/taches/sendmailauto/${id}`,{})
}
 
}
