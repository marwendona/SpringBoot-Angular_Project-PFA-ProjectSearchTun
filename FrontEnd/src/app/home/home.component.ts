import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Filter } from 'src/modal/filter';

import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


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

  /*query: string = '';
  results: any[] = [];
  form!: FormGroup;
  //constructor(private filterService: FilterService) { }
  onFilter(){};
  /*onFilter() {
    this.filterService.filter(this.query).subscribe(results => {
      this.results = results;
    });
  }*/


  categories: string[] = ['PFA', 'PFE', 'Academic Project'];
  sizes: string[] = ['This week', 'This month', 'This year'];
  colors: string[] = [
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


  getFilters(): Filter {
    return {
      categories: this.categories,
      sizes: this.sizes,
      colors: this.colors,
      priceRange: this.priceRange
    };
  }
}
