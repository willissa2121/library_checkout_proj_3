import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn:any = false;
  userName: any 

  constructor(private loginService: LoginService) {

    this.loginService.isUserLoggedIn.subscribe(resp =>{
      console.log("login service")
      this.isLoggedIn = resp;
      this.userName = localStorage.getItem('userName');
    })

   }

  ngOnInit(): void {
  }

  onLogout(){
   this.loginService.isUserLoggedIn.subscribe(resp =>{
     localStorage.clear;
   })
  }

}
