import { Component } from '@angular/core';
import { ProgrammazioniService } from '../../services/programmazioni.service';
import { Programmazione } from '../../models/programmazione';
import { Page } from '../../models/page';

@Component({
  selector: 'cm-programmazioni-page',
  standalone: false,
  templateUrl: './programmazioni-page.component.html',
  styleUrl: './programmazioni-page.component.scss'
})
export class ProgrammazioniPageComponent {
  constructor(private progService: ProgrammazioniService) { }

  data: any;

  ngOnInit(): void {
    this.progService.getProgrammazioniPaginated().subscribe({
      next: (el: Page<Programmazione>) => {
        this.data = el;
      }
    })
  }
}
