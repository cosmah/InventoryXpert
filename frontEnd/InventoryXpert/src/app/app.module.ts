import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FoldableModule } from 'ngx-foldable';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ShortcutsComponent } from './shortcuts/shortcuts.component';
import { SalesmanComponent } from './salesman/salesman.component';
import { CustomerComponent } from './customer/customer.component';
import { SupplierComponent } from './supplier/supplier.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigatorComponent,
    DashboardComponent,
    ShortcutsComponent,
    SalesmanComponent,
    CustomerComponent,
    SupplierComponent,
    AddCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FoldableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
