import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {


  constructor(
    private http: HttpClient
  ) { }

  getAllBooks(){
   return  this.http.get('http://localhost:8080/books')
  }

  deleteBook(isbn:any) {
    return this.http.delete(`http://localhost:8080/books/isbn/${isbn}`);
  }
}
