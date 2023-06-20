import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TacheService } from 'src/app/services/tache.service';
import Swal from 'sweetalert2';


import { ProjetService } from 'src/app/services/projet.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';
import { Projet } from 'src/app/models/Projet';


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  selectedCategory!: number;
  categories = [
    {
      id: 'PFA' ,
      name: 'PFA' 
    },
    {
      id: 'PFE', 
      name: 'PFE'
    },
    {
      id: 'Academic project' ,
      name: 'Academic project' 
    },
    {
      id:  'Project', 
      name: 'Project'
    }

  ];


  tacheForm!: FormGroup;



dropdownList:any = [];
  selectedItems:any = [];
  dropdownSettings:any = {};



  projectDtoProjectType:any=[];
  TypeProjects:any = [];
  dropdownSettingsTypeProject:any={};

  constructor(private api: TacheService,
    private projetService:ProjetService,private US:UserService,
    private formBuilder: FormBuilder,private route:Router) { }

  
  
  
ngOnInit(): void {


  this.TypeProjects = [
    'PFA',
    'PFE',
    'Academic project',
    'Project'
  ];




  this.dropdownList = [
    { item_id: 1, item_text: 'Docker' },
    { item_id: 2, item_text: 'Azure' },
    { item_id: 3, item_text: 'Angular' },
    { item_id: 4, item_text: 'Git' },
    { item_id: 5, item_text: 'MySQL' },
    { item_id: 6, item_text: 'CSS' },
    { item_id: 7, item_text: 'Node.js' },
    { item_id: 8, item_text: 'JavaScript' },
    { item_id: 9, item_text: 'PHP' },
    { item_id: 10, item_text: 'React' },
  ];
  this.projectDtoProjectType=[];
  this.selectedItems = [
   // { item_id: 3, item_text: 'Pune' },
    // { item_id: 4, item_text: 'Navsari' }
  ];
this.dropdownSettingsTypeProject = {
  singleSelection: false,
  idField: 'item_id',
  textField: 'item_text',
  selectAllText: 'Select All',
  unSelectAllText: 'UnSelect All',
  itemsShowLimit: 3,
  allowSearchFilter: true
};


  this.dropdownSettings = {
    singleSelection: false,
    idField: 'item_id',
    textField: 'item_text',
    selectAllText: 'Select All',
    unSelectAllText: 'UnSelect All',
    itemsShowLimit: 3,
    allowSearchFilter: true
  };

    this.initForm();
   
    }
    
    initForm(): void {
    this.tacheForm = this.formBuilder.group({
      title: ['', Validators.required],
    description: ['', Validators.required],
    category: ['', Validators.required],
    
    number: ['', Validators.required],
    end: ['', Validators.required]
    });
    }
    
    

    onSubmit(): void {
      // Récupérer les valeurs du formulaire
      console.log(this.tacheForm.value);
      console.log(this.selectedItems);
      
      //-----------------------problrm ici foreach-
      const itemTexts:string[] = [];

      this.selectedItems.forEach((item: { item_text: string; }) => {
          itemTexts.push(item.item_text); 
      });
      console.log(itemTexts);
      alert("itemTexts :"+ itemTexts);

      //-----------------------
      const user = new User();
      const p1 = new Projet(
              1,                   // projectId
              user,                // user
              this.tacheForm.value.title,    // title  
              this.tacheForm.value.category,               // type
              this.tacheForm.value.description,   // description
              itemTexts ,//  this.selectedItems,        // requiredSkills   
              this.tacheForm.value.end,          // createdDate
              this.tacheForm.value.number,                   // numberOfMembers
              'ACTIVE'           // projectStatus   
      );
//----------------------------------------------------------------
//       const p2 = new projetV1(
//         this.tacheForm.value.title,    // title  
//         this.tacheForm.value.category,               // type
//         this.tacheForm.value.description,   // description

//         this.selectedItems,        // requiredSkills   
//         this.tacheForm.value.end,          // createdDate
//         this.tacheForm.value.number                   // numberOfMembers
       
// );
//---------------------------------------------------------------------

      this.US.addeProjet(p1).subscribe(()=>{        });
      this.route.navigate(['/filterProject']); 
 

    }



    onItemSelect(item: any) {
      console.log(item);  

      this.selectedItems.push({
        item   
      }); 

    }
    onSelectAll(items: any) {
      this.selectedItems=items;
      console.log(items);
    }

    onItemDeSelect(a: any) {
      this.selectedItems=this.selectedItems.filter((item: { item_id: any; })=>item.item_id!=a.item_id);
      console.log(a);
      console.log(this.selectedItems);
    }
    onItemDeSelectAll(items: any) {
      //this.selectedItems=items;
      console.log(items);
    }


}