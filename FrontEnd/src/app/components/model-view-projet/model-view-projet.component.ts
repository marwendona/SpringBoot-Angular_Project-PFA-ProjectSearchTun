import { Component, Inject } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Projet } from 'src/app/models/Projet';
import { User } from 'src/app/models/User';
import { ProjetService } from 'src/app/services/projet.service';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-model-view-projet',
  templateUrl: './model-view-projet.component.html',
  styleUrls: ['./model-view-projet.component.css']
})
export class ModelViewProjetComponent {
  

  form!: FormGroup;
  idProjet!:any;
  a!:string;
  p!:Projet;
  user!:User;
  

    constructor(private PS: ProjetService,
        private fb: FormBuilder,private US :UserService,
        private dialogRef: MatDialogRef<ModelViewProjetComponent>,
      @Inject(MAT_DIALOG_DATA) data:any) {
      
    
        this.idProjet = data;

        console.log(this.idProjet);
       // alert("data modal : "+ this.idProjet);

        

    }


    demande():void{//this.idProjet
      this.US.getuser().subscribe((res) => {
        this.user = res;
        // console.log( this.user );
        // alert( " this.user.id "+this.user.userId );

        const d1={
           "idProjet":this.idProjet,
          "userId": this.user.userId ,
          "projectRequestDate": new Date()
        }
       // alert("userId  :  "+ d1.userId +"  idProjet   "+ d1.idProjet  +    "d1.projectRequestDate"+ d1.projectRequestDate   +"  d1.projectRequestDate+"  );
     

       this.US.addeprojectsRequests(d1).subscribe((res) => {});
      });
     // alert("demande");

    }
   
    ngOnInit() {
      
     
  
    }

    save() {
    
        this.dialogRef.close();
       // this.description=this.form.value
    }

    close() {
        this.dialogRef.close();
    }


}
