import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn:any = false;
  userName: any 

  constructor(private loginService: LoginService, private changeDetector: ChangeDetectorRef) {

    this.loginService.isUserLoggedIn.subscribe(resp =>{
      console.log("login service")
      this.userName = localStorage.getItem('userName');
      if( this.userName != null) {
        resp = true;
        this.isLoggedIn = resp;
      }
    })

   }

  ngOnInit(): void {
  }

  onLogout(){
    localStorage.clear();
    this.isLoggedIn = true;
    this.changeDetector.detectChanges()
    //this.ngOnInit();
  //  this.loginService.isUserLoggedIn.subscribe(resp =>{
  //    localStorage.clear();
  //    this.isLoggedIn = true;
  //    this.changeDetector.detectChanges();

  //    this.ngOnInit();
  //  })
  }

}
