import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-stat-card',
  standalone: true,
  templateUrl: './stat-card.html',
  styleUrl: './stat-card.scss',
})
export class StatCardComponent {
  @Input() icon = '📈';
  @Input() title = 'Balance';
  @Input() value = '$0';
  @Input() trend = '+0%';
  @Input() accent = 'blue';
}
