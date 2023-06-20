import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CompetenceService } from 'src/app/services/competence.service';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-detail-ingenieur',
  templateUrl: './detail-ingenieur.component.html',
  styleUrls: ['./detail-ingenieur.component.css']
})
export class DetailIngenieurComponent implements OnInit {
  id= this.activeRoute.snapshot.params['id'];
  ingenieur:any
  competence:any
  constructor(private activeRoute: ActivatedRoute,private api: UserService, private apidata:CompetenceService) { }

  ngOnInit(): void {
    this.getOneClient()
    this.getCompetence()
  }
  getOneClient(){
    this.api.getuser().subscribe((res:any)=>{
    this.ingenieur=res
      console.log("ingenieur",this.ingenieur)
    })
  }

  getCompetence(){
    this.apidata.getallcompetences().subscribe((res:any)=>{
    this.competence=res.filter((el:any)=>el.ingenieur.id==this.ingenieur.id)
    this.getOneClient()
      console.log("competences de ce ing ",this.competence)
    })
  }
  
}
