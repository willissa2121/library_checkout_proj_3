import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  // public pageRefreshHelper: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  dataSource: any;
  displayedColumns: any =[];
  allBooks: Object = []

 columnNames = [
   {
  id: 'Book',
  value: 'Book.',

},   {
  id: 'ISBN',
  value: 'ISBN.',

},
{
  id: 'Edition',
  value: 'Edition.',

},
{
  id: 'Expected Return Date',
  value: 'Expected Return Date.',

}
, {
  id: 'Author',
  value: 'Author',
},
  {
    id: 'Available',
    value: 'Availbale',
  },
  {
    id: 'Edit',
    value: 'Edit',
  },
  {
    id: 'Delete',
    value: 'Delete'
  }
];

  constructor(
    private bookService: BookService
    
  ) { 
  }

  ngOnInit(): void {
    this.displayedColumns = this.columnNames.map(x => x.id);
     this.bookService.getAllBooks().subscribe(res =>{
       this.allBooks = res;
       this.dataSource = this.allBooks;
     })
  }

  getAllBooks() {
    return this.bookService.getAllBooks().subscribe(res =>{
      this.allBooks = res
    })
  }

  deleteBook(isbn:any) {
    console.log(JSON.stringify(isbn))
    return this.bookService.deleteBook(isbn).subscribe(res => {
      console.log("got deleted");
      this.ngOnInit()
    })
  }

}
