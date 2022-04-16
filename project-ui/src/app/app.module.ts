import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LocationComponent } from './location/location.component';
import { BooklistComponent } from './booklist/booklist.component';
import { AdminComponent } from './admin/admin.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import { NgMaterialModule } from './ng-material/ng-material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UpdateDialogComponent } from './update-dialog/update-dialog.component';
import { AddDialogComponent } from './add-dialog/add-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LocationComponent,
    BooklistComponent,
    AdminComponent,
    CheckoutComponent,
    LoginComponent,
    FooterComponent,
    HeaderComponent,
    UpdateDialogComponent,
    AddDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    NgMaterialModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'catalogue', component: BooklistComponent},
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ]
})
export class AppModule { }
