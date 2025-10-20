import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { PagesModule } from './pages/pages.module';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, PagesModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'Cine1000';

  isSidenavOpen: boolean = false;

  handleSidenav() {
    this.isSidenavOpen = !this.isSidenavOpen;
  }
}
