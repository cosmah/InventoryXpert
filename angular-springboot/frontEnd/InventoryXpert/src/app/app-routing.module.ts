import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddCustomerComponent } from './people/cus/add-customer/add-customer.component';
import { PeopleComponent } from './people/people/people.component';
import { CustomerComponent } from './people/cus/customer/customer.component';
import { UpdateCustomerComponent } from './people/cus/update-customer/update-customer.component';
import { AddSrComponent } from './people/sr/add-sr/add-sr.component';
import { SalesmanComponent } from './people/sr/salesman/salesman.component';
import { UpdateSrComponent } from './people/sr/update-sr/update-sr.component';
import { AddSupplierComponent } from './people/sup/add-supplier/add-supplier.component';
import { SuppliersComponent } from './people/sup/suppliers/suppliers.component';
import { UpdateSupplierComponent } from './people/sup/update-supplier/update-supplier.component';
import { CreateRecieptComponent } from './transactions/create-reciept/create-reciept.component';
import { AddpaymentComponent } from './transactions/addpayment/addpayment.component';
import { AddStockComponent } from './inventory/add-stock/add-stock.component';
import { StockComponent } from './inventory/stock/stock.component';
import { UpdateStockComponent } from './inventory/update-stock/update-stock.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'add-customer', component: AddCustomerComponent},
  { path: 'people', component: PeopleComponent},

  //customer components
  { path: 'add-customer', component: AddCustomerComponent},
  { path: 'customer', component: CustomerComponent},
  { path: 'update-customer', component: UpdateCustomerComponent},

  //salesmen components
  { path: 'add-sr', component: AddSrComponent},
  { path: 'salesman', component: SalesmanComponent},
  { path: 'update-sr', component: UpdateSrComponent},

  //supplier components
  { path: 'add-supplier', component: AddSupplierComponent},
  { path: 'suppliers', component: SuppliersComponent},
  { path: 'update-supplier', component: UpdateSupplierComponent},

  //RECIEPT
  {path:'create-reciept', component: CreateRecieptComponent},
  //payment
  {path: 'addpayment', component: AddpaymentComponent},

  //inventory
  {path:'add-stock', component: AddStockComponent},
  {path:'stock', component: StockComponent},
  {path:'update-stock', component: UpdateStockComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
