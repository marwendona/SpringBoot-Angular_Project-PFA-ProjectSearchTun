import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { DialogCreateService } from '../dialog-create.service';


@Component({
  selector: 'app-dialog-create',
  templateUrl: './dialog-create.component.html',
  styleUrls: ['./dialog-create.component.scss']
})
export class DialogCreateComponent {

  data!: any[];

  projectDtoTitle: string ="";
  projectDtoDescription: string ="";
  userDtoPassword: string ="";
  projectDtoProjectType:string ="";
  projectDtoSkills:string ="";
  projectDtoNumber:string ="";

  CreateForm?: FormGroup;
 
 
  constructor(private http: HttpClient , private matDialog:MatDialog,private dialogCreateService:DialogCreateService ){}
  

  ngOnInit() {
    this.dialogCreateService.getData().subscribe(data => {
      this.data = data;
    });
  }

  save()
  {
  
    let bodyData = {
      "projectDtoTitle" : this.projectDtoTitle,
      "projectDtoDescription" : this.projectDtoDescription,
      "userDtoPassword" : this.userDtoPassword,
      "projectDtoProjectType":this.projectDtoProjectType,
      "projectDtoSkills":this.projectDtoSkills,
      "projectDtoNumber":this.projectDtoNumber

    };
    this.http.post("http://localhost:8085/api/v1/project/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("User Registered Successfully");
 
    });
  }

  cancel(){
    this.matDialog.closeAll()

  }

}
