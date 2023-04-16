import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { DialogCreateComponent } from './dialog-create/dialog-create.component';


@NgModule({
  
  imports: [
    CommonModule,
    ReactiveFormsModule,
    NgMultiSelectDropDownModule,
  ],
 
})
export class DialogCreateModule { }
