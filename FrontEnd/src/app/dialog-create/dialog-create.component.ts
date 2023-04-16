import { Component ,OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { DialogCreateService } from '../dialog-create.service';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dialog-create',
  templateUrl: './dialog-create.component.html',
  styleUrls: ['./dialog-create.component.scss'],
})
export class DialogCreateComponent implements OnInit{

  data!: any[];

  skills= [
    'Java',
    'Python',
    'JavaScript',
    'C++',
    'Ruby',
    'PHP',
    'HTML',
    'CSS',
    'SQL',
    'Git',
    'React',
    'Angular',
    'Node.js',
    'Express.js',
    'MongoDB',
    'MySQL',
    'PostgreSQL',
    'AWS',
    'Azure',
    'Docker',
    'Kubernetes',
    'Agile development',
    'Test-driven development',
    'Continuous integration/Continuous deployment',
    'Object-oriented programming',
    'Functional programming',
    'Data structures and algorithms',
    'Network security',
    'Web security',
    'Mobile app development',
    'Game development',
    'UI/UX design',
    'Data analysis',
    'Machine learning',
    'Artificial intelligence',
    'Blockchain',
    'Internet of Things',
    'Cloud computing',
    'Big data',
    'DevOps'
    ];

  TypeProjects=[
    'PFA',
    'PFE',
    'Academic project',
    'Project'
  ];



  projectDtoTitle: string ="";
  projectDtoDescription: string ="";
  userDtoPassword: string ="";
  projectDtoProjectType:string ="";
  projectDtoSkills: string[] = [];
  projectDtoNumber:string ="";
  

  CreateForm?: FormGroup;

  dropdownSettings = {
    singleSelection: false,
    idField: 'item_id',
    textField: 'item_text',
    selectAllText: 'Select All',
    unSelectAllText: 'UnSelect All',
    itemsShowLimit: 3,
    allowSearchFilter: true
  };
 

  
  dropdownSettingsTypeProject = {
    singleSelection: true,
    idField: 'item_id',
    textField: 'item_text',
    allowSearchFilter: true
  };
 
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
      "projectDtoSkills": this.projectDtoSkills.join(', '), 
      "projectDtoNumber":this.projectDtoNumber

    };
    this.http.post("http://localhost:8085/api/v1/project/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Project Registered Successfully");
 
    });
  }

  cancel(){
    this.matDialog.closeAll()

  }

}
