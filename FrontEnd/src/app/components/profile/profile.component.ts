import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { CompetenceService } from 'src/app/services/competence.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {



  

  

  user!:User;
 
  constructor(private formBuilder: FormBuilder,private route:Router, 
    private api:CompetenceService,private US :UserService,private apiIng:UserService) { }

  ngOnInit(): void {


    this.US.getuser().subscribe((res) => {
      this.user = res;
      console.log(this.user);

    });

  
    
  }




}