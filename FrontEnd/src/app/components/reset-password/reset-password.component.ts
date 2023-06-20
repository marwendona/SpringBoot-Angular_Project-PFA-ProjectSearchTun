import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  resetForm!: FormGroup;
  resetLink=this.activeroute.snapshot.params['resetLink']
    constructor(private formBuilder: FormBuilder,private route:Router, private apiLogin:LoginService,private activeroute:ActivatedRoute) { }
  
    ngOnInit(): void {
      this.resetForm = this.formBuilder.group({
        newPassword: ['', Validators.required] 
    });
    }

    // reset password
  resetPassword(){
    console.log("reset link",this.resetLink)
    console.log("new pass",this.resetForm.value.newPassword)
    this.apiLogin.resetpassword(this.resetLink,this.resetForm.value.newPassword).subscribe((res:any)=>{
      console.log(res)
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'password has been changed.',
        showConfirmButton: false,
        timer: 1500
      })
      console.log(res)
      this.route.navigateByUrl('')
     })
  }

}
