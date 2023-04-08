import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogCreateComponent } from '../dialog-create/dialog-create.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

constructor(private matDialog:MatDialog){}

openDialog(){

   this.matDialog.open(DialogCreateComponent,{
    width:'700px',
    height:'600px'

})
}
}