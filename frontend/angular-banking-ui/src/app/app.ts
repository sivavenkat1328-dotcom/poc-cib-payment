import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  template: `
    <div class="app-shell">
      <aside class="sidebar">
        <div>
          <h2>CIB Banking</h2>
          <p>Realtime operations</p>
        </div>
        <nav class="nav-links">
          <a routerLink="/dashboard" routerLinkActive="active">Dashboard</a>
          <a routerLink="/customers" routerLinkActive="active">Customers</a>
          <a routerLink="/login" routerLinkActive="active">Login</a>
        </nav>
      </aside>

      <main class="main-panel">
        <router-outlet></router-outlet>
      </main>
    </div>
  `,
  styleUrl: './app.scss'
})
export class AppComponent {
  title = 'CIB AI Payment Platform';
}