import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Projet } from 'src/app/models/Projet';
import { User } from 'src/app/models/User';
import { Project, ProjectRequest, ProjectRequestStatus, ProjetService } from 'src/app/services/projet.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-liste-fiche-ing',
  templateUrl: './liste-fiche-ing.component.html',
  styleUrls: ['./liste-fiche-ing.component.css']
})
export class ListeFicheIngComponent implements OnInit {

//-------------------------------------------------add projet ----------------------------------------------------------------




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








//------------------------------------------------- ----------------------------------------------------------------






  listProjects: Project[] = [];
  projectRequests: ProjectRequest[]= [];
  selectedProjectId!: number;
  userconnect=JSON.parse(localStorage.getItem("userconnect")!);
  p: number = 1;
  
  constructor(private api:ProjetService,
    private projetService:ProjetService,private US:UserService,
    private formBuilder: FormBuilder,private route:Router) { }


  ngOnInit(): void {

//-------------------------------------------------add projet ----------------------------------------------------------------



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
 







//--------------------------------------------------------------------------------------------------------


    this.api.getUserProjects().subscribe(projects => {
      this.listProjects = projects;
    });
    
    // const myModal = document.getElementById('myModal')
    // const myInput = document.getElementById('myInput')

    // myModal!.addEventListener('shown.bs.modal', () => {
    //   myInput!.focus()
    // })
    
    // new window.bootstrap.Modal(
    //   document.getElementById('myModal')
    // );
  }



//--------------------------------------------------------------------------------------------------------------------------------




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




//--------------------------------------------------------------------------------------------------------------------------------

















  selectProject(projectId: number) {
    this.selectedProjectId = projectId;
    this.api.getProjectRequests(projectId).subscribe(projectRequests => {
      this.projectRequests = projectRequests;
    });
  }

  accept(requestId: number) {
    this.api.setProjectRequestStatus(requestId, ProjectRequestStatus.ACCEPTED)
      .subscribe(() => this.selectProject(this.selectedProjectId)) 
  }

  reject(requestId: number) {
    this.api.setProjectRequestStatus(requestId, ProjectRequestStatus.REJECTED)
      .subscribe(() => this.selectProject(this.selectedProjectId)) 
  }

  delete(id:any){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) 
      {
        this.api.deleteproject(id).subscribe((res:any)=>{
  console.log(res)
    this.ngOnInit()
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
      })
      }
    })
  
  }
  
  isIngnieur(){
    return this.userconnect.role=="Ingenieur"?true: false;
  }
  
}
