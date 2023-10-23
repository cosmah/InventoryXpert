import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FoldableModule } from 'ngx-foldable';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ShortcutsComponent } from './shortcuts/shortcuts.component';
import { SalesmanComponent } from './people/sr/salesman/salesman.component';
import { CustomerComponent } from './people/cus/customer/customer.component';
import { SupplierComponent } from './supplier/supplier.component';
import { AddCustomerComponent } from './people/cus/add-customer/add-customer.component';
import { UpdateCustomerComponent } from './people/cus/update-customer/update-customer.component';
import { UpdateSrComponent } from './people/sr/update-sr/update-sr.component';
import { AddSrComponent } from './people/sr/add-sr/add-sr.component';
import { AddSupplierComponent } from './people/sup/add-supplier/add-supplier.component';
import { SuppliersComponent } from './people/sup/suppliers/suppliers.component';
import { UpdateSupplierComponent } from './people/sup/update-supplier/update-supplier.component';
import { PeopleComponent } from './people/people/people.component';
import { StockComponent } from './stock/stock.component';
import { InventoryComponent } from './inventory/inventory.component';
import { AddStockComponent } from './inventory/add-stock/add-stock.component';
import { UpdateStockComponent } from './inventory/update-stock/update-stock.component';
import { CreateRecieptComponent } from './transactions/create-reciept/create-reciept.component';
import { AddpaymentComponent } from './transactions/addpayment/addpayment.component';

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
    AddCustomerComponent,
    UpdateCustomerComponent,
    UpdateSrComponent,
    AddSrComponent,
    AddSupplierComponent,
    SuppliersComponent,
    UpdateSupplierComponent,
    PeopleComponent,
    StockComponent,
    InventoryComponent,
    AddStockComponent,
    UpdateStockComponent,
    CreateRecieptComponent,
    AddpaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FoldableModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
