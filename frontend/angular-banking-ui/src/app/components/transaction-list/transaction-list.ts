import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-transaction-list',
  standalone: true,
  templateUrl: './transaction-list.html',
  styleUrl: './transaction-list.scss',
})
export class TransactionListComponent {
  @Input() title = 'Recent Activity';
  @Input() items: Array<{ label: string; detail: string; amount: string; type: string }> = [];
}
