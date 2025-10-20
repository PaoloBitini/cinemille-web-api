import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'cm-toolbar',
  standalone: false,
  templateUrl: './toolbar.component.html',
  styleUrl: './toolbar.component.scss'
})
export class ToolbarComponent {

  @Input() title: string = "";

  @Output() menuButtonClicked: EventEmitter<void> = new EventEmitter<void>();

  emitEvent() {
    this.menuButtonClicked.emit();
  }
}
