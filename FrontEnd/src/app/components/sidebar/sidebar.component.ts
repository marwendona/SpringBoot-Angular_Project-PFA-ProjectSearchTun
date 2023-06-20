import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)
  constructor() { }

  ngOnInit(): void {
  }

 
  isIngnieur(){
    return this.userconnect.role=="Ingenieur"?true: false;
  }
 

}
