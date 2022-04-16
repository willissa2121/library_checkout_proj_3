import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BookService } from '../services/book.service';
import { DialogData } from '../update-dialog/update-dialog.component';

@Component({
  selector: 'app-add-dialog',
  templateUrl: './add-dialog.component.html',
  styleUrls: ['./add-dialog.component.css']
})
export class AddDialogComponent implements OnInit {

  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<AddDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData, private bookService: BookService) { }

  ngOnInit(): void {
  }

  formdata = new FormGroup({
    name: new FormControl(this.data.book.name),
    isbn: new FormControl(this.data.book.isbn),
    edition: new FormControl(this.data.book.edition),
    expectedReturnDate: new FormControl(this.data.book.expectedReturnDate),
    author: new FormControl(this.data.book.author.fullName),
    availability: new FormControl(this.data.book.availability),
});
}
