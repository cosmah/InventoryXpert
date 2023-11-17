import { Component } from '@angular/core';

@Component({
  selector: 'app-create-reciept',
  templateUrl: './create-reciept.component.html',
  styleUrls: ['./create-reciept.component.css']
})
export class CreateRecieptComponent {
  customerName: string = '';
  date: string = '';
  terms: string = '';
  salesRep: string = '';
  orders: { item: string, description: string, quantity: number, unitPrice: number }[] = [];

  submitReceipt() {
    // Handle form submission here, you can send the data to an API, etc.
    console.log("Receipt submitted:", this.customerName, this.date, this.terms, this.salesRep, this.orders);
  }

  addOrderRow() {
    this.orders.push({ item: '', description: '', quantity: 0, unitPrice: 0 });
  }

  cancelReceipt() {
    // Implement cancel logic if needed
  }
}
