import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BehaviorSubject, elementAt } from 'rxjs';
import { AddDialogComponent } from '../add-dialog/add-dialog.component';
import { BookService } from '../services/book.service';
import { UpdateDialogComponent } from '../update-dialog/update-dialog.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  dataSource: any;
  displayedColumns: any =[];
  allBooks: Object = []
  isEdit :any = false;
  

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
    value: 'Available',
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
    private bookService: BookService,  private changeDetectorRefs: ChangeDetectorRef, public dialog: MatDialog
    
  ) { 
  }

  ngOnInit(): void {
    this.displayedColumns = this.columnNames.map(x => x.id);
     this.bookService.getAllBooks().subscribe(res =>{
       this.allBooks = res;
       this.dataSource = this.allBooks;
     })
  }

  openDialog(book: any): void {
    const dialogRef = this.dialog.open(UpdateDialogComponent, {
      width: '450px',
      data: {book},
    });

    console.log("data passed to dialog---->", dialogRef)
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  
  openAddDialog(): void {
    const dialogRef = this.dialog.open(AddDialogComponent, {
      width: '450px',
    });

    console.log("data passed to dialog---->", dialogRef)
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }


  getAllBooks() {
    return this.bookService.getAllBooks().subscribe(res =>{
      this.allBooks = res
    })
  }

  deleteBook(isbn:any) {
    console.log(JSON.stringify(isbn))
    return this.bookService.deleteBook(isbn).subscribe(res => {
      this.ngOnInit();
    })
  }

  editEnable() {
    this.isEdit = true;
  }


  updateBook(isbn:any, book: any){
    return this.bookService.updateBook(isbn, book).subscribe(resp =>{
      this.isEdit = false;
      this.allBooks = resp;
      this.ngOnInit();
    })
  }

}
