import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { TacheService } from 'src/app/services/tache.service';
import { ProjetService } from 'src/app/services/projet.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  totaltodo: any;
 todo:any;
 totaldone:any;
 done:any;
 inprogress:any;
 totalinprogress:any;
  listing: any;
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)
  p: number = 1;
  listingenieurs:any
  listTaskbyClient: any;
  listTaskbyIng: any;
  tasks: any;
  totaltasks: any;

 
  constructor(private api: TacheService,private apiIng:ProjetService) { }

  ngOnInit(): void {
    
    this.getAllProjects()
    this.getTaskesInprogress()
    this.getTaskesTodo()
    this.getTaskesdone()
   
    
  }
  
  getTaskesTodo(){
    this.api.getalltasks().subscribe((res:any)=>{
      this.todo=res.filter((el:any)=>el.status=="todo" && el.ing!=null && el.confirmationAdmin=="confirmé")
      console.log("list of todo tasks",this.todo)
      this.totaltodo=this.todo.length;
    console.log("nombre de task todo", this.totaltodo)
    })
  
  }
  getTaskesTodobyIng(e:any){
    this.api.getalltasks().subscribe((res:any)=>{
      this.todo=res.filter((el:any)=>el.status=="todo" && el.ing!=null && el.ing.id==e.target.value)
      console.log("list of todo tasks",this.todo)
      this.totaltodo=this.todo.length;
    console.log("nombre de task todo", this.totaltodo)
    })
  
  }
  getTaskesInprogress(){
    this.api.getalltasks().subscribe((res:any)=>{
      this.inprogress=res.filter((el:any)=>el.status=="inprogress"  )
      console.log("list of inprogress tasks",this.inprogress)
      this.totalinprogress=this.inprogress.length;
    console.log("nombre de task inprogress", this.totalinprogress)
    })
  
  }
  getTaskesInprogresbyIng(e:any){
    console.log("fff",e.target.value )
    this.api.getalltasks().subscribe((res:any)=>{
      this.inprogress=res.filter((el:any)=>el.status=="inprogress"  && el.ing.id==e.target.value )
      console.log("list of inprogress tasks",this.inprogress)
      this.totalinprogress=this.inprogress.length;
    console.log("nombre de task inprogress", this.totalinprogress)
    })
  
  }

  getTaskesdone(){
    this.api.getalltasks().subscribe((res:any)=>{
      this.done=res.filter((el:any)=>el.status=="done" )
      console.log("list of done tasks",this.done)
      this.totaldone=this.done.length;
    console.log("nombre de task done", this.totaldone)
    })
  
  }
  
  getTaskesdonebyIng(e:any){
    this.api.getalltasks().subscribe((res:any)=>{
      this.done=res.filter((el:any)=>el.status=="done"  && el.ing.id==e.target.value )
      console.log("list of done tasks",this.done)
      this.totaldone=this.done.length;
    console.log("nombre de task done", this.totaldone)
    })
  
  }
  
  getAllProjects(){
    this.apiIng.getAllProjects().subscribe((res:any)=>{
      this.listing=res
      this.totaltasks=this.listing.length;
    console.log("liste Projects", this.listing)
    })
  }
  
  isIngnieur(){
    return this.userconnect.role=="Ingenieur"?true: false;
  }
  
  
 
  

 

 
}
