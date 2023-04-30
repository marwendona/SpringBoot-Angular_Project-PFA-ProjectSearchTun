
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClientService } from 'src/services/client.service';


import Swal from 'sweetalert2';

@Component({
  selector: 'app-profile-detail',
  templateUrl: './profile-detail.component.html',
  styleUrls: ['./profile-detail.component.css']
})
export class ProfileDetailComponent implements OnInit{

  userconnect=JSON.parse(localStorage.getItem("userconnect")!);
  updateProfileForm!: FormGroup;
  updatePasswordForm!: FormGroup;
  client: any;
  fileToUpload: Array<File>=[];
  constructor(private formBuilder: FormBuilder,private route:Router,private apiClient:ClientService) { }

  ngOnInit(): void {
    this.getClient()
    this.updateProfileForm = this.formBuilder.group({
      id: ['', Validators.required],
      email: ['', Validators.required],
      tel: ['', Validators.required],
      adresse: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      image: ['', Validators.required],
    
  });
  this.updatePasswordForm = this.formBuilder.group({
    newpassword: ['', Validators.required],
  });
  }

  updateProfile(){
    this.apiClient.updateclient(this.userconnect.id,this.updateProfileForm.value).subscribe((res:any)=>{
      console.log(res)
      this.client=res
      localStorage.setItem("userconnect",JSON.stringify(res))
     
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title:  'Your profile has been updated.',
        showConfirmButton: false,
        timer: 1500
      })
        window.location.href="http://localhost:4200/home/profileClient"
    })
  }
    
  getClient(){
      this.apiClient.getclient(this.userconnect.id).subscribe((res:any)=>{
        this.client=res
          console.log("client ",this.client)
          this.updateProfileForm.patchValue({
            email: this.client.email,
            tel:this.client.tel,
            adresse:this.client.adresse,
            firstName:this.client.firstName,
            lastName:this.client.lastName
          })
        })
  }

  handleFileInput(files:any){
    this.fileToUpload=<Array<File>>files.target.files;
    console.log(this.fileToUpload);
    
  }

  modifierImage(){
      let formdata=new FormData();
      formdata.append("file",this.fileToUpload[0]);
      this.apiClient.modifierImage(formdata,this.userconnect.id).subscribe((res:any)=>{
        this.client=res
        localStorage.setItem("userconnect",JSON.stringify(res))
        window.location.href="http://localhost:4200/home/profileClient"
          console.log("client ",this.client)
        })
  }

  modifierpassword(){
    this.apiClient.modifierPassword(this.updatePasswordForm.value.newpassword,this.userconnect.id).subscribe((res:any)=>{
      console.log(res)
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title:  'Your password has been updated.',
        showConfirmButton: false,
        timer: 1500
      })
    })
    this.updatePasswordForm.reset()
  }
  
}
