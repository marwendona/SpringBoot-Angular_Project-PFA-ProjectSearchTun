import { Component, OnInit } from '@angular/core';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { FormGroup } from '@angular/forms';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
import { ProjetService } from '../services/projet.service';
import { Projet } from '../models/Projet';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ModelViewProjetComponent } from '../components/model-view-projet/model-view-projet.component';
import { UserService } from '../services/user.service';
import { User } from '../models/User';

//import { Filter } from 'src/modal/filter';
@Component({
  selector: 'app-filter-project',
  templateUrl: './filter-project.component.html',
  styleUrls: ['./filter-project.component.css']
})
export class FilterProjectComponent implements OnInit {


  projets!: Projet[];
  projetModal!: Projet;
  user!:User;

  CreateForm?: FormGroup;

  constructor(private PS: ProjetService, private dialog:MatDialog,private route:Router, private US :UserService
    ) { }

  ngOnInit() {
    this.PS.getAllProjet().subscribe((res) => {
        this.projets = res;
     
      });


  
  }


  Open(idProjet:number):void{

    //chercher l'evt by id

  
  const dialogConfig = new MatDialogConfig();


    dialogConfig.data = idProjet;
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    const dialoRef=this.dialog.open(ModelViewProjetComponent,dialogConfig);
 

  }

  



  dropdownSettings = {
    singleSelection: false,
    idField: 'item_id',
    textField: 'item_text',
    selectAllText: 'Select All',
    unSelectAllText: 'UnSelect All',
    itemsShowLimit: 3,
    allowSearchFilter: true
  };



  projectDtoSkills: string[] = [];
  categories: string[] = ['PFA', 'PFE', 'Academic Project'];
  sizes: string[] = ['This week', 'This month', 'This year'];
  skills: string[] = [
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
  priceRange: number[] = [10, 50];


  /*getFilters(): Filter {
    return {
      categories: this.categories,
      sizes: this.sizes,
      colors: this.colors,
      priceRange: this.priceRange
    };
  }*/
}



