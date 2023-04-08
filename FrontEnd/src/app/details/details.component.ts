import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmApplyComponent } from '../confirm-apply/confirm-apply.component';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {

  constructor( private dialog:MatDialog){}   //MemberService : service


  apply():void{
    
    const dialogRef = this.dialog.open(ConfirmApplyComponent, {
     
    });
}}
