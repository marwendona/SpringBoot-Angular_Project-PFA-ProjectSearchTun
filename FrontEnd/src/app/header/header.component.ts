import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogCreateComponent } from '../dialog-create/dialog-create.component';
import { SearchServiceService } from 'src/services/search-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

constructor(private matDialog:MatDialog, private searchService: SearchServiceService){}

openDialog(){

   this.matDialog.open(DialogCreateComponent,{
    width:'700px',
    height:'600px'

})
}


query: string = '';
results: any[] = [];




onSearch() {
  this.searchService.search(this.query).subscribe(results => {
    this.results = results;
  });
}

}