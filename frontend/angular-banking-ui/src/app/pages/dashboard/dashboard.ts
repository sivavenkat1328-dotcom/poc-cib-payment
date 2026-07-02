import { Component } from '@angular/core';
import { StatCardComponent } from '../../components/stat-card/stat-card';
import { TransactionListComponent } from '../../components/transaction-list/transaction-list';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [StatCardComponent, TransactionListComponent],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
})
export class Dashboard {
  stats = [
    { icon: '💳', title: 'Checking Balance', value: '$84,320.50', trend: '+5.2% this week', accent: 'blue' },
    { icon: '⚡', title: 'Live Transfers', value: '1,248', trend: '+12 today', accent: 'green' },
    { icon: '🛡️', title: 'Fraud Alerts', value: '3', trend: '2 resolved', accent: 'orange' },
    { icon: '🌐', title: 'AI Insights', value: '94%', trend: 'Optimized', accent: 'purple' },
  ];

  transactions = [
    { label: 'Salary Deposit', detail: 'CIB Payroll • 09:42', amount: '+$8,500.00', type: 'positive' },
    { label: 'Invoice Payment', detail: 'Global Tech • 08:15', amount: '-$1,240.00', type: 'negative' },
    { label: 'FX Settlement', detail: 'USD/EUR • 07:30', amount: '+$320.00', type: 'positive' },
  ];

  customers = [
    { name: 'Alicia Gomez', account: 'ACC-2048', risk: 'Low' },
    { name: 'Mina Rahman', account: 'ACC-1180', risk: 'Medium' },
  ];
}
