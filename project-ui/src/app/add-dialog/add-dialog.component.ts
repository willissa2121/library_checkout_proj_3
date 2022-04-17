import { ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BookService } from '../services/book.service';
import { DialogData } from '../update-dialog/update-dialog.component';

// export class Book {
//   name: string;
//   authorEmail: string;
//   edition: string;
//   availability: string;
//   expectedReturnDate: Date;
//   isbn: string;
//   author: Author;


// }

// export class Author {
//   fullName: String;
//   email: String;
// }

@Component({
  selector: 'app-add-dialog',
  templateUrl: './add-dialog.component.html',
  styleUrls: ['./add-dialog.component.css']
})
export class AddDialogComponent implements OnInit {

  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<AddDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
     private bookService: BookService, private router: Router,
     private changeDetector: ChangeDetectorRef) { }

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
  
  console.log("add dialog---->",data)
  this.bookService.addBook(data).subscribe(
    resp => {
      console.log("book added")
      this.dialogRef.close
      this.changeDetector.detectChanges
      this.router.navigate(['/catalogue'])

    }
  );
}
}
