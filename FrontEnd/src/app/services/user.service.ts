import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, tap } from 'rxjs';
import { LoginService } from './login.service';
import { Projet } from '../models/Projet';
import { projetV1 } from '../models/projetV1';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private loginService: LoginService) { }
  getallusers() {
    return this.http.get(`${environment.baseurl}/users/users/all`);
  }

  deleteuser(id: any){
    return this.http.delete(`${environment.baseurl}/users/users/delete/${id}`);

  }

  updateUser(d1:any): Observable<string> {

    console.log(d1)
     alert("updateUser service   :   "+d1)
     const p={
      "role":"ADMIN",
      "userFirstName": d1.userFirstName,
      "userLastName":d1.userLastName,
      "email":d1.email,
      "password":d1.password,
      "institute":d1.institute,
      "profession":d1.profession,
      "photo":d1.photo,
      "cv":d1.cv,
      "linkedin":d1.linkedin,
      "github":d1.github   
      }
  
      return this.http.put<string>(`${environment.baseurl}/user/update`, p,  {
        headers: {
          'Authorization': 'Bearer ' + this.loginService.getToken(),
        }
      });
  
    
    }






  addeProjet(p1:Projet): Observable<string> {


    const p2 = {
      "title": p1.title,
      "type": p1.type,
      "description": p1.description,
      "requiredSkills": p1.requiredSkills,
      "createdDate": p1.createdDate,
      "numberOfMembers":p1.numberOfMembers
    };
    console.log(p2);  
   // alert(p2);
   console.log(p1.requiredSkills);  
    console.log(p1.requiredSkills);  
   alert(p1.requiredSkills[0])
   // p3:projetV1= new projetV1(p1.title, p1.type,p1.description,p1.requiredSkills,p1.createdDate,p1.numberOfMembers);
    const p = {
      "title":  p1.title,
      "type": "Type du projet",
      "description": "Description du projet 1",
      "requiredSkills": p1.requiredSkills,
      "createdDate": "2023-05-23",
      "numberOfMembers": 3
    };
    
    return this.http.post<string>(`${environment.baseurl}/user/projects`, p2,  {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    });
  
  }

//-------------------------------------------


  addeprojectsRequests(d1:any): Observable<string> {


   // alert("addeprojectsRequests     "+"  userId  :  "+ d1.userId +"  idProjet   "+ d1.idProjet  +    "   d1.projectRequestDate   "+ d1.projectRequestDate   +"  d1.projectRequestDate+"  );
     

    const p ={
      "userId": d1.userId,
      "projectRequestDate": d1.projectRequestDate 
  }
    


    return this.http.post<string>(`${environment.baseurl}/projects/`+d1.idProjet +`/projects_requests`, p,  {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    });

  
  }



  getuser() : Observable<any> {
    return this.http.get(`${environment.baseurl}/user/info`, {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    })
  }
  //-----------------------------------------

  private apiUrlUser = 'http://localhost:8085/api/v1/user/save';
  registerUser(newUser: any): Observable<any>  {
    return this.http.post(this.apiUrlUser, newUser);
  }
  //----------------------------------
  /*
  registerUser(newUser: any) {    
    return this.http.post(`${environment.baseurl}/users/users/register`,newUser);
  }

  */
  validerUser(id:any){
    return this.http.put(`${environment.baseurl}/users/users/validerUser/${id}`,{});

  }
  desactiverUser(id:any){
    return this.http.put(`${environment.baseurl}/users/users/desactiveruser/${id}`,{});

  }
  activerUser(id:any){
    return this.http.put(`${environment.baseurl}/users/users/activerUser/${id}`,{});

  }
  sendEmail(email: any){
    return this.http.post(`${environment.baseurl}/users/emails/sendMail/${email}`,{});

  }
 
  modifierImage(image:any,id:any){
    return this.http.put(`${environment.baseurl}/users/users/modifimage/${id}`,image)
  }

  modifierCv(cv:any,id:any){
    return this.http.put(`${environment.baseurl}/users/users/modificv/${id}`,cv)
  }

 modifierPassword(newpassword:any,id:any){
    return this.http.put(`${environment.baseurl}/users/users/updatepassword/${id}?newpassword=${newpassword}`,{})
  }
 

  
}
