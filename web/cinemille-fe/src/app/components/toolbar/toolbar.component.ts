import { Component, Input } from '@angular/core';

@Component({
  selector: 'cm-toolbar',
  standalone: false,
  templateUrl: './toolbar.component.html',
  styleUrl: './toolbar.component.scss'
})
export class ToolbarComponent {
  @Input() title: string = "";
}
