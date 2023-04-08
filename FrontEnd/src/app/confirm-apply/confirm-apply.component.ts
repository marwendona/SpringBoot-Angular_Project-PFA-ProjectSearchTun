import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
@Component({
  selector: 'app-confirm-apply',
  templateUrl: './confirm-apply.component.html',
  styleUrls: ['./confirm-apply.component.css']
})
export class ConfirmApplyComponent {

  
  constructor(public dialogref:MatDialogRef<ConfirmApplyComponent>){} //forcage de type 
  public title='Are u sure ?';
  public content='Do you want to apply for it ';
  public cancelButton='cancel';
  public confirmButton="confirm";

}
