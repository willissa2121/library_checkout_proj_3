import { ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BookService } from '../services/book.service';
import { SnackbarService } from '../snackbar.service';
import { DialogData } from '../update-dialog/update-dialog.component';



@Component({
  selector: 'app-add-dialog',
  templateUrl: './add-dialog.component.html',
  styleUrls: ['./add-dialog.component.css']
})
export class AddDialogComponent implements OnInit {

  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<AddDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
     private bookService: BookService, private router: Router,
     private changeDetector: ChangeDetectorRef, private snackbar: SnackbarService) { }

  ngOnInit(): void {
    this.formdata
  }

  formdata = new FormGroup({
    name: new FormControl(''),
    isbn: new FormControl(''),
    edition: new FormControl(''),
    expectedReturnDate: new FormControl(''),
    authorEmail: new FormControl(''),
    availability: new FormControl(''),
    fullName: new FormControl(''),
    email: new FormControl(''),
});

addBook(data: any){
    this.bookService.addBook(data).subscribe(
    async resp => {
      this.dialogRef.close();
       this.snackbar.openSnackBarGood('Book Added', 'Hurray!')
      window.setTimeout(function(){location.reload()},1500)
    }
  );
}
}
