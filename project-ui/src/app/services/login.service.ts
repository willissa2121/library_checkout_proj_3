import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private http: HttpClient
  ) { }

 async registerUser(value: any){
   return  this.http.post('http://localhost:8080/register',value).subscribe(
    (response) => {
      let respJson = JSON.stringify(response);
      let respParseJson = JSON.parse(respJson);
      alert(respParseJson.message[0])
    },
    (error) => {
      alert("Invalid Form Entry");
    }
   )
  }

  login(value:any) {
    return this.http.post("http://localhost:8080/login",value).subscribe(
      (response) =>{
        let respJson = JSON.stringify(response);
        let respParseJson = JSON.parse(respJson);
        alert(respParseJson.message[0])
      },
      (error) => {
        alert("Invalid Credential!");
      }
    )
  }
}
