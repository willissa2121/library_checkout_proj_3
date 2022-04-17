import { Injectable } from '@angular/core';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {

  constructor(private snackBar: MatSnackBar) { }

  openSnackBarGood(message: string, action: string) {
    this.snackBar.open(message, action, {
       duration: 2000,
       verticalPosition: 'top',
       panelClass: ['green-snackbar']
    });
  }

  openSnackBarBad(message: string, action: string) {
    this.snackBar.open(message, action, {
       duration: 2000,
       verticalPosition: 'top',
       panelClass: ['red-snackbar']
    });
  }
}
