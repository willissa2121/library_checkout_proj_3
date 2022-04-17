import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {


  constructor(private fb: FormBuilder, private loginService: LoginService) { 
  }

  form = this.fb.group({
    email: [''],
    userName: [''],
    password: [''],
  })

  loginForm =this.fb.group({
    userName: [''],
    password: ['']
  })

  ngOnInit(): void {
    this.form
  }

  registerUser(){

    this.loginService.registerUser(this.form.value)
    this.form.reset();
  }

  login(){
    this.loginService.login(this.loginForm.value)
  }



}
