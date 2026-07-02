import { Component } from '@angular/core';

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [],
  templateUrl: './customers.html',
  styleUrl: './customers.scss',
})
export class Customers {
  customers = [
    { name: 'Alicia Gomez', account: 'ACC-2048', balance: '$24,500', status: 'Active', segment: 'Premium' },
    { name: 'Mina Rahman', account: 'ACC-1180', balance: '$18,240', status: 'Review', segment: 'Business' },
    { name: 'Daniel Brooks', account: 'ACC-3021', balance: '$9,760', status: 'Active', segment: 'Retail' },
  ];
}
