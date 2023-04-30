import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) { }

  addNotification(idReclamation:any){
    return this.http.post(`${environment.baseurl}/users/notifications/save/${idReclamation}`,{});
  }

  getallNotifications() {
    return this.http.get(`${environment.baseurl}/users/notifications/all`);
  }
}
