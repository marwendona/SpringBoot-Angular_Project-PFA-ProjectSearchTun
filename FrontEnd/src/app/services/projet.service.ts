import { HttpClient } from '@angular/common/http';
import { EnvironmentInjector, Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Projet } from '../models/Projet';
import { Observable, tap } from 'rxjs';
import { LoginService } from './login.service';


@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  // TabProjects: Projet[]= [];
  constructor(private http: HttpClient, private loginService: LoginService) { }


  //----------------------------------------------------------------

  getAllProjet(): Observable<any> {
    return this.http.get(`${environment.baseurl}/projects`, {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    })
  }


  getProjectByProjectId(id: number): Observable<any> {
    //alert(id)
    return this.http.get(`${environment.baseurl}/projects/` + id, {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    })
  }

  getUserProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`${environment.baseurl}/user/projects`, {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    })
  }

  getUserRequests(): Observable<ProjectRequest[]> {
    return this.http.get<ProjectRequest[]>(`${environment.baseurl}/user/projects_requests`, {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    })
  }

  getProjectRequests(projectId: number): Observable<ProjectRequest[]> {
    return this.http.get<ProjectRequest[]>(`${environment.baseurl}/projects/${projectId}/projects_requests`, {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    })
  }

  setProjectRequestStatus(requestId: number, status: ProjectRequestStatus) {
    return this.http.put(`${environment.baseurl}/projects_requests/${requestId}/status`, {
      status: status
    }, {
      headers: {
        'Authorization': 'Bearer ' + this.loginService.getToken(),
      }
    })
  }

  getAllProjects() {
    return this.http.get(`${environment.baseurl}/users/projects/all`);
  }

  deleteproject(id: any) {
    return this.http.delete(`${environment.baseurl}/users/projects/delete/${id}`);


  }
  getproject(id: any) {
    return this.http.get(`${environment.baseurl}/users/projects/getone/${id}`);
  }
  createproject(project: any, id: any) {
    return this.http.post(`${environment.baseurl}/users/projects/save/${id}`, project);

  }
  //--------------------------------- 

}

export interface Project {
  projectId: number,
  title: string,
  type: string,
  description: string,
  requiredSkills: string[]
  createdDate: Date,
  numberOfMembers: number,
  projectStatus: ProjectStatus
}

enum ProjectStatus {
  ACTIVE = 'ACTIVE',
  ENDED = 'ENDED',
  PROGRESSING = 'PROGRESSING'
}

export interface ProjectRequest {
  projectRequestId: number,
  userId: number,
  projectRequestDate: Date,
  status: ProjectRequestStatus
}

export enum ProjectRequestStatus {
  ACCEPTED = 'ACCEPTED',
  REJECTED = 'REJECTED',
  PENDING = 'PENDING'
}