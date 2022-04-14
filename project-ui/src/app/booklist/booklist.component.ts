import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {

  
  dataSource: any;
  displayedColumns: any =[];
  allBooks: Object = []

 columnNames = [{
  id: 'Book',
  value: 'Book.',

}, {
  id: 'Author',
  value: 'Author',
},
  {
    id: 'Available',
    value: 'Availbale',
  }];

  constructor(
    private bookService: BookService
  ) { }

  ngOnInit(): void {
    this.displayedColumns = this.columnNames.map(x => x.id);
     this.bookService.getAllBooks().subscribe(res =>{
       this.allBooks = res;
       this.dataSource = this.allBooks;
       console.log('this is the datasource--->', this.dataSource)
     })
  }

  getAllBooks() {
    return this.bookService.getAllBooks().subscribe(res =>{
      this.allBooks = res
    })
  }

}
