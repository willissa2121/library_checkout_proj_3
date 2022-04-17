import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {


  constructor(
    private http: HttpClient
  ) { }

  getAllBooks(): Observable<any[]>{
   return  this.http.get<any[]>('http://localhost:8080/books')
  }

  deleteBook(isbn:any) {
    return this.http.delete(`http://localhost:8080/books/isbn/${isbn}`);
  }

  updateBook(isbn:any, book:any) {
    return this.http.put(`http://localhost:8080/books/isbn/${isbn}`,book);
  }

  addBook(book: any){
    return this.http.post('http://localhost:8080/books/addBook',book);
  }

  checkoutBook(isbn: any, book: any){
    return this.http.put(`http://localhost:8080/books/isbn/${isbn}/checkout`,book)
  }
}
