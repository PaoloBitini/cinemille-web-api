import { Component, Input } from '@angular/core';

@Component({
  selector: 'cm-sidenav',
  standalone: false,
  templateUrl: './sidenav.component.html',
  styleUrl: './sidenav.component.scss'
})
export class SidenavComponent {

  @Input() isOpen = false;
}
