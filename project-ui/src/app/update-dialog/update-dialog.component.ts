import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { BookService } from '../services/book.service';


export interface DialogData {
  book: any;
}

@Component({
  selector: 'app-update-dialog',
  templateUrl: './update-dialog.component.html',
  styleUrls: ['./update-dialog.component.css']
})
export class UpdateDialogComponent implements OnInit {

  name: any
  isbn: any
  edition: any
  expectedReturnDate: any
  author: any
  availability: any
  isUpdated: any
  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<UpdateDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData, private bookService: BookService, private router: Router) { 
    }
    
  ngOnInit(): void {
    this.formdata

  }
    formdata = new FormGroup({
      name: new FormControl(this.data.book.name),
      isbn: new FormControl(this.data.book.isbn),
      edition: new FormControl(this.data.book.edition),
      expectedReturnDate: new FormControl(this.data.book.expectedReturnDate),
      author: new FormControl(this.data.book.author.fullName),
      availability: new FormControl(this.data.book.availability),
 });

  updateBook(data:any){
    return this.bookService.updateBook(data.isbn, data).subscribe(resp =>{
      this.dialogRef.close();
      window.top?.location.reload()
    })

}
}
