import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-updat-profile',
  templateUrl: './updat-profile.component.html',
  styleUrls: ['./updat-profile.component.css']
})
export class UpdatProfileComponent implements OnInit {

  RegisterForm!: FormGroup;
  fileToUpload: Array<File>=[];
  submitted = false;

  constructor(private formBuilder: FormBuilder,private route:Router, private userService:UserService) { }

  ngOnInit(): void {
    this.RegisterForm = this.formBuilder.group({

      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(8)
        ]
      ],

      institute: ['', Validators.required],
      profession: ['', Validators.required],


      linkedin: ['', Validators.required],
      github: ['', Validators.required],
      


      acceptTerms: [false, Validators.requiredTrue]
  

  });
  }
  get f(){
    return this.RegisterForm.controls;
  }
  handleFileInput(files:any){
    this.fileToUpload=<Array<File>>files.target.files;
    console.log(this.fileToUpload);
    
      }
      
  onSubmit() {

    
    console.log(this.RegisterForm.value);

    this.submitted = true;
    if (this.RegisterForm.invalid) {
      return;
    }

    const newUser : User={

      userId:0,
      role:"ADMIN",
      userFirstName:this.RegisterForm.value.firstName,
      userLastName:this.RegisterForm.value.lastName,
      email:this.RegisterForm.value.email,
      password:this.RegisterForm.value.password,
      institute:this.RegisterForm.value.institute,
      profession:this.RegisterForm.value.profession,
      photo:"f1",
      cv:"cv1",
      linkedin:this.RegisterForm.value.linkedin,
      github:this.RegisterForm.value.githu
    };

    console.log(newUser);

    

this.userService.updateUser(newUser).subscribe(response => {
      console.log(response);
      this.route.navigate(['/home/profileIng']);
    });  
   // this.route.navigate(['/home/profileIng']);






    let formdata=new FormData();
    formdata.append("username",this.RegisterForm.value.username);
    formdata.append("password",this.RegisterForm.value.password);
    formdata.append("userFirstName",this.RegisterForm.value.firstName);
    formdata.append("userLastName",this.RegisterForm.value.lastName);
    formdata.append("email",this.RegisterForm.value.email);
    formdata.append("telephone",this.RegisterForm.value.telephone);
    formdata.append("institute",this.RegisterForm.value.institute);
    formdata.append("profession",this.RegisterForm.value.profession);
    formdata.append("linkedin",this.RegisterForm.value.linkedin);
    formdata.append("github",this.RegisterForm.value.github);
    formdata.append("photo",this.fileToUpload[0]);
    formdata.append("cv",this.fileToUpload[1]);
  
 /* 
this.api.registerUser(formdata).subscribe((res:any)=>{
  console.log('reponse',res)
  // Swal.fire(
  //   'success account created !',
  //   'wait an email from admin to validate your account'
  // )
  Swal.fire({
    title: '<strong>Your<u> account is created</u></strong>',
    icon: 'info',
    html:
      'An email will be sent to you from<b> administration</b>, ' +
      '<a>when your account will be validated </a> ',
    showCloseButton: true,
    showCancelButton: true,
    focusConfirm: false,
    confirmButtonText:
      '<i class="fa fa-thumbs-up"></i> Ok!',
    confirmButtonAriaLabel: 'Thumbs up, great!'
    
  })
  this.route.navigateByUrl('')
})*/
}
}

