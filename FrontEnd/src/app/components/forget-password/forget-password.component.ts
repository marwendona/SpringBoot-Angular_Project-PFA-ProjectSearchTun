import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  forgetForm!: FormGroup;
  constructor(private formBuilder: FormBuilder,private route:Router, private apiLogin:LoginService,private activeroute:ActivatedRoute) { }
  ngOnInit(): void {
    this.forgetForm = this.formBuilder.group({
      email: ['', Validators.required]  
  });
  }
  
  //forget Password
  forgetPassword(){
    this.apiLogin.forgetpassword(this.forgetForm.value.email).subscribe((res:any)=>{
      console.log(res)
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Email has been send ',
        showConfirmButton: false,
        timer: 1500
      })
    console.log(this.forgetForm.value)
    this.route.navigateByUrl('/confirmEmail')
   })
  }
}
