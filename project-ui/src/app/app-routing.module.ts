import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LocationComponent } from './location/location.component';
import { BooklistComponent } from './booklist/booklist.component';
import { AdminComponent } from './admin/admin.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'location', component: LocationComponent },
  { path: 'booklist', component: BooklistComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
