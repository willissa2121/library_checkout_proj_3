import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { SnackbarService } from '../snackbar.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public isUserLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  

  constructor(
    private http: HttpClient,
    private router: Router,
    private snackBar: SnackbarService
  ) { }

 async registerUser(value: any){
   return  this.http.post('http://localhost:8080/register',value).subscribe(
    (response) => {
      let respJson = JSON.stringify(response);
      let respParseJson = JSON.parse(respJson);
      this.snackBar.openSnackBarGood(respParseJson.message[0], 'Welcome')
    },
    (error) => {
      let errorObj = error.error
       this.snackBar.openSnackBarBad(errorObj.message, 'Try Again')
    }
   )
  }

  login(value:any) {
    return this.http.post("http://localhost:8080/login",value).subscribe(
      (response) =>{
        let respJson = JSON.stringify(response);
        let respParseJson = JSON.parse(respJson);
        const session = localStorage.setItem("userName", value.userName);
        this.isUserLoggedIn.next(true);
        this.router.navigate(['/catalogue']);
        this.snackBar.openSnackBarGood(respParseJson.message[0], 'Welcome!')
      },
      (error) => {
        let errorObj = error.error
        this.snackBar.openSnackBarBad('Invalid Credential', 'Try Again')
      }
    )
  }
}
