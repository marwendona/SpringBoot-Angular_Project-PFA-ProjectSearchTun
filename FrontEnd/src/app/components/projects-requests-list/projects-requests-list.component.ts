import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Project, ProjectRequest, ProjectRequestStatus, ProjetService } from 'src/app/services/projet.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-projects-requests-list',
  templateUrl: './projects-requests-list.component.html',
  styleUrls: ['./projects-requests-list.component.css']
})
export class ProjectsRequestsListComponent implements OnInit {
  listProjects: Project[] = [];
  projectRequests: any[]= [];
  selectedProjectId!: number;
  userconnect=JSON.parse(localStorage.getItem("userconnect")!);
  p: number = 1;
  
  constructor(private api:ProjetService) { }

  ngOnInit(): void {
    this.api.getUserRequests().subscribe(projectRequests => {
      this.projectRequests = projectRequests;

      console.log( this.projectRequests )
     // alert( this.projectRequests[2].project.description)
    });
    
    // const myModal = document.getElementById('myModal')
    // const myInput = document.getElementById('myInput')

    // myModal!.addEventListener('shown.bs.modal', () => {
    //   myInput!.focus()
    // })
    
    // new window.bootstrap.Modal(
    //   document.getElementById('myModal')
    // );
  }

  
}
